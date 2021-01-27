package com.ogungor.tabprojecttest.feed.profile

interface ProfileFragmentContract {

    interface Presenter {
        fun create()

        fun setView(view : ProfileFragmentContract.View?)

        fun destroy()

        fun logOutUser()

    }

    interface View{



        fun initUi()

        fun initClickListeners()


        fun intentLogOutToMainActivity()
    }
}