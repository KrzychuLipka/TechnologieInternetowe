package pl.lipov.technologieinternetowe

import android.app.Application
import pl.lipov.technologieinternetowe.domain.utils.PlatformContextProvider

class TIApp : Application() {

    override fun onCreate() {
        super.onCreate()
        PlatformContextProvider.init(this)
    }
}
