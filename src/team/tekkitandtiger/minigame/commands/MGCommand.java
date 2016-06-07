package team.tekkitandtiger.minigame.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import team.tekkitandtiger.minigame.GameState;
import team.tekkitandtiger.minigame.PlayerQueue;

public class MGCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {
		if(cmd.getName().equalsIgnoreCase("mg")) {
			if(args.length == 0) {
				if(!(sender instanceof Player)) {
					sender.sendMessage("You cannot use this command!");
				} else {
					if(args.length == 0) {
						sender.sendMessage(ChatColor.BLUE + "[Minigame] Do /mg join to join a game!");
						return true;
					} else if(args.length == 1) {
						switch(args[0]) {
						case "join":
							if(GameState.getCurrentState() == GameState.LOBBY_STATE) {
								PlayerQueue.addPlayer(sender.getName());
								Bukkit.broadcastMessage(ChatColor.BLUE + "[Minigame] Player " + sender.getName() + " has been added to the game!");
								break;
							} else {
								sender.sendMessage(ChatColor.RED + "[Minigame] You cannot join the game while state is not LOBBY_STATE");
								break;
							}
						case "leave":
							Bukkit.broadcastMessage(ChatColor.BLUE + "[Minigame] Player " + sender.getName() + " has left the game!");
							break;
						case "stats":
							sender.sendMessage(ChatColor.BLUE + "===== STATS =====");
							break;
						default:
							sender.sendMessage(ChatColor.RED + "[Minigame] Unknown Command!");
						}
					}
				}
			}
		}
		return true;
	}

}
