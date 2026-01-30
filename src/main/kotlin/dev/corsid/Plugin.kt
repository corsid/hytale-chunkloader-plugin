package dev.corsid

import com.hypixel.hytale.server.core.plugin.JavaPlugin
import com.hypixel.hytale.server.core.plugin.JavaPluginInit
import dev.corsid.commands.RootCommand
import dev.corsid.utils.Log

class Plugin(init: JavaPluginInit) : JavaPlugin(init) {
    override fun setup() {
        Log.info("setup started")
        this.commandRegistry.registerCommand(RootCommand())
        Log.info("root command registered")
        Log.info("setup completed")
    }
}