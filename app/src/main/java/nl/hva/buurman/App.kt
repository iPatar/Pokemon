package nl.hva.buurman

import android.app.Application
import nl.hva.buurman.core.di.koinModules
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, koinModules)
    }

}