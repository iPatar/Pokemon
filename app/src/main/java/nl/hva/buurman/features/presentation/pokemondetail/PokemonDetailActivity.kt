package nl.hva.buurman.features.presentation.pokemondetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_pokemon_detail.*
import nl.hva.buurman.R
import nl.hva.buurman.features.presentation.moves.MoveActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonDetailActivity : AppCompatActivity() {

    private val viewModel by viewModel<PokemonDetailViewModel>()

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, PokemonDetailActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)

        val pokemonName = intent.getStringExtra("pokemonName")
        supportActionBar?.title = pokemonName

        initViews()
        viewModel.setName(pokemonName.decapitalize())
    }

    private fun initViews() {
        viewModel.pokemonDetails.observe(this, Observer { pokemonDetails ->
            textView_name_right.text = pokemonDetails.name.capitalize()
            textView_base_xp_right.text = pokemonDetails.base_experience
            textView_height_right.text = pokemonDetails.height
            textView_weight_right.text = pokemonDetails.weight

            moves.setOnClickListener {
                val intent = MoveActivity.getIntent(this)
                intent.putExtra("pokemonDetails", pokemonDetails)
                startActivity(intent)
            }
        })
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

}