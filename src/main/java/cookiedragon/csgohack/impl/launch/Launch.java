package cookiedragon.csgohack.impl.launch;

import cookiedragon.csgohack.impl.CsgoHack;

/**
 * @author cookiedragon234 07/Nov/2019
 */
public class Launch
{
	public static void main(String[] args)
	{
		try
		{
			new CsgoHack();
		}
		catch(Throwable t)
		{
			t.printStackTrace();
			System.exit(-1);
		}
	}
}
