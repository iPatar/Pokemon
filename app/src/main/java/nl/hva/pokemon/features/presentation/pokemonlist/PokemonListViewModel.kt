package nl.hva.pokemon.features.presentation.pokemonlist

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import nl.hva.pokemon.features.data.models.Pokemon
import nl.hva.pokemon.features.data.repositories.PokemonRepository

class PokemonListViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    //create mediatorlivedata with type list with type pokemon
    //is mediator to listen to other livedata and is observable
    val pokemon = MediatorLiveData<List<Pokemon>>()

    init {
        getAllPokemon()
    }

    private fun getAllPokemon() {
        //add fetchallpokemon fun from pokemon repository to mediatorlivedata
        pokemon.addSource(pokemonRepository.fetchAllPokemon()) {
            //for each pokemon in results, capitalize first letter
            for (pokemon in it.results) {
                pokemon.name = pokemon.name.capitalize()
            }
            //put fetchall pokemon results in pokemon mediator livedata value
            pokemon.value = it.results
        }
    }

}