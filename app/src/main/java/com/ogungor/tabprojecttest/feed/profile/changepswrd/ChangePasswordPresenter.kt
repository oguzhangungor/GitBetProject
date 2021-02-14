package com.ogungor.tabprojecttest.feed.profile.changepswrd

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class ChangePasswordPresenter : ChangePasswordContract.Presenter {
    private var view: ChangePasswordContract.View? = null
    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser

    override fun create() {
        auth = FirebaseAuth.getInstance()
        user = auth.currentUser!!;
        view?.run {
            initUi()
        }
    }

    override fun setView(view: ChangePasswordContract.View) {
        this.view = view
    }

    override fun destroy() {
        view = null
    }

    override fun changePasswordListener(pass1: String, pass2: String) {
        var messageText = ""
        if (pass1.length < 6 || pass2.length < 6) {
            messageText = "Girdiğiniz Şifre Kriterlere Uygun Değildir."
        } else {
            if (pass1 == pass2) {
                user.updatePassword(pass2)
                auth.signOut()
                messageText = "Başarılı"
                view?.logOutChangePassword()

            } else {
                messageText = "Girdiğiniz Şifreler Hatalı"
            }
        }
        view?.run {
            showToast(messageText)
        }
    }
}