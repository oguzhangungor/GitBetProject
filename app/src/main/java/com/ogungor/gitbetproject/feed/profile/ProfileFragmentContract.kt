package com.ogungor.gitbetproject.feed.profile

interface ProfileFragmentContract {

    interface Presenter {
        fun create()

        fun setView(view : ProfileFragmentContract.View?)

        fun destroy()

        fun logOutUser()

        fun getUserMailAddress()

        fun setChangePassFragmentViePage()

    }

    interface View{



        fun initUi()

        fun initClickListeners()


        fun intentLogOutToMainActivity()

        fun setUserMailAddress( UserMailAddress: String)

        fun passwordChangeInit()
    }
}