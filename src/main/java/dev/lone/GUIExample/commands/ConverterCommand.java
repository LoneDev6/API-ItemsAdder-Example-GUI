package dev.lone.GUIExample.commands;

import dev.lone.itemsadder.api.FontImages.FontImageWrapper;
import dev.lone.itemsadder.api.FontImages.TexturedInventoryWrapper;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.Plugin;

public class ConverterCommand implements CommandExecutor
{
    Plugin plugin;

    public ConverterCommand(Plugin plugin)
    {
        this.plugin = plugin;

        Bukkit.getPluginCommand("guiconvert").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args)
    {
        if(args.length != 1)
        {
            commandSender.sendMessage("Please specify a player name. /guiconvert <player>");
            return true;
        }

        Player player = Bukkit.getPlayer(args[0]);
        if(player == null)
        {
            commandSender.sendMessage("Cannot find player " + args[0]);
            return true;
        }


        if(player.getOpenInventory().getType() == InventoryType.CRAFTING)
        {
            commandSender.sendMessage("No open inventory, please open an inventory and execute the command.");
            return true;
        }

        FontImageWrapper texture = new FontImageWrapper("mcguis:blank_menu");
        if(!texture.exists())
        {
            commandSender.sendMessage("Cannot find this texture, please make sure you have it in your data folder of ItemsAdder (items_packs and resource_pack)");
            return true;
        }

        TexturedInventoryWrapper.setPlayerInventoryTexture(player, texture, ChatColor.BLACK + "Test");

        return true;
    }

}