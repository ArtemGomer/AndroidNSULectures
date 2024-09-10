package ru.trueengineering.nsu_project_xml

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import ru.trueengineering.nsu_project_xml.adapters.BrandsListAdapter
import ru.trueengineering.nsu_project_xml.databinding.ActivityMainListBinding
import ru.trueengineering.nsu_project_xml.itemDecorations.BrandsHorizontalPaddingDecoration
import ru.trueengineering.nsu_project_xml.itemDecorations.BrandsVerticalPaddingDecoration

fun Int.toDp(context: Context): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        context.resources.displayMetrics
    )
}

class MainActivity : AppCompatActivity() {

    private val viewBinding by lazy(mode = LazyThreadSafetyMode.NONE) {
        ActivityMainListBinding.inflate(layoutInflater)
    }

    private val adapter by lazy(mode = LazyThreadSafetyMode.NONE) {
        BrandsListAdapter()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.list.adapter = adapter
        viewBinding.list.addItemDecoration(
            BrandsHorizontalPaddingDecoration(
                rightPadding = 16,
                leftPadding = 16,
                viewTypes = listOf(R.layout.view_brand_item)
            )
        )
        viewBinding.list.addItemDecoration(
            BrandsVerticalPaddingDecoration(
                topPadding = 32,
                bottomPadding = 32,
                viewTypes = listOf(R.layout.view_brand_item)
            )
        )
//        adapter.setItems(items = brands)
        adapter.submitList(brands)
    }
}


