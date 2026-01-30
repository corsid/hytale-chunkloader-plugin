package dev.corsid

import com.hypixel.hytale.server.core.plugin.JavaPlugin
import com.hypixel.hytale.server.core.plugin.JavaPluginInit
import com.hypixel.hytale.server.core.universe.world.events.AllWorldsLoadedEvent
import dev.corsid.commands.RootCommand
import dev.corsid.events.ChunkLoader
import dev.corsid.utils.Log

class Plugin(init: JavaPluginInit) : JavaPlugin(init) {
    override fun setup() {
        Log.info("setup started")
        this.eventRegistry.registerGlobal(AllWorldsLoadedEvent::class.java) { ChunkLoader.start() }
        this.commandRegistry.registerCommand(RootCommand())
        Log.info("root command registered")
        Log.info("setup completed")
    }

    override fun shutdown() {
        Log.info("shutdown started")
        ChunkLoader.stop()
        Log.info("shutdown completed")
    }
}