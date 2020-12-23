package com.ogungor.tabprojecttest.feed

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.activity.BaseActivity
import com.ogungor.tabprojecttest.network.model.MatchModel
import com.ogungor.tabprojecttest.util.extentions.launchMainActivity
import com.ogungor.tabprojecttest.util.extentions.showShortToast

class FeedActivity : BaseActivity(), FeedActivityContract.View {

    private lateinit var feedActivityPresenter: FeedActivityContract.Presenter
    private  lateinit var layoutManager: LinearLayoutManager
    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter: FeedRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        feedActivityPresenter = FeedActivityPresenter().apply {
            setView(this@FeedActivity)
            create()
            getDataFromFirestore()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.feed_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        feedActivityPresenter.menuItemSelected(item)
        return super.onOptionsItemSelected(item)
    }

    override fun showSignOutMessage() {
        showShortToast(getString(R.string.sign_out))
    }

    override fun getLayout(): Int = R.layout.activity_feed

    override fun initUi() {

        recyclerView= findViewById(R.id.feed_recycler_view)

        layoutManager= LinearLayoutManager(this)
        recyclerView.layoutManager= layoutManager
        adapter= FeedRecyclerAdapter(ArrayList<MatchModel>())
        recyclerView.adapter=adapter


    }

    override fun intentToMainActivity() {
        launchMainActivity()
        finish()
    }



    override fun showAllMatches(model: java.util.ArrayList<MatchModel>) {
        adapter.setList(model)
    }

}