package com.pince.demo.kotlinDemo

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View

interface IToolbarManager {
    val toolbar: Toolbar
    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    fun initToolbar(){
    }

    fun attachToScroll(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (dy > 0) toolbar.slideExit() else toolbar.slideEnter()
            }
        })
    }

    fun View.slideExit() {
        if (translationY == 0f) animate().translationY((-height).toFloat())
    }

    fun View.slideEnter() {
        if (translationY < 0f) animate().translationY(0f)
    }
}

class ToolbarManager() : IToolbarManager {
    override val toolbar: Toolbar
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

}