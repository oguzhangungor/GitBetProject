package com.ogungor.tabprojecttestlist.loginsignup.signUpFragment

import java.lang.Exception

interface SignUpUserFragmentContract {

    interface Presenter {

        fun setView(view: SignUpUserFragmentContract.View)

        fun destroy()

        fun createView()

        fun createUserClicked(email: String, password: String, passwordRepaat: String)

        fun createUser(email: String, password: String)

        fun handleError(exp: Exception)
    }

    interface View {

        fun initUi()

        fun initClickListeners()

        fun showEmptyAreaMessage()

        fun showPasswordNotEqualMessage()

        fun showCreateUserFailureMessage(message: String?)

        fun showCreateUserSuccessfullMessage()

        fun intentToMainActivity()

        fun showInvalidEmailMessage()

        fun showInvalidPasswordMessage()
    }
}