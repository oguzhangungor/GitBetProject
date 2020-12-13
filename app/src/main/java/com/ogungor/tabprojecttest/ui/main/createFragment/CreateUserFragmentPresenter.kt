package com.ogungor.tabprojecttest.ui.main.createFragment

class CreateUserFragmentPresenter : CreateUserFragmentContract.Presenter{
private var view: CreateUserFragmentContract.View?=null

    override fun create() {
        view?.apply {
            initUi()
        }
    }

    override fun setView(view: CreateUserFragmentContract.View) {
        this.view=view
    }

    override fun destroy() {
    }


}