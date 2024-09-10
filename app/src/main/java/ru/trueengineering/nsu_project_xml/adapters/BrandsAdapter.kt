package ru.trueengineering.nsu_project_xml.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.trueengineering.nsu_project_xml.ListItem
import ru.trueengineering.nsu_project_xml.R
import ru.trueengineering.nsu_project_xml.viewHolders.BrandViewHolder
import ru.trueengineering.nsu_project_xml.viewHolders.HeaderViewHolder

class BrandsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<ListItem> = emptyList()

    fun setItems(items: List<ListItem>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.view_brand_item -> BrandViewHolder(parent = parent)
            R.layout.view_brand_header -> HeaderViewHolder(parent = parent)
            else -> error("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BrandViewHolder -> holder.bind(item = items[position] as ListItem.BrandItem)
            is HeaderViewHolder -> holder.bind(item = items[position] as ListItem.HeaderItem)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        return when (item) {
            is ListItem.BrandItem -> R.layout.view_brand_item
            is ListItem.HeaderItem -> R.layout.view_brand_header
        }
    }
}