package nl.hva.buurman.features.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import nl.hva.buurman.features.data.datasource.Api
import nl.hva.buurman.features.data.models.PokemonDetails

class PokemonDetailRepository(private val api: Api) {

    private val pokemonDetails = MutableLiveData<PokemonDetails>()

    fun fetchPokemonDetails(name: String): LiveData<PokemonDetails> {
        GlobalScope.launch {
            pokemonDetails.postValue(api.getPokemonDetails(name).execute().body())
        }
        return pokemonDetails
    }

}