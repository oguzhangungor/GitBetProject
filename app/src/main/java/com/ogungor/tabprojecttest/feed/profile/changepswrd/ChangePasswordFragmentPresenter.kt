package com.ogungor.tabprojecttest.feed.profile.changepswrd

class ChangePasswordFragmentPresenter : ChangePasswordFragmentContract.Presenter {
    private var view : ChangePasswordFragmentContract.View?=null

    override fun create() {
        view?.run {
            initUi()
        }
    }

    override fun setView(view: ChangePasswordFragmentContract.View) {
        this.view=view
    }

    override fun destroy() {
        view=null
    }
}