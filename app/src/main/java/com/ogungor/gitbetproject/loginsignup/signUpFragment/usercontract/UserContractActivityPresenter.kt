package com.ogungor.gitbetproject.loginsignup.signUpFragment.usercontract

class UserContractActivityPresenter : UserContractActivityContract.Presenter {
    private var view:UserContractActivityContract.View?=null

    override fun create() {
        view?.apply {
            initUi()
        }
    }

    override fun setView(view: UserContractActivityContract.View) {
        this.view=view
    }

    override fun destroy() {
        view=null
    }
}