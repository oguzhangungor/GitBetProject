package com.ogungor.gitbetproject.loginsignup.loginFragment.forgetpassword

import com.google.firebase.auth.FirebaseAuth

class ForgetPasswordPresenter : ForgetPasswordContract.Presenter {
    private var view: ForgetPasswordContract.View? = null
    private lateinit var auth: FirebaseAuth

    override fun create() {
        auth = FirebaseAuth.getInstance()
        view?.run {
            initUi()
        }
    }

    override fun sendPasswordtoMail(mailAddress: String) {
        view?.run {
            auth.sendPasswordResetEmail(mailAddress).addOnSuccessListener {
                showSendMailMessage("Mail Gönderilmiştir.")
            }
                .addOnFailureListener {
                    showSendMailMessage("Sistemde Kayıtlı Olmayan Bir Mail Girdiniz.")
                }
        }
    }

        override fun setView(view: ForgetPasswordContract.View) {
            this.view = view
        }

        override fun finish() {
            view = null
        }
    }