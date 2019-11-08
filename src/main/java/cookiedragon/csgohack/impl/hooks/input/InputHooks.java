package cookiedragon.csgohack.impl.hooks.input;

import org.jnativehook.GlobalScreen;

/**
 * @author cookiedragon234 07/Nov/2019
 */
public class InputHooks
{
	public static void register()
	{
		try
		{
			GlobalScreen.registerNativeHook();
			
			KeyListener.KeyCallback keyCallback = new KeyListener.KeyCallback();
			MouseListener.MouseCallback mouseCallback = new MouseListener.MouseCallback();
			GlobalScreen.addNativeKeyListener(keyCallback);
			GlobalScreen.addNativeMouseListener(mouseCallback);
			
			Runtime.getRuntime().addShutdownHook(new Thread(() ->
			{
				GlobalScreen.removeNativeKeyListener(keyCallback);
				GlobalScreen.removeNativeMouseListener(mouseCallback);
			}));
			
			System.out.println("Successfully registered input hooks");
		}
		catch(Exception e)
		{
			throw new IllegalStateException("Error while registering native hook", e);
		}
	}
}
