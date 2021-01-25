package com.ogungor.tabprojecttestlist.feed.profile

class ProfileFragmentPresenter : ProfileFragmentContract.Presenter {
    private var view:ProfileFragmentContract.View?=null

    override fun create() {
    view?.apply {
        initUi()
    }
    }

    override fun setView(view: ProfileFragmentContract.View) {
        this.view=view
    }

    override fun destroy() {
        view=null
    }

    override fun getDataFromFireStore() {
        TODO("Not yet implemented")
    }
}