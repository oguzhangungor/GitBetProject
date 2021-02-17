package com.ogungor.gitbetproject.loginsignup

import com.google.firebase.auth.FirebaseUser

interface LoginSignUpActivityContract {

    interface Presenter {

        fun create ( )

        fun setView(view: LoginSignUpActivityContract.View)

        fun destroy()

        fun loginUserControl(
            currentUser: FirebaseUser?,
            boolean: Boolean
        )
    }


    interface View {

        fun initUi()

        fun intentToaMainActivity()

        fun showLoginMessage()
    }
}