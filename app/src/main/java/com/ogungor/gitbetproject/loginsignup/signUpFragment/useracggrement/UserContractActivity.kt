package com.ogungor.gitbetproject.loginsignup.signUpFragment.useracggrement

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toolbar
import com.ogungor.gitbetproject.R
import com.ogungor.gitbetproject.activity.BaseActivity

class UserContractActivity : BaseActivity(), UserContractActivityContract.View {

    private lateinit var backButton: ImageButton

    private lateinit var userContractActivityPresenter: UserContractActivityContract.Presenter
    private lateinit var toolbar:androidx.appcompat.widget.Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userContractActivityPresenter=UserContractActivityPresenter().apply {
            setView(this@UserContractActivity)
            create()

        }
    }


    override fun getLayout(): Int =R.layout.user_contract_layout

    override fun initUi() {
            toolbar=findViewById(R.id.toolbar)
        // set toolbar as support action bar
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = getString(R.string.user_contract_title)


            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}