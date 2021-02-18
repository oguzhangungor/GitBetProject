package com.ogungor.gitbetproject.feed.profile.changepswrd

interface ChangePasswordContract {


    interface Presenter {
        fun create()

        fun setView (view: ChangePasswordContract.View)

        fun destroy()

        fun changePasswordListener(pass1: String, pass2: String)
    }

    interface View {
        fun initUi()

        fun showToast(message:String)

        fun logOutChangePassword()
    }
}