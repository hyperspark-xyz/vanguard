package xyz.hyperspark.vanguard.events.abstractions

import org.bukkit.event.Listener

interface EventDispatcher {
    fun registerListener(listener: Listener): EventDispatcher;
    fun deregisterListener(listener: Listener): EventDispatcher;
}