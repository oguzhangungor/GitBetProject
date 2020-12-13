package com.ogungor.tabprojecttest.ui.main.loginFragment

class LoginUserFragmentPresenter : LoginUserFragmentContract.Presenter {
    private var view:LoginUserFragmentContract.View?=null
    override fun create() {
        view?.apply {
            initUi()
        }
    }

    override fun setView(view: LoginUserFragmentContract.View) {
        this.view=view
    }

    override fun destroy() {

    }
}