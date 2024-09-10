package ru.trueengineering.nsu_project_xml.viewHolders

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<V : ViewBinding, I : Any>(
    viewBinding: V,
) : RecyclerView.ViewHolder(viewBinding.root) {

    abstract fun bind(item: I)

}