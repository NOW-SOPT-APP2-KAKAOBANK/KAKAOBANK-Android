package com.sopt.kakaobank.presentation.home

import android.content.Context
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sopt.kakaobank.core.util.context.pxToDp

class HomeRecyclerViewItemDecorator(val context: Context) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        if (position == 0) {
            outRect.top = context.pxToDp(9)
            outRect.bottom = context.pxToDp(9)
        } else {
            outRect.bottom = context.pxToDp(9)
        }
    }
}