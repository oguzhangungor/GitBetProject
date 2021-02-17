package com.ogungor.gitbetproject.feed

interface FeedActivityContract {


    interface Presenter {

        fun create()

        fun setView(view: FeedActivityContract.View)

        fun destroy()

    }


    interface View {

        fun initUi()

        fun showDialog()


    }
}