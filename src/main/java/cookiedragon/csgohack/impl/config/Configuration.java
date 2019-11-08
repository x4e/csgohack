package cookiedragon.csgohack.impl.config;

import java.io.File;

/**
 * @author cookiedragon234 07/Nov/2019
 */
public class Configuration
{
	private static final File configFile = new File("config.json");
	private static final File sigFile = new File("offsets.json");
	
	public static void load()
	{
		// First load offsets
		OffsetsConfiguration.load();
		ClassIDConfig.load();
	}
}
