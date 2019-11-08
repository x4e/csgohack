package cookiedragon.csgohack.impl.hooks.input;

import cookiedragon.csgohack.api.hack.Hack;
import cookiedragon.csgohack.impl.hack.HackManager;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

/**
 * @author cookiedragon234 07/Nov/2019
 */
public class KeyListener
{
	static class KeyCallback implements NativeKeyListener
	{
		@Override
		public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent)
		{
		
		}
		
		@Override
		public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent)
		{
			HackManager.getHacks().forEach(hack -> hack.onKeyPress(nativeKeyEvent));
		}
		
		@Override
		public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent)
		{
			HackManager.getHacks().forEach(hack -> hack.onKeyRelease(nativeKeyEvent));
		}
	}
}
