package com.ogungor.tabprojecttestlist.feed

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





    override fun itemSelect() {
        TODO("Not yet implemented")
    }

    override fun destroy() {
        view = null
    }
}