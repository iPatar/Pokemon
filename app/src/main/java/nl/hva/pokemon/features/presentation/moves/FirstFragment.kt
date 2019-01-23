package nl.hva.pokemon.features.presentation.moves

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import nl.hva.pokemon.R

class FirstFragment : Fragment() {

    //fragment is a sub activity of sorts, more lightweight and easy to use
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_one_pokemon_detail, container, false)
    }

}