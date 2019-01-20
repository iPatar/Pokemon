package nl.hva.buurman.features.presentation.pokemonlist

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import nl.hva.buurman.features.data.models.Pokemon
import nl.hva.buurman.features.data.repositories.PokemonRepository

class PokemonListViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    val pokemon = MediatorLiveData<List<Pokemon>>()

    init {
        getAllPokemon()
    }

    private fun getAllPokemon() {
        pokemon.addSource(pokemonRepository.fetchAllPokemon()) {
            for (pokemon in it.results) {
                pokemon.name = pokemon.name.capitalize()
            }
            pokemon.value = it.results
        }
    }

}