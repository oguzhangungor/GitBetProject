package com.ogungor.tabprojecttest.ui.main.loginFragment

interface LoginUserFragmentContract {

    interface Presenter {
        fun create()

        fun setView(view: LoginUserFragmentContract.View)

        fun destroy()


    }


    interface View {
        fun initUi()

        fun goSplash()


    }
}