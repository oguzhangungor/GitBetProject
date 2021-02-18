package com.ogungor.gitbetproject.feed

class FeedActivityPresenter : FeedActivityContract.Presenter {

    private var view: FeedActivityContract.View? = null

    override fun setView(view: FeedActivityContract.View) {
        this.view = view
    }

    override fun create() {
        view?.apply {
            initUi()
        }
    }

    override fun destroy() {
        view = null
    }
}