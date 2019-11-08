package cookiedragon.csgohack.api.hack;

import org.jnativehook.keyboard.NativeKeyEvent;

/**
 * @author cookiedragon234 07/Nov/2019
 */
public abstract class Hack
{
	public final String name;
	public final String description;
	
	private boolean enabled;
	
	public Hack(String name, String description)
	{
		this.name = name;
		this.description = description;
	}
	
	public void setEnabled(boolean enabled)
	{
		this.enabled = enabled;
		
		if(enabled)
			onEnabled();
		else
			onDisabled();
	}
	
	public boolean getEnabled()
	{
		return enabled;
	}
	
	public boolean toggle()
	{
		setEnabled(!getEnabled());
		return getEnabled();
	}
	
	public void onLogic() {}
	public void onKeyPress(NativeKeyEvent event) {}
	public void onKeyRelease(NativeKeyEvent event) {}
	protected void onEnabled() {}
	protected void onDisabled() {}
}
