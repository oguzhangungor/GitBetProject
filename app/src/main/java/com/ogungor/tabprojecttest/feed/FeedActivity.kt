package com.ogungor.tabprojecttest.feed

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import com.google.firebase.auth.FirebaseAuth
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.activity.BaseActivity

class FeedActivity : BaseActivity(), FeedActivityContract.View {

    private lateinit var feedActivityPresenter: FeedActivityContract.Presenter
    private lateinit var auth:FirebaseAuth
    private lateinit var currentUser:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        feedActivityPresenter = FeedActivityPresenter().apply {
            setView(this@FeedActivity)
            create()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    var menuInflater=getMenuInflater()
        menuInflater.inflate(R.menu.feed_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun getLayout(): Int = R.layout.activity_feed

    override fun initUi() {
        auth= FirebaseAuth.getInstance()
        this.currentUser=auth

    }
}