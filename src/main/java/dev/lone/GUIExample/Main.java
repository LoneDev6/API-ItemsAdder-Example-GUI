package dev.lone.GUIExample;

import dev.lone.GUIExample.commands.MainCommand;
import dev.lone.GUIExample.commands.ConverterCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        new MainCommand(this);
        new ConverterCommand(this);
    }

    @Override
    public void onDisable()
    {
    }
}
