package com.trentsterling.sfxplayer;

import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Builder;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SFXPlayerPlugin extends JavaPlugin
{

	public void onEnable()
	{
		// getServer().getPluginManager().registerEvents(new SFXPackListener(), this);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{

		if (commandLabel.equalsIgnoreCase("party"))
		{

			if ((sender instanceof Player))
			{
				sender.sendMessage("This command can only be run by a CONSOLE.");
				return true;
			}

			shootFireworks();
			// world.playSound(player.getLocation(), Sound.LEVEL_UP, 10.0F, 10.0F);
			return true;
		}

		Player player = (Player) sender;
		World world = player.getWorld();

		if (commandLabel.equalsIgnoreCase("sfx"))
		{
			if (args.length == 0)
			{
				world.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
				player.sendMessage(ChatColor.DARK_PURPLE + "------SFXPack-Commands------");
				player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx party");
				player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx scare");
				player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx twinkle");
				player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx fuse");
				player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx scream");
				player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx thunder");
				player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx chest");
				player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx door");
				player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx snort");
				player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx enderman");
				player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx golem");
				player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx piano");
				player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx wither");
				player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx water");
				player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx place help");
				player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx help");
			}
			else
			{
				if (player.hasPermission("worldWideSoundFx"))
				{
					if (args[0].equalsIgnoreCase("party"))
					{
						shootFireworks();
						world.playSound(player.getLocation(), Sound.LEVEL_UP, 10.0F, 10.0F);
					}

					else if (args[0].equalsIgnoreCase("sound"))
					{
						if (args.length > 1)
						{
							boolean found = false;
							for (Sound snd : Sound.values())
							{
								if (snd.toString().equalsIgnoreCase(args[1]))
								{
									found = true;
									world.playSound(player.getLocation(), snd, 10.0F, 1.0F);
									//world.playSound(location, sound, volume, pitch);
								}
							}
							if (!found)
							{
								player.sendMessage("Sound not found!");
							}
						}

					}

					else if (args[0].equalsIgnoreCase("scare"))
					{
						world.playSound(player.getLocation(), Sound.EXPLODE, 5.0F, 5.0F);
						world.playSound(player.getLocation(), Sound.FIRE, 5.0F, 5.0F);
					}

					else if (args[0].equalsIgnoreCase("twinkle"))
					{
						world.playSound(player.getLocation(), Sound.LEVEL_UP, 5.0F, 5.0F);

					}
					else if (args[0].equalsIgnoreCase("fuse"))
					{
						world.playSound(player.getLocation(), Sound.FUSE, 5.0F, 5.0F);
					}
					else if (args[0].equalsIgnoreCase("scream"))
					{
						world.playSound(player.getLocation(), Sound.GHAST_MOAN, 5.0F, 5.0F);
					}
					else if (args[0].equalsIgnoreCase("thunder"))
					{
						world.playSound(player.getLocation(), Sound.AMBIENCE_THUNDER, 5.0F, 5.0F);
					}
					else if (args[0].equalsIgnoreCase("chest"))
					{
						world.playSound(player.getLocation(), Sound.CHEST_OPEN, 5.0F, 5.0F);
					}
					else if (args[0].equalsIgnoreCase("door"))
					{
						world.playSound(player.getLocation(), Sound.DOOR_OPEN, 5.0F, 5.0F);
					}
					else if (args[0].equalsIgnoreCase("snort"))
					{
						world.playSound(player.getLocation(), Sound.BURP, 5.0F, 5.0F);
					}
					else if (args[0].equalsIgnoreCase("enderman"))
					{
						world.playSound(player.getLocation(), Sound.ENDERMAN_SCREAM, 5.0F, 5.0F);
					}
					else if (args[0].equalsIgnoreCase("golem"))
					{
						world.playSound(player.getLocation(), Sound.IRONGOLEM_HIT, 5.0F, 5.0F);
					}
					else if (args[0].equalsIgnoreCase("piano"))
					{
						world.playSound(player.getLocation(), Sound.NOTE_PIANO, 5.0F, 5.0F);
					}
					else if (args[0].equalsIgnoreCase("portal"))
					{
						world.playSound(player.getLocation(), Sound.PORTAL, 5.0F, 5.0F);
					}
					else if (args[0].equalsIgnoreCase("wither"))
					{
						world.playSound(player.getLocation(), Sound.WITHER_IDLE, 5.0F, 5.0F);
					}
					else if (args[0].equalsIgnoreCase("water"))
					{
						world.playSound(player.getLocation(), Sound.WATER, 5.0F, 5.0F);
					}
				}
				if (args[0].equalsIgnoreCase("help"))
				{
					world.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
					player.sendMessage(ChatColor.DARK_PURPLE + "------SFXPack-Commands------");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx party");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx scare");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx twinkle");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx fuse");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx scream");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx thunder");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx chest");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx door");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx snort");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx enderman");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx golem");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx piano");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx wither");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx water");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx step help");
					player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx help");
				}
				else if ((args[0].equalsIgnoreCase("step")) && (player.hasPermission("worldWideSoundFx")))
				{
					if (args[1].equalsIgnoreCase("dirt"))
					{
						world.playSound(player.getLocation(), Sound.STEP_GRASS, 5.0F, 5.0F);
					}
					else if (args[1].equalsIgnoreCase("stone"))
					{
						world.playSound(player.getLocation(), Sound.STEP_STONE, 5.0F, 5.0F);
					}
					else if (args[1].equalsIgnoreCase("wood"))
					{
						world.playSound(player.getLocation(), Sound.STEP_WOOD, 5.0F, 5.0F);
					}
					else if (args[1].equalsIgnoreCase("wool"))
					{
						world.playSound(player.getLocation(), Sound.STEP_WOOL, 5.0F, 5.0F);
					}
					else if (args[1].equalsIgnoreCase("snow"))
					{
						world.playSound(player.getLocation(), Sound.STEP_SNOW, 5.0F, 5.0F);
					}
					else if (args[1].equalsIgnoreCase("help"))
					{
						world.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
						player.sendMessage(ChatColor.DARK_PURPLE + "------SFXPack-step-Commands------");
						player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx step dirt");
						player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx step stone");
						player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx step wood");
						player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx step wool");
						player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx step snow");
						player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx step help");
						player.sendMessage(ChatColor.LIGHT_PURPLE + "/sfx help");
					}
				}
			}
		}

		return true;
	}

	private void shootFireworks()
	{
		for (Player player : Bukkit.getOnlinePlayers())
		{
			Firework fw = (Firework) player.getWorld().spawn(player.getLocation(), Firework.class);
			FireworkMeta fm = fw.getFireworkMeta();
			Random r = new Random();
			int fType = r.nextInt(4) + 1;
			FireworkEffect.Type type = null;
			switch (fType)
			{
			case 1:
			default:
				type = FireworkEffect.Type.BALL;
				break;
			case 2:
				type = FireworkEffect.Type.BALL_LARGE;
				break;
			case 3:
				type = FireworkEffect.Type.BURST;
				break;
			case 4:
				type = FireworkEffect.Type.CREEPER;
				break;
			case 5:
				type = FireworkEffect.Type.STAR;
			}
			int c1i = r.nextInt(16) + 1;
			int c2i = r.nextInt(16) + 1;
			Color c1 = getColour(c1i);
			Color c2 = getColour(c2i);
			FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor(c1).withFade(c2).with(type).trail(r.nextBoolean()).build();
			fm.addEffect(effect);
			int power = r.nextInt(2) + 1;
			fm.setPower(power);
			fw.setFireworkMeta(fm);
		}
	}

	public Color getColour(int c)
	{
		switch (c)
		{
		case 1:
		default:
			return Color.AQUA;
		case 2:
			return Color.BLACK;
		case 3:
			return Color.BLUE;
		case 4:
			return Color.FUCHSIA;
		case 5:
			return Color.GRAY;
		case 6:
			return Color.GREEN;
		case 7:
			return Color.LIME;
		case 8:
			return Color.MAROON;
		case 9:
			return Color.NAVY;
		case 10:
			return Color.OLIVE;
		case 11:
			return Color.PURPLE;
		case 12:
			return Color.RED;
		case 13:
			return Color.SILVER;
		case 14:
			return Color.TEAL;
		case 15:
			return Color.WHITE;
		case 16:
		}
		return Color.YELLOW;
	}
}
