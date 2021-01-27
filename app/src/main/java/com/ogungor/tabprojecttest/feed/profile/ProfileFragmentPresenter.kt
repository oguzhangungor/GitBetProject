package com.ogungor.tabprojecttest.feed.profile

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ProfileFragmentPresenter : ProfileFragmentContract.Presenter{
    private var view: ProfileFragmentContract.View?=null
    private var auth: FirebaseAuth? =null




    override fun create() {
        auth= FirebaseAuth.getInstance()
        view?.run {
            initUi()
        }
    }

    override fun setView(View: ProfileFragmentContract.View) {
        this.view=view
    }

    override fun destroy() {
        auth=null
        view=null
    }


    override fun logOutUser() {
        view?.run {
            auth!!.signOut()
            intentLogOutToMainActivity()
        }

    }
}
