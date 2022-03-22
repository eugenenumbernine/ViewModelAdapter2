package com.enumbernine.viewmodeladapter2

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("goneIf")
fun View.bindGoneIf(value: Any?) {
    this.visibility = when(value) {
        is Boolean -> if (value) View.GONE else View.VISIBLE
        is String -> if (value.isEmpty()) View.GONE else View.VISIBLE
        is Number -> if (value == 0) View.GONE else View.VISIBLE
        null -> View.GONE
        else -> View.VISIBLE
    }
}

@BindingAdapter("goneIfNot")
fun View.bindGoneIfNot(value: Boolean) {
    this.visibility = if (value) View.VISIBLE else View.GONE
}

@BindingAdapter("invisibleIf")
fun View.bindInvisibleIf(value: Any?) {
    this.visibility = when(value) {
        is Boolean -> if (value) View.INVISIBLE else View.VISIBLE
        is String -> if (value.isEmpty()) View.INVISIBLE else View.VISIBLE
        is Number -> if (value == 0) View.INVISIBLE else View.VISIBLE
        null -> View.INVISIBLE
        else -> View.VISIBLE
    }
}

@BindingAdapter("isEnabled")
fun View.bindIsEnabled(value: Boolean) {
    this.isEnabled = value
}
