package nl.hva.pokemon.features.presentation.pokemonlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.pokemon_row_item.view.*
import nl.hva.pokemon.R
import nl.hva.pokemon.features.data.models.Pokemon

//inherit recyclerview adapter with type pokemonlistadapter customviewholder, which specifies the type of customviewholder
class PokemonListAdapter : RecyclerView.Adapter<PokemonListAdapter.CustomViewHolder>() {

    //itemlist of pokemon, is mutable so it is updatable
    private val itemList = mutableListOf<Pokemon>()

    //onclicklistener for rowItems
    private var listener: OnItemClickListener? = null

    //set listeners
    fun setListeners(listener: OnItemClickListener) {
        this.listener = listener
    }

    //on new data do this
    fun setList(newList: List<Pokemon>) {
        itemList.clear()
        itemList.addAll(newList)
        //on data changed, "notify"/update view
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        //create inflater
        val layoutInflater = LayoutInflater.from(parent.context)
        //create row and inflate
        val cellForRow = layoutInflater.inflate(R.layout.pokemon_row_item, parent, false)
        //return viewholder + inflated row, + listener for onClickListening
        return CustomViewHolder(cellForRow, listener)
    }

    //gets number of items in the list
    override fun getItemCount(): Int {
        return itemList.size
    }

    //Binds pokemon to itemrows
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val pokemon = itemList[position]
        holder.bind(pokemon)
    }

    //inner class made because it was not deemed necessary to create seperate class file
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