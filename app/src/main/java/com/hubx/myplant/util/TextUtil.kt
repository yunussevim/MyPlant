package com.hubx.myplant.util

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan

object TextUtil {

    fun makeBold(text: String, boldPart: String): SpannableString {
        val spannableString = SpannableString(text)

        val start = text.indexOf(boldPart)
        val end = start + boldPart.length

        spannableString.setSpan(
            StyleSpan(Typeface.BOLD),
            start,
            end,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return spannableString
    }
}

