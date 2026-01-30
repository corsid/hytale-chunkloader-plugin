package dev.corsid.events

import com.hypixel.hytale.math.util.ChunkUtil
import com.hypixel.hytale.server.core.Message
import com.hypixel.hytale.server.core.universe.Universe
import com.hypixel.hytale.server.core.universe.world.chunk.ChunkFlag
import dev.corsid.utils.Log
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

object ChunkLoader {
    var scheduler: ScheduledExecutorService = Executors.newScheduledThreadPool(1)

    fun start() {
        if (scheduler.isTerminated) {
            scheduler = Executors.newScheduledThreadPool(1)
        }
        scheduler.scheduleAtFixedRate(this::runTask, 0, 1, TimeUnit.SECONDS)
    }

    fun runTask() {
        try {
            for (worldEntry in Universe.get().worlds) {
                val world = worldEntry.value
                val chunk = world.getChunk(ChunkUtil.indexChunk(0, 0)) ?: continue
                chunk.setFlag(ChunkFlag.TICKING, true)
            }
        } catch (e: Exception) {
            Log.error("Couldn't run the task $e")
        }
    }

    fun stop() {
        scheduler.shutdownNow()
    }
}