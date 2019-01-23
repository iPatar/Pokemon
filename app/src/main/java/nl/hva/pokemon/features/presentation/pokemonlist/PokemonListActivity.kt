package nl.hva.pokemon.features.presentation.pokemonlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_pokemon_list.*
import nl.hva.pokemon.R
import nl.hva.pokemon.features.data.models.Pokemon
import nl.hva.pokemon.features.presentation.pokemondetail.PokemonDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonListActivity : AppCompatActivity(), PokemonListAdapter.OnItemClickListener {

    //val = final, var isnt.
    private val adapter = PokemonListAdapter()
    private val viewModel by viewModel<PokemonListViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set layout for pokemonListActivity
        setContentView(R.layout.activity_pokemon_list)
        //Set title pokemon in bar on top of app
        supportActionBar?.title = getString(R.string.pokemon_list_activity_title)

        initAdapter()
        initFetch()
    }

    private fun initAdapter() {
        //create fancy divider between item lists
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        //set recyclerview layout orientation
        recyclerView.layoutManager = LinearLayoutManager(this)
        //add divider
        recyclerView.addItemDecoration(divider)
        //connect adapter to recyclerview
        recyclerView.adapter = adapter
        //add listeners
        adapter.setListeners(this)
    }

    private fun initFetch() {
        //fetch list of pokemons and set it on create
        viewModel.pokemon.observe(this, Observer {
            adapter.setList(it)
        })
    }

    override fun onItemClick(pokemon: Pokemon) {
        //create intent for detailactivity, pass pokemon name as extra info
        val intent = PokemonDetailActivity.getIntent(this)
        intent.putExtra("pokemonName", pokemon.name)
        //start activity with intent
        startActivity(intent)
        //set new transition, sliding in from the right and out to the left
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

}
