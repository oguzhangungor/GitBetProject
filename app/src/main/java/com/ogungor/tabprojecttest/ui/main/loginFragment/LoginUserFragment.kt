package com.ogungor.tabprojecttest.ui.main.loginFragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import com.google.firebase.auth.FirebaseAuth
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.splash.SplashActivity
import com.ogungor.tabprojecttest.util.extentions.launchFeedsActivity
import com.ogungor.tabprojecttest.util.extentions.showLongToast

class LoginUserFragment : Fragment(), LoginUserFragmentContract.View {


    private lateinit var loginUserFragmentPresenter: LoginUserFragmentContract.Presenter


    private lateinit var email: EditText
    private lateinit var password: EditText
    private var loginUserButton: ImageButton? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        loginUserFragmentPresenter = LoginUserFragmentPresenter().apply {
            setView(this@LoginUserFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login_user_layout, container, false)

        email = view.findViewById(R.id.login_email_editText)!!
        password = view.findViewById(R.id.login_password_editText)
        loginUserButton = view.findViewById(R.id.login_user_button)

        loginUserFragmentPresenter.createView()
        return view
    }

    override fun initUi() {
        initClickListener()

    }

    override fun initClickListener() {

        loginUserButton?.setOnClickListener {
            loginUserFragmentPresenter.loginUserListener(
                email.text.toString(),
                password.text.toString()
            )
        }

    }

    override fun showCreateUserSuccessfulMessage() {
        activity?.showLongToast("Giriş Başarılı")
    }



    override fun showEmptyAreaMessage() {
        activity?.showLongToast("Boş Alan Bırakmayınız")
    }

    override fun intentToFeedsActivity() {
        activity?.run {
            launchFeedsActivity()
            finish()
        }
    }




}