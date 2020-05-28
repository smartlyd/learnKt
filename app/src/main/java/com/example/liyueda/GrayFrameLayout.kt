package com.example.liyueda

import android.content.Context
import android.graphics.Canvas
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * @author:       Lee
 * @version:      v1.0
 * @package:      com.example.liyueda
 * @description:  页面一键置灰，在BaseActivity#onViewCreated()中进行判断  id = R.id.content 证明是decorview所用 进行替换
 *                      if("FrameLayout".equals(name)){
 *                      int count = attrs.getAttributeCount();
                        for (int i = 0; i < count; i++) {
                        String attributeName = attrs.getAttributeName(i);
                        String attributeValue = attrs.getAttributeValue(i);
                        if (attributeName.equals("id")) {
                        int id = Integer.parseInt(attributeValue.substring(1));
                        String idVal = getResources().getResourceName(id);
                        if ("android:id/content".equals(idVal)) {
                        GrayFrameLayou grayFrameLayout = new GrayFrameLayou(context, attrs);
                        return grayFrameLayout;
}
}
}
}
return super.onCreateView(name, context, attrs);
 * @date:         2020-05-28
 * @time:         16:47
 */
class GrayFrameLayout(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    val mPaint = Paint()

    init {
        val colorMatrix = ColorMatrix()
        colorMatrix.setSaturation(0f)
        mPaint.colorFilter = ColorMatrixColorFilter(colorMatrix)
    }


    override fun onDraw(canvas: Canvas) {
        canvas.saveLayer(null, mPaint)
        super.draw(canvas)
        canvas.restore()
    }

    override fun dispatchDraw(canvas: Canvas) {
        canvas.saveLayer(null, mPaint)
        super.dispatchDraw(canvas)
        canvas.restore()
    }
}