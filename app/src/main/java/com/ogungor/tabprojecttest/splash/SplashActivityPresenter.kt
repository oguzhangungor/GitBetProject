package com.ogungor.tabprojecttest.splash

class SplashActivityPresenter :SplashActivityContract.Presenter {
    private var view: SplashActivityContract.View?=null

    override fun create() {
        view?.apply {
            initUi()
            startGif()
            startHandler()
        }
    }

    override fun setView(view: SplashActivityContract.View) {
        this.view=view
    }

    override fun destroy() {
        TODO("Not yet implemented")
    }

    override fun stopHandler() {
        view?.finApp()
    }

}