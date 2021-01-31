package com.ogungor.tabprojecttest.feed.daily.commentdialog

interface CommentDialogFragmentContract {

    interface Presenter {
        fun create ()

        fun setView(view:CommentDialogFragmentContract.View)

        fun destroy()

    }


    interface View{
        fun initUi()

    }
}
