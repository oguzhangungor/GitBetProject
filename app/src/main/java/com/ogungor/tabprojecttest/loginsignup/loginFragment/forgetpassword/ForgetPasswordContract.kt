package com.ogungor.tabprojecttest.loginsignup.loginFragment.forgetpassword

interface ForgetPasswordContract {

    interface Presenter {

        fun create()

        fun setView(view:ForgetPasswordContract.View)

        fun finish()
        fun sendPasswordtoMail(mailAdress:String)

    }

    interface View {
        fun initUi()

        fun showSendMailMessage(message:String)
    }
}