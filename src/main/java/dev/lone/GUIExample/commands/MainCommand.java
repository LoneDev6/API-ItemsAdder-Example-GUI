package dev.lone.GUIExample.commands;

import dev.lone.itemsadder.api.FontImages.FontImageWrapper;
import dev.lone.itemsadder.api.FontImages.TexturedInventoryWrapper;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class MainCommand implements CommandExecutor
{
    Plugin plugin;

    public MainCommand(Plugin plugin)
    {
        this.plugin = plugin;

        Bukkit.getPluginCommand("guiexample").setExecutor(this);

    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args)
    {
        if(!(commandSender instanceof Player))
            return true;

        Player player = (Player) commandSender;

        TexturedInventoryWrapper inventory = new TexturedInventoryWrapper(null,
                                                                          54,
                                                                          ChatColor.BLACK + "Test",
                                                                          new FontImageWrapper("mcguis:blank_menu")
        );
        inventory.showInventory(player);

        return true;
    }

}