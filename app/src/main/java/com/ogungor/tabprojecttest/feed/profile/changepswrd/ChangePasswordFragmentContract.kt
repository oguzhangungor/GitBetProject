package com.ogungor.tabprojecttest.feed.profile.changepswrd

interface ChangePasswordFragmentContract {


    interface Presenter {

        fun create()

        fun setView (view: ChangePasswordFragmentContract.View)

        fun destroy()

    }

    interface View {

        fun initUi()

    }
}