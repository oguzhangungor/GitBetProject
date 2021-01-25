package com.ogungor.tabprojecttestlist.loginsignup.signUpFragment

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.ogungor.tabprojecttestlist.enum.FirebaseErrorType
import java.lang.Exception

class SignUpUserFragmentPresenter : SignUpUserFragmentContract.Presenter {

    private var auth: FirebaseAuth? = null
    private var view: SignUpUserFragmentContract.View? = null

    override fun setView(view: SignUpUserFragmentContract.View) {
        this.view = view
    }

    override fun destroy() {
        auth = null
        view = null
    }

    override fun createView() {
        auth = FirebaseAuth.getInstance()
        view?.run {
            initUi()
        }
    }

    override fun createUserClicked(email: String, password: String, passwordRepaat: String) {
        view?.let { view ->
            if (email.isNotEmpty() && password.isNotEmpty() && passwordRepaat.isNotEmpty()) {
                if (password == passwordRepaat) {
                    createUser(email, password)
                } else {
                    view.showPasswordNotEqualMessage()
                }
            } else {
                view.showEmptyAreaMessage()
            }
        }
    }

    override fun createUser(email: String, password: String) {
        view?.run {
            auth?.createUserWithEmailAndPassword(email, password)
                ?.addOnSuccessListener {
                    showCreateUserSuccessfullMessage()
                    intentToMainActivity()
                }
                ?.addOnFailureListener { exp ->
                    handleError(exp)
                }
        }
    }

    override fun handleError(exp: Exception) {

        view?.run {
            when (exp) {
                is FirebaseAuthInvalidCredentialsException -> {
                    when (exp.errorCode) {
                        FirebaseErrorType.ERROR_INVALID_EMAIL.toString() -> {
                            showInvalidEmailMessage()
                        }
                        FirebaseErrorType.ERROR_WEAK_PASSWORD.toString()
                        -> {
                            showInvalidPasswordMessage()
                        }
                    }
                }
                else -> {
                    showCreateUserFailureMessage(exp.message)
                }
            }
        }
    }
}