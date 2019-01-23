package nl.hva.pokemon.features.data.datasource

import nl.hva.pokemon.features.data.models.PokemonDetails
import nl.hva.pokemon.features.data.models.PokemonList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    //gets baseurl with pokemon as namespace, pass limit as query
    @GET("pokemon")
    fun getAllPokemon(@Query("limit") limit: String): Call<PokemonList>

    //pass name in path
    @GET("pokemon/{name}")
    fun getPokemonDetails(@Path("name") name: String): Call<PokemonDetails>
    //return call for the repostitory to execute
}