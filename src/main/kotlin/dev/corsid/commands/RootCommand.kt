package dev.corsid.commands

import com.hypixel.hytale.server.core.Message
import com.hypixel.hytale.server.core.command.system.AbstractCommand
import com.hypixel.hytale.server.core.command.system.CommandContext
import java.util.concurrent.CompletableFuture

class RootCommand : AbstractCommand("chunkloader", "Configure Chunk Loader plugin") {
    init {
        this.addAliases("cl")
    }

    override fun execute(context: CommandContext): CompletableFuture<Void> {
        context.sendMessage(Message.raw("It's working"))
        return CompletableFuture.completedFuture(null)
    }
}