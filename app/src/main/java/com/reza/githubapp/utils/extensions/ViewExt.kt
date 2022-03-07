package com.reza.githubapp.utils.extensions

import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible

fun ViewGroup.getAllVisibleDirectChildren(): List<View>{
    val views = arrayListOf<View>();
    for (i in 0 until childCount){
        val child = getChildAt(i)
        if (child.isVisible)
            views.add(getChildAt(i))
    }
    return views
}

fun View.getAllChildren(): List<View> {
    val result = ArrayList<View>()
    if (this !is ViewGroup) {
        result.add(this)
    } else {
        for (index in 0 until this.childCount) {
            val child = this.getChildAt(index)
            result.addAll(child.getAllChildren())
        }
    }
    return result
}

fun View.getAllVisibleChildrenByTag(strTag: String): List<View> {
    val result = ArrayList<View>()
    if (this !is ViewGroup) {
        if (strTag == tag && isVisible && (parent as View).isVisible)
            result.add(this)
    } else {
        for (index in 0 until this.childCount) {
            val child = this.getChildAt(index)
            result.addAll(child.getAllVisibleChildrenByTag(strTag))
        }
    }
    return result
}