package com.ogungor.tabprojecttestlist.feed

interface FeedActivityContract {


    interface  Presenter{

        fun create()

        fun setView(view:FeedActivityContract.View)

        fun itemSelect()

        fun destroy ()

    }


    interface  View{

        fun initUi()


    }
}