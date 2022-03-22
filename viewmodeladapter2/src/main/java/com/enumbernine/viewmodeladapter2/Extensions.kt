package com.enumbernine.viewmodeladapter2

import androidx.annotation.LayoutRes
import androidx.lifecycle.LifecycleOwner

inline fun adapterOf(
    lifecycleOwner: LifecycleOwner,
    crossinline init: MutableList<ViewModelAdapterData>.() -> Unit
) = object : ViewModelAdapter2(lifecycleOwner) {
    init {
        val data = mutableListOf<ViewModelAdapterData>()
        data.init()
        data.forEach {
            when(it) {
                is Cell -> cell(it.clazz, it.layoutId, it.bindingId)
                is SharedObject -> sharedObject(it.sharedObject, it.bindingId)
            }
        }
    }
}

fun MutableList<ViewModelAdapterData>.cellOf(clazz: Class<out Any>, @LayoutRes layoutId: Int, bindingId: Int) {
    add(Cell(clazz, layoutId, bindingId))
}

fun MutableList<ViewModelAdapterData>.sharedObjectOf(sharedObject: Any, bindingId: Int) {
    add(SharedObject(sharedObject, bindingId))
}

abstract class ViewModelAdapterData

data class Cell(val clazz: Class<out Any>, @LayoutRes val layoutId: Int, val bindingId: Int): ViewModelAdapterData()
data class SharedObject(val sharedObject: Any, val bindingId: Int): ViewModelAdapterData()


infix fun ViewModelAdapter2.of(items: List<Any>) {
    this.items = items.toTypedArray()
}