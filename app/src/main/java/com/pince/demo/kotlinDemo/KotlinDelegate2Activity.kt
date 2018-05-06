package com.pince.demo.kotlinDemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar

class KotlinDelegate2Activity : AppCompatActivity(), IToolbarManager by ToolbarManager() {

    override val toolbar: Toolbar by lazy { Toolbar(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        attachToScroll(RecyclerView(this))
    }
}