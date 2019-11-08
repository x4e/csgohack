package cookiedragon.csgohack.impl.hack.hacks;

import cookiedragon.csgohack.api.hack.Hack;
import cookiedragon.csgohack.impl.hooks.offsets.NetVars;
import cookiedragon.csgohack.impl.hooks.offsets.Offsets;
import cookiedragon.csgohack.impl.hooks.process.ProcessHook;
import org.jnativehook.keyboard.NativeKeyEvent;

import java.util.Objects;

/**
 * @author cookiedragon234 07/Nov/2019
 */
public class BunnyHopHack extends Hack
{
	public BunnyHopHack()
	{
		super("Bunny Hop", "Jump like a bunny to achieve f1 speeds");
	}
	
	long lastStat = -100;
	
	@Override
	public void onLogic()
	{
		// Tried to only make it activate when on ground but couldnt find the on ground offset
		//if(this.getEnabled())
		{
			long jump = Offsets.get("dwForceJump");
			//if((playerFlags & 1) != 0)
			{
				ProcessHook.client.writeInt(jump, 6);
				//System.out.println("Jumped");
				return;
			}
			//else
			//{
				//ProcessHook.client.writeInt(jump, 4);
				//System.out.println("Jumped");
			//}
		}
	}
	
	@Override
	public void onKeyPress(NativeKeyEvent event)
	{
		if(event.getKeyCode() == NativeKeyEvent.VC_SPACE)
			this.setEnabled(true);
	}
	
	@Override
	public void onKeyRelease(NativeKeyEvent event)
	{
		if(event.getKeyCode() == NativeKeyEvent.VC_SPACE)
			this.setEnabled(false);
	}
}
