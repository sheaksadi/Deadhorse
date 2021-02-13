package me.sheak.sadi;

import me.sheak.sadi.events.DeadHorse;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

    public class Main extends JavaPlugin {
        @Override
        public void onEnable() {
            getServer().getPluginManager().registerEvents(new DeadHorse(),this);
            getServer().getConsoleSender().sendMessage(ChatColor.GREEN+"Zombie horse plugin is workink");
        }

        @Override
        public void onDisable() {

        }

    }

