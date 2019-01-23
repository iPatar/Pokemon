package nl.hva.pokemon.core.di

import nl.hva.pokemon.features.data.datasource.Api
import nl.hva.pokemon.features.data.repositories.PokemonDetailRepository
import nl.hva.pokemon.features.data.repositories.PokemonRepository
import nl.hva.pokemon.features.presentation.pokemondetail.PokemonDetailViewModel
import nl.hva.pokemon.features.presentation.pokemonlist.PokemonListViewModel
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import org.koin.experimental.builder.single
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/*
viewmodel is single with extras
single object can only be declared once
 */
val applicationModule: Module = module {
    viewModel<PokemonListViewModel>()
    viewModel<PokemonDetailViewModel>()
}

val repositoryModule: Module = module {
    single<PokemonRepository>()
    single<PokemonDetailRepository>()
}


val networkModule: Module = module {
    single { createRetrofit() }
    single { createWebService(get()) }
}

val koinModules = listOf<Module>(applicationModule)
    .plus(repositoryModule)
    .plus(networkModule)

//create retrofit, pass baseurl
fun createRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        //pass json to POJO
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

//create webservice from retrofit, use API interface as class for creating retrofit
fun createWebService(retrofit: Retrofit): Api {
    return retrofit.create(Api::class.java)
}