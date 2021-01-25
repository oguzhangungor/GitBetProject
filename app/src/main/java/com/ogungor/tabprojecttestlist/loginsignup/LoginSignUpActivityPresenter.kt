package com.ogungor.tabprojecttestlist.loginsignup

import com.google.firebase.auth.FirebaseUser

class LoginSignUpActivityPresenter : LoginSignUpActivityContract.Presenter {
    private var view: LoginSignUpActivityContract.View? = null

    override fun create() {
        view?.apply {
            initUi()
        }
    }

    override fun setView(view: LoginSignUpActivityContract.View) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }

    override fun loginUserControl(
        currentUser: FirebaseUser?,
        boolean: Boolean
    ) {
        view?.run {
            if(boolean){
                if (currentUser != null) {
                    intentToaMainActivity()
                    showLoginMessage()
                }
            }

        }
    }
}