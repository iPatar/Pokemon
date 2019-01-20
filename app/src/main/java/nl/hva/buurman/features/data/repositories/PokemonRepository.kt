package nl.hva.buurman.features.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import nl.hva.buurman.features.data.datasource.Api
import nl.hva.buurman.features.data.models.PokemonList

class PokemonRepository(private val api: Api) {

    private val pokemon = MutableLiveData<PokemonList>()

    fun fetchAllPokemon(): LiveData<PokemonList> {
        GlobalScope.launch {
            pokemon.postValue(api.getAllPokemon("151").execute().body())
        }
        return pokemon
    }

}