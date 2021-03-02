package com.ogungor.gitbetproject.loginsignup.loginFragment.forgetpassword

import com.google.firebase.auth.FirebaseAuth

class ForgetPasswordFragmentPresenter : ForgetPasswordFragmentContract.Presenter {
    private var view: ForgetPasswordFragmentContract.View? = null
    private lateinit var auth: FirebaseAuth

    override fun create() {
        auth = FirebaseAuth.getInstance()
        view?.run {
            initUi()
        }
    }

    override fun sendPasswordToMail(mailAddress: String) {
        view?.run {
            auth.sendPasswordResetEmail(mailAddress).addOnSuccessListener {
                showSendSuccessMessage()
            }
                .addOnFailureListener {
                    showSendFailedMessage()
                }
        }
    }

    override fun setView(view: ForgetPasswordFragmentContract.View) {
        this.view = view
    }

    override fun finish() {
        view = null
    }
}