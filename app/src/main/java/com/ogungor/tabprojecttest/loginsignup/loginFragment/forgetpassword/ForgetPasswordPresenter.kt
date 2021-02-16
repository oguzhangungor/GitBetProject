package com.ogungor.tabprojecttest.loginsignup.loginFragment.forgetpassword

import com.google.firebase.auth.FirebaseAuth
import com.ogungor.tabprojecttest.R
import kotlin.math.exp

class ForgetPasswordPresenter : ForgetPasswordContract.Presenter {
    private var view:ForgetPasswordContract.View?=null
    private lateinit var auth:FirebaseAuth
    private var message_text=""

    override fun create() {
        auth= FirebaseAuth.getInstance()
        view?.run {
            initUi()
        }
    }

    override fun sendPasswordtoMail(mailAddress:String) {

        auth.sendPasswordResetEmail(mailAddress).addOnSuccessListener {
            message_text="Gönderildi."

        }
            .addOnFailureListener { exp->
                message_text="Sistemde Kağıtlı olmayan bir Mail Girdiniz"


            }
        view?.showSendMailMessage(message_text)
    }

    override fun setView(view : ForgetPasswordContract.View) {
        this.view=view
    }

    override fun finish() {
        view=null
    }
}