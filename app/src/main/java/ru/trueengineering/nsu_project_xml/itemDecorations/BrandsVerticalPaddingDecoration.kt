package ru.trueengineering.nsu_project_xml.itemDecorations

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import ru.trueengineering.nsu_project_xml.toDp

class BrandsVerticalPaddingDecoration(
    private val topPadding: Int,
    private val bottomPadding: Int,
    private val viewTypes: List<Int>,
) : ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        val viewType = parent.adapter?.getItemViewType(position)

        if (viewType !in viewTypes) return

        outRect.top = topPadding.toDp(context = view.context).toInt()
        outRect.bottom = bottomPadding.toDp(context = view.context).toInt()
    }
}