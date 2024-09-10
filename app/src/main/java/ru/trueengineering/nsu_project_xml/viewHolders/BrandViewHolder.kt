package ru.trueengineering.nsu_project_xml.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.trueengineering.nsu_project_xml.ListItem
import ru.trueengineering.nsu_project_xml.databinding.ViewBrandItemBinding

class BrandViewHolder private constructor(
    private val viewBinding: ViewBrandItemBinding
) : BaseViewHolder<ViewBrandItemBinding, ListItem.BrandItem>(viewBinding = viewBinding) {

    override fun bind(item: ListItem.BrandItem) {
        viewBinding.icon.setImageResource(item.iconRes)
        viewBinding.title.text = item.title
    }

    companion object {
        operator fun invoke(parent: ViewGroup): BrandViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val viewBinding = ViewBrandItemBinding.inflate(layoutInflater, parent, false)
            return BrandViewHolder(
                viewBinding = viewBinding
            )
        }
    }

}