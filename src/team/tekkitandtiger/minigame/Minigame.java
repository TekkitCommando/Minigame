package team.tekkitandtiger.minigame;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import team.tekkitandtiger.minigame.commands.MGCommand;

public class Minigame extends JavaPlugin {
	
	/**
	 * TODO: EVERYTHING
	 */
	public void onEnable() {
		Bukkit.getServer().getLogger().info("[Minigame] Enabled!");
	}
	
	public void onDisable() {
		Bukkit.getServer().getLogger().info("[Minigame] Disabled!");
	}
	
	public void initCommands() {
		getCommand("mg").setExecutor(new MGCommand());
	}
}
