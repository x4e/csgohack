package cookiedragon.csgohack.impl.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import cookiedragon.csgohack.impl.hooks.offsets.NetVars;
import cookiedragon.csgohack.impl.hooks.offsets.Offsets;

import java.net.URL;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;

/**
 * @author cookiedragon234 07/Nov/2019
 */
public class OffsetsConfiguration
{
	private static final String offsetLoc = "https://raw.githubusercontent.com/frk1/hazedumper/master/csgo.json";
	private static JsonObject offsetObj;
	
	public static void load()
	{
		// This will load the latest csgo offsets from https://github.com/frk1/hazedumper/
		try
		{
			URL url = new URL(offsetLoc);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			
			int status = httpConn.getResponseCode();
			if(
				status == HttpURLConnection.HTTP_MOVED_PERM
				||
				status == HttpURLConnection.HTTP_MOVED_TEMP
				||
				status == HttpURLConnection.HTTP_SEE_OTHER
			)
			{
				url = new URL(httpConn.getHeaderField("Location"));
				
				System.out.println("Redirected to " + url + " when fetching offsets");
				
				httpConn = (HttpURLConnection) url.openConnection();
				httpConn.setRequestProperty("Cookie", httpConn.getHeaderField("Set-Cookie"));
			}
			
			InputStreamReader reader = new InputStreamReader(httpConn.getInputStream());
			offsetObj = JsonParser.parseReader(reader).getAsJsonObject();
			
			storeAllSigs(offsetObj.get("signatures").getAsJsonObject());
			storeAllNetVars(offsetObj.get("netvars").getAsJsonObject());
			
			System.out.println("Successfully loaded offsets from "
				+
				ChronoUnit.DAYS.between(
					Instant.ofEpochSecond(offsetObj.get("timestamp").getAsLong()),
					Instant.now()
				)
				+
				" days ago"
			);
		}
		catch(Exception e)
		{
			throw new IllegalStateException("Failed to download offsets", e);
		}
	}
	
	private static void storeAllSigs(JsonObject jsonObject)
	{
		for(Map.Entry<String, JsonElement> entry : jsonObject.entrySet())
		{
			Offsets.put(entry.getKey(), entry.getValue().getAsLong());
		}
	}
	
	private static void storeAllNetVars(JsonObject jsonObject)
	{
		for(Map.Entry<String, JsonElement> entry : jsonObject.entrySet())
		{
			NetVars.put(entry.getKey(), entry.getValue().getAsLong());
		}
	}
}
