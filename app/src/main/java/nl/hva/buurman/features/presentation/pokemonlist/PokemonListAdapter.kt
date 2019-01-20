package nl.hva.buurman.features.presentation.pokemonlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.pokemon_row_item.view.*
import nl.hva.buurman.R
import nl.hva.buurman.features.data.models.Pokemon

class PokemonListAdapter : RecyclerView.Adapter<PokemonListAdapter.CustomViewHolder>() {

    private val itemList = mutableListOf<Pokemon>()

    private var listener: OnItemClickListener? = null

    fun setListeners(listener: OnItemClickListener) {
        this.listener = listener
    }

    fun setList(newList: List<Pokemon>) {
        itemList.clear()
        itemList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.pokemon_row_item, parent, false)
        return CustomViewHolder(cellForRow, listener)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val pokemon = itemList[position]
        holder.bind(pokemon)
    }

    inner class CustomViewHolder(val view: View, listener: OnItemClickListener?): RecyclerView.ViewHolder(view) {

        fun bind(pokemon: Pokemon) {
            view.pokemonRowItem.text = pokemon.name
            view.setOnClickListener {
                listener?.onItemClick(pokemon)
            }
        }

    }

    interface OnItemClickListener {
        fun onItemClick(pokemon: Pokemon)
    }

}