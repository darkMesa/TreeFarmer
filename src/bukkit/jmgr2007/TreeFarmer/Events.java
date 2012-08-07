package bukkit.jmgr2007.TreeFarmer;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Events implements Listener {
	public static TreeFarmer plugin;
	public Configuration config;

	public Events(TreeFarmer instance) {
		plugin = instance;
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent Event) {
		if (Event.getBlock().getType() == Material.LOG) {
			int x = Event.getBlock().getX();
			int y = Event.getBlock().getY();
			int z = Event.getBlock().getZ();
			y = y - 1;
			if (Event.getBlock().getWorld().getBlockAt(x, y, z).getType() == Material.DIRT) {
				ItemStack droppedItem = new ItemStack(Event.getBlock()
						.getType(), 1, Event.getBlock().getData());
				Event.getBlock().setTypeIdAndData(6, (byte) 2, false);
				Event.getBlock().getWorld()
						.dropItem(Event.getBlock().getLocation(), droppedItem);
			}
		}
		if (Event.getBlock().getType() == Material.SAPLING) {
			int x = Event.getBlock().getX();
			int y = Event.getBlock().getY();
			int z = Event.getBlock().getZ();
			y = y - 1;

			if (Event.getBlock().getWorld().getBlockAt(x, y, z).getType() == Material.DIRT
					|| Event.getBlock().getWorld().getBlockAt(x, y, z)
							.getType() == Material.GRASS) {
				Event.setCancelled(true);
				Event.getPlayer().sendMessage(
						ChatColor.RED + "This block cannot be broken!");
			}
		}
	}
}
