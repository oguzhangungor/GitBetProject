package com.ogungor.tabprojecttest.feed.profile

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ProfileFragmentPresenter : ProfileFragmentContract.Presenter{
    private var view: ProfileFragmentContract.View?=null
    private var auth: FirebaseAuth? = null
    private var currentUser: FirebaseUser?=null



    override fun create() {
        auth= FirebaseAuth.getInstance()
        view?.apply {
            initUi()
        }
    }

    override fun setView(View: ProfileFragmentContract.View) {
        this.view=view
    }

    override fun destroy() {
        view=null
    }

    override fun showCurrentUserMailAdress() {
        currentUser=auth?.currentUser
        var user=currentUser?.email
        view=ProfileFragment().setMailAdress(user.toString())
    }
}