package com.ogungor.tabprojecttest.ui.main.createFragment

import java.lang.Exception

interface CreateUserFragmentContract {

    interface Presenter {

        fun setView(view: CreateUserFragmentContract.View)

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

        fun intentToFeedsActivity()

        fun showInvalidEmailMessage()

        fun showInvalidPasswordMessage()


    }


}