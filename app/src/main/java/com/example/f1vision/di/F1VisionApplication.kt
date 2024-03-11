package com.example.f1vision.di

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class F1VisionApplication: Application(), ImageLoaderFactory {
    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this).memoryCache {
            MemoryCache.Builder(this).maxSizePercent(0.25).build()
        }.diskCache {
            DiskCache.Builder().directory(this.cacheDir.resolve("image_cache")).maxSizePercent(0.25).build()
        }.build()
    }
}