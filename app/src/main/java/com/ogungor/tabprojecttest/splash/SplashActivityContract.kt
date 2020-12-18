package com.ogungor.tabprojecttest.splash

interface SplashActivityContract {

    interface Presenter {
        fun create ()

        fun setView (view : SplashActivityContract.View)

        fun destroy()

        fun stopHandler()
    }


    interface  View {

       fun initUi()

       fun startGif()

       fun startHandler()

        fun finApp()
    }
}