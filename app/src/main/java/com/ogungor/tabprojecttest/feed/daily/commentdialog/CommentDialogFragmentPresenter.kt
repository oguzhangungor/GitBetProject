package com.ogungor.tabprojecttest.feed.daily.commentdialog

import com.ogungor.tabprojecttest.feed.daily.DailyFeedFragmentContract

class CommentDialogFragmentPresenter : CommentDialogFragmentContract.Presenter {
    private var view:CommentDialogFragmentContract.View?= null

    override fun create() {

        view?.run {
        initUi()
    }
    }

    override fun setView(view: CommentDialogFragmentContract.View) {
        this.view=view
    }

    override fun destroy() {
        view=null
    }
}



