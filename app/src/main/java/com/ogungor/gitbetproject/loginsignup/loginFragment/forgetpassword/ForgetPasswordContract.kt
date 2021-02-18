package com.ogungor.gitbetproject.loginsignup.loginFragment.forgetpassword

interface ForgetPasswordContract {

    interface Presenter {
        fun create()

        fun setView(view:ForgetPasswordContract.View)

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