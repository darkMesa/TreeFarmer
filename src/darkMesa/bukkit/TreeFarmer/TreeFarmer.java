package darkMesa.bukkit.TreeFarmer;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TreeFarmer extends JavaPlugin {
	public static final Logger log = Logger.getLogger("Minecraft");
	private final Events listener = new Events(this);

	public boolean saplock = false;
	public boolean breaksap = false;
	public byte dataid = 0;
	public int blockid = 6;

	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(listener, this);
		getConfig().options().copyDefaults(true);
		config();
        saveConfig();
	}

	private void config() {
		saplock = getConfig().getBoolean("one sappling");
		breaksap = getConfig().getBoolean("break sapplings");
		dataid = (byte) getConfig().getInt("sappling id");
	}
}
