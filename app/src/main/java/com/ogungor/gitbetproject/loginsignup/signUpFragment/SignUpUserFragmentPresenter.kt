package com.ogungor.gitbetproject.loginsignup.signUpFragment

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.ogungor.gitbetproject.enum.FirebaseErrorType
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

    override fun createUserClicked(
        checkboxEnable: Boolean,
        email: String,
        password: String,
        passwordRepaat: String
    ) {
            view?.apply {
                if (email.isNotEmpty() && password.isNotEmpty() && passwordRepaat.isNotEmpty()) {
                    if (password == passwordRepaat) {
                        if (checkboxEnable) {
                            createUser(email, password)
                        }else {
                                showCreateUserAgreementMessage()
                            }
                    } else {
                        showPasswordNotEqualMessage()
                    }
                } else {
                    showEmptyAreaMessage()
                }
            }
        }

    override fun createUser(email: String, password: String) {
        view?.run {
            auth?.createUserWithEmailAndPassword(email, password)
                ?.addOnSuccessListener {
                    showCreateUserSuccessFullMessage()
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