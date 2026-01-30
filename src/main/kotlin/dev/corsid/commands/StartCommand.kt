package dev.corsid.commands

import com.hypixel.hytale.server.core.Message
import com.hypixel.hytale.server.core.command.system.AbstractCommand
import com.hypixel.hytale.server.core.command.system.CommandContext
import dev.corsid.events.ChunkLoader
import java.util.concurrent.CompletableFuture

class StartCommand : AbstractCommand("start", "Start loading the chunk") {
    override fun execute(context: CommandContext): CompletableFuture<Void> {
        ChunkLoader.start()
        context.sendMessage(Message.raw("started loading the chunk"))
        return CompletableFuture.completedFuture(null)
    }
}