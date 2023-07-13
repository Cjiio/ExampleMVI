package tech.foxio.examplemvi

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApp : Application() {
    companion object {
        lateinit var appContext: Context
    }
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        loadJNI()
    }
    private fun loadJNI() {
        System.loadLibrary("slog")
        System.loadLibrary("uip")
        System.loadLibrary("n2n_v2s")
        // n2n_v2 is part of edge_v2 due to dependency on the g_status
        // n2n_v2 is part of edge_v2 due to dependency on the g_status
        System.loadLibrary("n2n_v1")
        System.loadLibrary("edge_v2s")
        System.loadLibrary("edge_v2")
        System.loadLibrary("edge_v1")
        System.loadLibrary("edge_jni")
    }
}