package nl.hva.buurman.features.presentation.pokemonlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_pokemon_list.*
import nl.hva.buurman.R
import nl.hva.buurman.features.data.models.Pokemon
import nl.hva.buurman.features.presentation.pokemondetail.PokemonDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonListActivity : AppCompatActivity(), PokemonListAdapter.OnItemClickListener {

    private val adapter = PokemonListAdapter()
    private val viewModel by viewModel<PokemonListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)
        supportActionBar?.title = getString(R.string.pokemon_list_activity_title)

        initAdapter()
        initFetch()
    }

    private fun initAdapter() {
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(divider)
        recyclerView.adapter = adapter
        adapter.setListeners(this)
    }

    private fun initFetch() {
        viewModel.pokemon.observe(this, Observer {
            adapter.setList(it)
        })
    }

    override fun onItemClick(pokemon: Pokemon) {
        val intent = PokemonDetailActivity.getIntent(this)
        intent.putExtra("pokemonName", pokemon.name)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

}
