package com.ogungor.tabprojecttestlist.feed.profile

interface ProfileFragmentContract {

    interface Presenter {
        fun create()

        fun setView(view :ProfileFragmentContract.View)

        fun destroy()
        fun getDataFromFireStore()

    }

    interface View {

        fun initUi()



    }
}