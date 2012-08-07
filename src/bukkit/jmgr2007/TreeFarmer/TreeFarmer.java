package bukkit.jmgr2007.TreeFarmer;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TreeFarmer extends JavaPlugin {
	private final Events listener = new Events(this);
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(listener, this);
	}
	public void onDisable() {
		
	}
}
