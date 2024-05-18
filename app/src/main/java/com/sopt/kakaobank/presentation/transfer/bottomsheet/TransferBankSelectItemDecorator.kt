package com.sopt.kakaobank.presentation.transfer.bottomsheet

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sopt.kakaobank.core.util.context.pxToDp

class TransferBankSelectItemDecorator(private val context: Context) :
    RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)

        if (position in 0..1) {
            outRect.top = context.pxToDp(24)
            outRect.bottom = context.pxToDp(28)
        } else if (position in (state.itemCount - 1)..state.itemCount) {
            outRect.bottom = context.pxToDp(24)
        } else {
            outRect.bottom = context.pxToDp(28)
        }
    }
}
