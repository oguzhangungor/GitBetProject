package com.ogungor.tabprojecttest.ui.main.createFragment

interface CreateUserFragmentContract {

    interface Presenter {

        fun create()

        fun setView(view: CreateUserFragmentContract.View)

        fun destroy()


    }

    interface View{

        fun initUi()

        fun goSplash()



    }


}