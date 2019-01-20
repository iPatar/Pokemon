package nl.hva.buurman.core.di

import nl.hva.buurman.features.data.datasource.Api
import nl.hva.buurman.features.data.repositories.PokemonDetailRepository
import nl.hva.buurman.features.data.repositories.PokemonRepository
import nl.hva.buurman.features.presentation.pokemondetail.PokemonDetailViewModel
import nl.hva.buurman.features.presentation.pokemonlist.PokemonListViewModel
import org.koin.androidx.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import org.koin.experimental.builder.single
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

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

fun createRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

fun createWebService(retrofit: Retrofit): Api {
    return retrofit.create(Api::class.java)
}