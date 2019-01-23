package nl.hva.pokemon

import android.app.Application
import nl.hva.pokemon.core.di.koinModules
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, koinModules)
    }

}