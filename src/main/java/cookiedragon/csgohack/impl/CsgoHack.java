package cookiedragon.csgohack.impl;

import cookiedragon.csgohack.api.hack.Hack;
import cookiedragon.csgohack.impl.config.Configuration;
import cookiedragon.csgohack.impl.hack.HackManager;
import cookiedragon.csgohack.impl.hooks.input.InputHooks;
import cookiedragon.csgohack.impl.hooks.offsets.NetVars;
import cookiedragon.csgohack.impl.hooks.offsets.Offsets;
import cookiedragon.csgohack.impl.hooks.process.ProcessHook;
import org.jnativehook.GlobalScreen;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author cookiedragon234 07/Nov/2019
 */
public class CsgoHack
{
	public CsgoHack()
	{
		System.out.println("Starting...");
		
		Configuration.load();
		
		// Disable the annoying logging that the native hook makes
		Logger.getLogger(GlobalScreen.class.getPackage().getName()).setLevel(Level.OFF);
		
		InputHooks.register();
		ProcessHook.setup();
		
		// Tried to synchronise hack tick rate and client tick rate, couldnt get it to work :(
		//long lastTickCount = 0;
		//Long globalVars = Offsets.get("dwGlobalVars");
		while(true)
		{
			//long currentTickCount = ProcessHook.client.readUnsignedInt(globalVars + 0x1F);
			//if(currentTickCount > lastTickCount)
			
			HackManager.getHacks().forEach(Hack::onLogic);
		}
	}
}
