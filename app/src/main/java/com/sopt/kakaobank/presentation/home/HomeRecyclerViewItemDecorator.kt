package com.sopt.kakaobank.presentation.home

import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HomeRecyclerViewItemDecorator(context: Context) : RecyclerView.ItemDecoration() {
    private val spaceInPixels: Int

    init {
        spaceInPixels = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 9f, context.resources.displayMetrics
        ).toInt()
    }

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.bottom = spaceInPixels
    }
}