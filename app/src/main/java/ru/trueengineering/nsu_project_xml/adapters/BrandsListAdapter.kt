package ru.trueengineering.nsu_project_xml.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.trueengineering.nsu_project_xml.ListItem
import ru.trueengineering.nsu_project_xml.R
import ru.trueengineering.nsu_project_xml.viewHolders.BrandViewHolder
import ru.trueengineering.nsu_project_xml.viewHolders.HeaderViewHolder

class BrandsListAdapter :
    ListAdapter<ListItem, RecyclerView.ViewHolder>(BrandsDiffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.view_brand_item -> BrandViewHolder(parent = parent)
            R.layout.view_brand_header -> HeaderViewHolder(parent = parent)
            else -> error("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BrandViewHolder -> holder.bind(item = getItem(position) as ListItem.BrandItem)
            is HeaderViewHolder -> holder.bind(item = getItem(position) as ListItem.HeaderItem)
            else -> error("Unknown view type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return when (item) {
            is ListItem.BrandItem -> R.layout.view_brand_item
            is ListItem.HeaderItem -> R.layout.view_brand_header
        }
    }

}

private object BrandsDiffUtil : DiffUtil.ItemCallback<ListItem>() {
    override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        if (oldItem::class != newItem::class) return false
        return when (oldItem) {
            is ListItem.BrandItem -> oldItem.iconRes == (newItem as ListItem.BrandItem).iconRes
            is ListItem.HeaderItem -> oldItem.title == (newItem as ListItem.HeaderItem).title
        }
    }

    override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
        return when (oldItem) {
            is ListItem.BrandItem -> oldItem == (newItem as ListItem.BrandItem)
            is ListItem.HeaderItem -> oldItem == (newItem as ListItem.HeaderItem)
        }
    }
}