package nl.hva.pokemon.features.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import nl.hva.pokemon.features.data.datasource.Api
import nl.hva.pokemon.features.data.models.PokemonList

class PokemonRepository(private val api: Api) {

    //mutable live data so its able to be muted and updated, async stuff
    private val pokemon = MutableLiveData<PokemonList>()

    fun fetchAllPokemon(): LiveData<PokemonList> {
        //globalscope.launch creates new thread, the main thread doesnt get blocked this was
        GlobalScope.launch {
            //post value to mutable live data, limit query with 151 (gen 1 pokemon), execute Call and convert body to POJO
            pokemon.postValue(api.getAllPokemon("151").execute().body())
        }
        return pokemon
    }

}