package cookiedragon.csgohack.impl.hooks.offsets;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cookiedragon234 07/Nov/2019
 */
public class Offsets
{
	private static final Map<String, Long> offsets = new HashMap<>();
	
	public static void put(String name, Long key)
	{
		offsets.put(name, key);
	}
	
	public static Long get(String name)
	{
		return offsets.get(name);
	}
	
	public static boolean contains(String name)
	{
		return offsets.containsKey(name);
	}
}
