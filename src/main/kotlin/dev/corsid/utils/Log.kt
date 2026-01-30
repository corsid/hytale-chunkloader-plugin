package dev.corsid.utils

import com.hypixel.hytale.logger.HytaleLogger

object Log {
    private val LOGGER: HytaleLogger = HytaleLogger.getLogger()
    fun info(message: String) {
        LOGGER.atInfo().log("ChunkLoader: $message")
    }
    fun error(message: String) {
        LOGGER.atInfo().log("ChunkLoader: $message")
    }
}