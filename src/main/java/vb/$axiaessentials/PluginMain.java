package vb.$axiaessentials;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;

	@Override
	public void onEnable() {
		instance = this;
		getDataFolder().mkdir();
		getServer().getPluginManager().registerEvents(this, this);
		try {
			Object $1d54c05a0a35497474b7a9168e3bbaed = null;
			((org.bukkit.command.CommandSender) (Object) org.bukkit.Bukkit.getConsoleSender())
					.sendMessage(((java.lang.String[]) ((Collection) $1d54c05a0a35497474b7a9168e3bbaed)
							.toArray(new java.lang.String[]{})));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDisable() {
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("fly")) {
			Object $ef5705f474d7a5c39f8edb6ad6c16477 = null;
			try {
				if ((commandSender instanceof org.bukkit.entity.Player)) {
					((org.bukkit.entity.Player) (Object) commandSender)
							.setAllowFlight((!((org.bukkit.entity.Player) (Object) commandSender).getAllowFlight()));
					commandSender.sendMessage(((java.lang.String[]) (Object) (ChatColor.translateAlternateColorCodes(
							'&', String.valueOf(PluginMain.getInstance().getConfig().get("flight.message")))
							+ String.valueOf(((org.bukkit.entity.Player) (Object) commandSender).getAllowFlight()))));
				} else {
					commandSender.sendMessage(((java.lang.String[]) ((Collection) $ef5705f474d7a5c39f8edb6ad6c16477)
							.toArray(new java.lang.String[]{})));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		if (command.getName().equalsIgnoreCase("damage")) {
			try {
				org.bukkit.Bukkit.broadcastMessage(
						ChatColor.translateAlternateColorCodes('&', "&b&lSERVER \u25B6\u25B6 &cDamaged yourself"));
				((org.bukkit.entity.Damageable) (Object) commandSender).damage(5d);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		if (command.getName().equalsIgnoreCase("feed")) {
			try {
				((org.bukkit.entity.HumanEntity) (Object) commandSender).setFoodLevel(((int) 20d));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		if (command.getName().equalsIgnoreCase("heal")) {
			try {
				org.bukkit.Bukkit.broadcastMessage(
						ChatColor.translateAlternateColorCodes('&', "&b&lSERVER \u25B6\u25B6 &aHealed Yourself"));
				((org.bukkit.entity.Damageable) (Object) commandSender).setHealth(20d);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		if (command.getName().equalsIgnoreCase("gms")) {
			try {
				org.bukkit.Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
						"&b&lSERVER \u25B6\u25B6 &f&lChanged your gamemode to &csurvival!"));
				((org.bukkit.entity.HumanEntity) (Object) commandSender).setGameMode(org.bukkit.GameMode.SURVIVAL);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		if (command.getName().equalsIgnoreCase("gmc")) {
			try {
				org.bukkit.Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
						"&b&lSERVER \u25B6\u25B6 &f&lChanged your gamemode to &acreative!"));
				((org.bukkit.entity.HumanEntity) (Object) commandSender).setGameMode(org.bukkit.GameMode.CREATIVE);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return true;
	}

	public static void procedure(String procedure, List procedureArgs) throws Exception {
	}

	public static Object function(String function, List functionArgs) throws Exception {
		return null;
	}

	public static List createList(Object obj) {
		if (obj instanceof List) {
			return (List) obj;
		}
		List list = new ArrayList<>();
		if (obj.getClass().isArray()) {
			int length = java.lang.reflect.Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				list.add(java.lang.reflect.Array.get(obj, i));
			}
		} else if (obj instanceof Collection<?>) {
			list.addAll((Collection<?>) obj);
		} else if (obj instanceof Iterator) {
			((Iterator<?>) obj).forEachRemaining(list::add);
		} else {
			list.add(obj);
		}
		return list;
	}

	public static void createResourceFile(String path) {
		Path file = getInstance().getDataFolder().toPath().resolve(path);
		if (Files.notExists(file)) {
			try (InputStream inputStream = PluginMain.class.getResourceAsStream("/" + path)) {
				Files.createDirectories(file.getParent());
				Files.copy(inputStream, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static PluginMain getInstance() {
		return instance;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerChatEvent1(org.bukkit.event.player.PlayerChatEvent event) throws Exception {
		Object $262bca9a3ca6a66a504b518d9f34553c = null;
		event.setFormat(
				(ChatColor.translateAlternateColorCodes('&', "&7[&a+&7] ") + String.valueOf(event.getPlayer())));
		if (((org.bukkit.permissions.Permissible) (Object) event.getPlayer())
				.hasPermission(((org.bukkit.permissions.Permission) (Object) $262bca9a3ca6a66a504b518d9f34553c))) {
			event.setFormat((ChatColor.translateAlternateColorCodes('&', "&b&lSTAFF &7| &b")
					+ String.valueOf(event.getPlayer())));
		}
	}
}
