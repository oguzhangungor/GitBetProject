package com.ogungor.tabprojecttest.feed

import android.os.Bundle
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.activity.BaseActivity

class FeedActivity : BaseActivity(), FeedActivityContract.View {

    private lateinit var feedActivityPresenter: FeedActivityContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        feedActivityPresenter = FeedActivityPresenter().apply {
            setView(this@FeedActivity)
            create()
        }
    }


    override fun getLayout(): Int = R.layout.activity_feed

    override fun initUi() {

    }
}