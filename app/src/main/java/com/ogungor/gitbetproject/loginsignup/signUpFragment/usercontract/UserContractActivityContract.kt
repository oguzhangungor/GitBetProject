package com.ogungor.gitbetproject.loginsignup.signUpFragment.usercontract

interface UserContractActivityContract {

    interface Presenter {

        fun create()

        fun setView(view:UserContractActivityContract.View)

        fun destroy()

    }

    interface View{

        fun initUi()
    }
}