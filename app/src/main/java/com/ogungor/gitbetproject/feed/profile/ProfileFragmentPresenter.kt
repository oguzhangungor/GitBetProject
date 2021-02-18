package com.ogungor.gitbetproject.feed.profile

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ProfileFragmentPresenter : ProfileFragmentContract.Presenter{
    private var view: ProfileFragmentContract.View?=null
    private  var auth: FirebaseAuth?=null
    private var currentUser:FirebaseUser?=null
    private  var currentUserMailAddress:String?=null

    override fun create() {
        auth= FirebaseAuth.getInstance()
        view?.run {
            initUi()
        }
    }

    override fun setView(view: ProfileFragmentContract.View?) {
        this.view=view
    }

    override fun destroy() {
        view=null
    }

    override fun logOutUser() {
        view?.run {
            auth!!.signOut()
            intentLogOutToMainActivity()
        }
    }

    override fun getUserMailAddress(){
        view?.run {
            currentUser=auth?.currentUser
            currentUserMailAddress=currentUser?.email
             setUserMailAddress(currentUserMailAddress.toString())
        }
    }

    override fun setChangePassFragmentViePage()
    {
       view?.passwordChangeInit()
    }
}
