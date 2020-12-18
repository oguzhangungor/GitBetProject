package com.ogungor.tabprojecttest.feed

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentSnapshot
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.activity.BaseActivity
import com.ogungor.tabprojecttest.util.extentions.launchMainActivity
import com.ogungor.tabprojecttest.util.extentions.showShortToast

class FeedActivity : BaseActivity(), FeedActivityContract.View {

    private lateinit var feedActivityPresenter: FeedActivityContract.Presenter
    private  lateinit var layoutManager: LinearLayoutManager
    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter: FeedRecyclerAdapter


    var matchFromFB: ArrayList<String> =ArrayList()
    var betFromFB: ArrayList<String> =ArrayList()
    var rateFromFB: ArrayList<String> =ArrayList()
    var oldRateFromFB: ArrayList<String> =ArrayList()


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

        recyclerView= RecyclerView(applicationContext)

        layoutManager= LinearLayoutManager(this)
        recyclerView.layoutManager= layoutManager

        adapter= FeedRecyclerAdapter(matchFromFB,betFromFB,rateFromFB)

        recyclerView.adapter=adapter


    }

    override fun intentToMainActivity() {
        launchMainActivity()
        finish()
    }

    override fun getDB(document : DocumentSnapshot) {

        val match_name=document.get("match") as String
        val bet_name=document.get("bet") as String
        val rate_name=document.get("rate") as String
        val old_rate_name=document.get("old_rate") as String

        feedActivityPresenter.run { documentControl(match_name,bet_name) }


        matchFromFB.add(match_name)
        betFromFB.add(bet_name)
        rateFromFB.add(rate_name)
        oldRateFromFB.add(old_rate_name)

        adapter!!.notifyDataSetChanged()
    }

    override fun showDocumentMessage() {
        showShortToast("M boş ")
    }

    override fun showNoDocumentMessage() {
        showShortToast("b boş")

    }

    override fun showAllDocumentMessage(i :Int) {
        showShortToast(i.toString())

    }
}