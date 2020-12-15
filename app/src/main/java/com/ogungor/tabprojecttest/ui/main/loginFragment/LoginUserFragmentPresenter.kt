package com.ogungor.tabprojecttest.ui.main.loginFragment

import com.google.firebase.auth.FirebaseAuth

class LoginUserFragmentPresenter : LoginUserFragmentContract.Presenter {

    private var auth: FirebaseAuth? = null
    private var view: LoginUserFragmentContract.View? = null


    override fun createView() {
        auth= FirebaseAuth.getInstance()
        view?.run {
            initUi()
        }
    }

    override fun setView(view: LoginUserFragmentContract.View) {
        this.view = view
    }

    override fun destroy() {
        auth=null
        view=null

    }

    override fun loginUserListener(email: String, password: String) {
        view?.let {view ->
            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginUser(email, password)
            } else {
                view.showEmptyAreaMessage()
            }
        }
    }


    override fun loginUser(email: String, password: String) {
        view?.run {
            auth!!.signInWithEmailAndPassword(email, password)
                .addOnSuccessListener { result ->
                    showCreateUserSuccessfulMessage()
                    intentToFeedsActivity()

                }
                .addOnFailureListener { exp ->
                    handlerError(exp)

                }
        }
    }


    override fun handlerError(exp: Exception) {
        view?.run {
            when (exp) {

            }


        }
    }

}