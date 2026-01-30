package dev.corsid.commands

import com.hypixel.hytale.server.core.Message
import com.hypixel.hytale.server.core.command.system.AbstractCommand
import com.hypixel.hytale.server.core.command.system.CommandContext
import dev.corsid.events.ChunkLoader
import java.util.concurrent.CompletableFuture

class StopCommand : AbstractCommand("stop", "Stop loading the chunk") {
    override fun execute(context: CommandContext): CompletableFuture<Void> {
        ChunkLoader.stop()
        context.sendMessage(Message.raw("stopped loading the chunk"))
        return CompletableFuture.completedFuture(null)
    }
}