package xyz.hyperspark.vanguard.events.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerLoginEvent
import xyz.hyperspark.vanguard.models.PingHistory
import java.util.logging.Logger

class ServerJoinListener(
    private val pingHistory: PingHistory,
    private val logger: Logger,
): Listener {
    @EventHandler
    fun onServerJoinEvent(evt: PlayerLoginEvent) {
        pingHistory.removeExpired()

        val playerIp = evt.address

        this.logger.info("Player join request received from " + evt.address.toString())

        if (!pingHistory.contains(playerIp)) {
            this.logger.info("Player not allowed from " + evt.address.toString())

            evt.result = PlayerLoginEvent.Result.KICK_OTHER
            evt.player.kickPlayer("Server offline.");
        }

        this.logger.info("Player access granted from " + evt.address.toString())
    }
}