package com.ogungor.tabprojecttest.loginsignup.loginFragment.forgetpassword

class ForgetPasswordPresenter : ForgetPasswordContract.Presenter {
    private var view:ForgetPasswordContract.View?=null

    override fun create() {
        view?.run {
            initUi()
        }
    }

    override fun setView(view : ForgetPasswordContract.View) {
        this.view=view
    }

    override fun finish() {
        view=null
    }
}