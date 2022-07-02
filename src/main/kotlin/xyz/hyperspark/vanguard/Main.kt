package xyz.hyperspark.vanguard

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import xyz.hyperspark.vanguard.events.EventManager
import xyz.hyperspark.vanguard.events.listeners.ServerJoinListener
import xyz.hyperspark.vanguard.events.listeners.ServerListListener
import xyz.hyperspark.vanguard.models.PingHistory

class Main: JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
        super.onEnable();

        val eventManager = EventManager(this, Bukkit.getPluginManager())
        val pingHistory = PingHistory()

        eventManager.registerListener(ServerListListener(pingHistory, this.logger))
        eventManager.registerListener(ServerJoinListener(pingHistory, this.logger))
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
