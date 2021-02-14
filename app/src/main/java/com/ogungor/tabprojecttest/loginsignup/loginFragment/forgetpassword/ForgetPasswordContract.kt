package com.ogungor.tabprojecttest.loginsignup.loginFragment.forgetpassword

interface ForgetPasswordContract {

    interface Presenter {

        fun create()

        fun setView(view:ForgetPasswordContract.View)

        fun finish()

    }

    interface View {
        fun initUi()

    }
}