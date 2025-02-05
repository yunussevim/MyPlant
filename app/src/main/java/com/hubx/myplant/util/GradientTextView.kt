package com.hubx.myplant.util

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.hubx.myplant.R

class GradientTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : AppCompatTextView(context, attrs, defStyle) {

    private var gradientFromColor: Int = 0xFFFF0000.toInt() // Varsayılan: Kırmızı
    private var gradientToColor: Int = 0xFF0000FF.toInt()   // Varsayılan: Mavi
    private var gradientOrientation: Int = 0 // 0: Horizontal, 1: Vertical

    init {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.GradientTextView)
            gradientFromColor = typedArray.getColor(R.styleable.GradientTextView_gradientFromColor, gradientFromColor)
            gradientToColor = typedArray.getColor(R.styleable.GradientTextView_gradientToColor, gradientToColor)
            gradientOrientation = typedArray.getInt(R.styleable.GradientTextView_gradientOrientation, 0)
            typedArray.recycle()
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        if (width > 0 && height > 0) {
            val x0 = 0f
            val y0 = 0f
            val x1: Float
            val y1: Float
            if (gradientOrientation == 0) {
                x1 = width.toFloat()
                y1 = 0f
            } else {
                x1 = 0f
                y1 = height.toFloat()
            }
            val shader = LinearGradient(
                x0, y0, x1, y1,
                gradientFromColor,
                gradientToColor,
                Shader.TileMode.CLAMP
            )
            paint.shader = shader
        }
        super.onDraw(canvas)
    }
}
