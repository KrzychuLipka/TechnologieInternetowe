package pl.lipov.technologieinternetowe.domain.utils

import android.content.Context

actual object PlatformContextProvider {
    private var appContext: Context? = null

    fun init(
        context: Context
    ) {
        appContext = context.applicationContext
    }

    actual fun context(): Any? = appContext
}

