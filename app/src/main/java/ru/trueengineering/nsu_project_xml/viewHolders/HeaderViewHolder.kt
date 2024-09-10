package ru.trueengineering.nsu_project_xml.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.trueengineering.nsu_project_xml.ListItem
import ru.trueengineering.nsu_project_xml.databinding.ViewBrandHeaderBinding

class HeaderViewHolder private constructor(
    private val viewBinding: ViewBrandHeaderBinding,
) : BaseViewHolder<ViewBrandHeaderBinding, ListItem.HeaderItem>(viewBinding = viewBinding) {

    override fun bind(item: ListItem.HeaderItem) {
        viewBinding.title.text = item.title
    }

    companion object {
        operator fun invoke(parent: ViewGroup): HeaderViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val viewBinding = ViewBrandHeaderBinding.inflate(
                layoutInflater,
                parent,
                false
            )
            return HeaderViewHolder(
                viewBinding = viewBinding
            )
        }
    }

}