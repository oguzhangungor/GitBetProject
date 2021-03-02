package com.ogungor.gitbetproject.loginsignup.loginFragment.forgetpassword

interface ForgetPasswordFragmentContract {

    interface Presenter {
        fun create()

        fun setView(view:ForgetPasswordFragmentContract.View)

        fun finish()

        fun sendPasswordToMail(mailAddress:String)

    }

    interface View {
        fun initUi()

        fun showSendSuccessMessage()

        fun showSendFailedMessage()

        fun sendInitClickListener()
    }
}