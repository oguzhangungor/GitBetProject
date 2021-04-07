package com.ogungor.gitbetproject.loginsignup.signUpFragment.usercontract

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.github.barteksc.pdfviewer.PDFView
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.ogungor.gitbetproject.R
import com.ogungor.gitbetproject.activity.BaseActivity

class UserContractActivity : BaseActivity(), UserContractActivityContract.View {


    private lateinit var userContractActivityPresenter: UserContractActivityContract.Presenter
    private lateinit var toolbar:androidx.appcompat.widget.Toolbar

    private lateinit var pdfView:PDFView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userContractActivityPresenter=UserContractActivityPresenter().apply {
            setView(this@UserContractActivity)
            create()

        }
    }


    override fun getLayout(): Int =R.layout.user_contract_layout

    override fun initUi() {
        pdfView=findViewById(R.id.pdfview)
        pdfView.fromAsset("lisans.pdf").load()



            toolbar=findViewById(R.id.toolbar)
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