package cookiedragon.csgohack.impl.hooks.offsets;

import java.util.HashMap;
import java.util.Map;

/**
 * @author cookiedragon234 07/Nov/2019
 */
public class NetVars
{
	private static final Map<String, Long> netVars = new HashMap<>();
	
	public static void put(String name, Long key)
	{
		netVars.put(name, key);
	}
	
	public static Long get(String name)
	{
		return netVars.get(name);
	}
	
	public static boolean contains(String name)
	{
		return netVars.containsKey(name);
	}
	
	public static String toStr1ng()
	{
		return netVars.toString();
	}
}
