package com.ogungor.tabprojecttestlist.splash

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
    }

    override fun stopHandler() {
        view?.finApp()
    }
}