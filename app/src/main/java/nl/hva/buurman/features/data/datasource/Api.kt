package nl.hva.buurman.features.data.datasource

import nl.hva.buurman.features.data.models.PokemonDetails
import nl.hva.buurman.features.data.models.PokemonList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("pokemon")
    fun getAllPokemon(@Query("limit") limit: String): Call<PokemonList>

    @GET("pokemon/{name}")
    fun getPokemonDetails(@Path("name") name: String): Call<PokemonDetails>

}