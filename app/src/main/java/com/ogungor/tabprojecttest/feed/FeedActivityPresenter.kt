package com.ogungor.tabprojecttest.feed

class FeedActivityPresenter: FeedActivityContract.Presenter {
    private lateinit var view: FeedActivityContract.View

    override fun create() {
        view?.apply {
            initUi()

        }
    }

    override fun setView(view: FeedActivityContract.View) {
        this.view=view
    }


}