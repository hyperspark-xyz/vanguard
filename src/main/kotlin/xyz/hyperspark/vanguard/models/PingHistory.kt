package xyz.hyperspark.vanguard.models

import java.net.InetAddress
import java.time.Instant

class PingHistory {
    private val history: ArrayList<Ping> = ArrayList();

    fun add(ping: Ping) {
        history.add(ping)
    }

    fun removeExpired() {
        history.removeIf { Instant.now() > it.validBefore }
    }

    fun contains(inetAddress: InetAddress): Boolean {
        return history.any { it.address == inetAddress }
    }
}