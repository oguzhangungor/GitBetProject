package com.ogungor.tabprojecttest.feed

interface FeedActivityContract {


    interface  Presenter{

        fun create()

        fun setView(view:View)





    }


    interface  View{

        fun initUi()


    }
}