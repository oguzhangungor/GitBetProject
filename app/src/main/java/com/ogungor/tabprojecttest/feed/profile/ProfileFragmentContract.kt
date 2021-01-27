package com.ogungor.tabprojecttest.feed.profile

interface ProfileFragmentContract {

    interface Presenter {
        fun create()

        fun setView(View : ProfileFragmentContract.View)

        fun destroy()

        fun showCurrentUserMailAdress()
    }

    interface View{


         fun initUi()

        fun setMailAdress(toString: String)




    }
}