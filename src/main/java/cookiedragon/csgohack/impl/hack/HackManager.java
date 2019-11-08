package cookiedragon.csgohack.impl.hack;

import cookiedragon.csgohack.api.hack.Hack;
import cookiedragon.csgohack.impl.hack.hacks.BunnyHopHack;

import java.util.HashSet;
import java.util.Set;

/**
 * @author cookiedragon234 07/Nov/2019
 */
public class HackManager
{
	private static final Set<Hack> hacks = new HashSet<>();
	
	static
	{
		hacks.add(new BunnyHopHack());
	}
	
	public static Set<Hack> getHacks()
	{
		return hacks;
	}
}
