package com.example.android

import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.widget.TextView

object Extensions {

    fun TextView.applyBoldText(prefix: String, value: String) {
        val text = "$prefix : $value"
        val builder = SpannableStringBuilder(text)
        builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(":") + 1, 0)
        setText(text)

    }

}