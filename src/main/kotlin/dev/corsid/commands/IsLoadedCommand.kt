package dev.corsid.commands

import com.hypixel.hytale.math.util.ChunkUtil
import com.hypixel.hytale.server.core.Message
import com.hypixel.hytale.server.core.command.system.AbstractCommand
import com.hypixel.hytale.server.core.command.system.CommandContext
import com.hypixel.hytale.server.core.command.system.arguments.system.RequiredArg
import com.hypixel.hytale.server.core.command.system.arguments.types.ArgTypes
import com.hypixel.hytale.server.core.entity.entities.Player
import com.hypixel.hytale.server.core.universe.Universe
import com.hypixel.hytale.server.core.universe.world.chunk.ChunkFlag
import java.util.concurrent.CompletableFuture

class IsLoadedCommand : AbstractCommand("is-loaded", "Check if a chunk is currently loaded") {
    private val xArg: RequiredArg<Int> = this.withRequiredArg("x", "target chunk x coordinate", ArgTypes.INTEGER)
    private val zArg: RequiredArg<Int> = this.withRequiredArg("z", "target chunk z coordinate", ArgTypes.INTEGER)

    override fun execute(context: CommandContext): CompletableFuture<Void> {
        val sender = context.sender()
        val world = (sender as? Player)?.world ?: Universe.get().defaultWorld ?: run {
            context.sendMessage(Message.raw("World is null"))
            return CompletableFuture.completedFuture(null)
        }

        val (x, z) = Pair(context.get(xArg), context.get(zArg))
        val chunkIndex = ChunkUtil.indexChunk(x, z)
        val chunk = world.getNonTickingChunk(chunkIndex) ?: run {
            context.sendMessage(Message.raw("Chunk is null"))
            return CompletableFuture.completedFuture(null)
        }

        val chunkStatus = if (chunk.`is`(ChunkFlag.TICKING)) "loaded" else "not loaded"
        context.sendMessage(Message.raw("chunk at $x $z is $chunkStatus"))
        return CompletableFuture.completedFuture(null)
    }
}