package cookiedragon.csgohack.impl.hooks.process;

import com.github.jonatino.process.Module;
import com.github.jonatino.process.Process;
import com.github.jonatino.process.Processes;

/**
 * @author cookiedragon234 07/Nov/2019
 */
public class ProcessHook
{
	public static Process process;
	public static Module client;
	public static Module engine;
	
	public static void setup()
	{
		try
		{
			process = Processes.byName("csgo.exe");
			process.initModules();
			
			client = process.findModule("client_panorama.dll");
			engine = process.findModule("engine.dll");
			
			System.out.println("Successfully found csgo (PID: " + process.id() + ")");
		}
		catch(Exception e)
		{
			throw new IllegalStateException("Error hooking into csgo", e);
		}
	}
}
