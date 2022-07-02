package xyz.hyperspark.vanguard.events.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.server.ServerListPingEvent
import xyz.hyperspark.vanguard.models.Ping
import xyz.hyperspark.vanguard.models.PingHistory
import java.time.Instant
import java.util.logging.Logger

class ServerListListener(
    private val pingHistory: PingHistory,
    private val logger: Logger,
): Listener {
    @EventHandler
    fun onServerListPing(evt: ServerListPingEvent) {
        this.logger.info("Player ping received from " + evt.address.toString())
        this.pingHistory.add(Ping(evt.address, Instant.MAX)) // Never expire, for now.
    }
}