package cookiedragon.csgohack.impl.config;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/**
 * Stores ids of each entity class
 * @author cookiedragon234 07/Nov/2019
 */
public class ClassIDConfig
{
	private static final String classIDFile = "classids.txt";
	public static final Map<String, Integer> classIDs = new HashMap<>();
	
	public static void load()
	{
		try
		{
			File file = new File(classIDFile);
			
			assert file.exists();
			
			BufferedReader is = new BufferedReader(new FileReader(file));
			
			AtomicInteger id = new AtomicInteger(1);
			AtomicBoolean foundAK = new AtomicBoolean(false);
			
			is.lines().forEach(line ->
			{
				if(!foundAK.get())
				{
					if(line.contains("CAK47"))
						foundAK.set(true);
				}
				
				if(foundAK.get())
				{
					classIDs.put(line.trim().split(Pattern.quote("("))[0], id.get());
					id.getAndIncrement();
				}
			});
			
			is.close();
			
			System.out.println("Successfully loaded " + classIDs.size() + " classIDs");
		}
		catch(Exception e)
		{
			throw new IllegalStateException("Error while loading class IDs", e);
		}
	}
}
