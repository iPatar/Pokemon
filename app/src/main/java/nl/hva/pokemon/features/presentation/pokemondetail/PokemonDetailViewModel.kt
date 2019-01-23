package nl.hva.pokemon.features.presentation.pokemondetail

import androidx.lifecycle.*
import nl.hva.pokemon.features.data.models.PokemonDetails
import nl.hva.pokemon.features.data.repositories.PokemonDetailRepository

class PokemonDetailViewModel(private val pokemonDetailRepository: PokemonDetailRepository) : ViewModel() {

    private val pokemonId = MutableLiveData<String>()

    val pokemonDetails: LiveData<PokemonDetails> = Transformations
            .switchMap(pokemonId) {
                pokemonDetailRepository.fetchPokemonDetails(it)
            }

    fun setName(name: String) {
        pokemonId.value = name
    }

}