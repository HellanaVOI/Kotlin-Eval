package be.technifuture.exo2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import be.technifuture.exo2.databinding.CellHomeBinding

class ItemListViewHolder(private var viewBinding: CellHomeBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun bind(item: Item) {
            viewBinding.textQuantity.setText(item.quantity.toString())
            viewBinding.textItem.setText(item.name)
            viewBinding.textItem.setTextColor(
                ResourcesCompat.getColor(
                    itemView.resources,
                    when (item.type) {
                        TypeItem.MAISON -> R.color.pink
                        TypeItem.HYGIENE -> R.color.yellow
                        TypeItem.ALIMENTATION -> R.color.blue
                        TypeItem.BOISSON -> R.color.purple
                    }, null
                )
            )
            viewBinding.imgType.setImageResource(item.type.icon)
        }
    }

class ItemListAdapter(private var card: MutableList<Item>) :
        RecyclerView.Adapter<ItemListViewHolder>() {
        private lateinit var binding: CellHomeBinding

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): ItemListViewHolder {
            //charge le layout de la cellule
            binding = CellHomeBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return ItemListViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ItemListViewHolder, position: Int) {
            holder.bind(card[position])
        }

        //retourne le nbr d'élément à afficher
        override fun getItemCount(): Int {
            return card.size
        }
}