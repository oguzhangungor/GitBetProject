package com.ogungor.tabprojecttest.loginsignup.loginFragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.util.extentions.launchMainToFeedsActivity
import com.ogungor.tabprojecttest.util.extentions.showShortToast

class LoginUserFragment : Fragment(), LoginUserFragmentContract.View {

    private lateinit var loginUserFragmentPresenter: LoginUserFragmentContract.Presenter
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var rememberCheckBox: CheckBox
    private  var sharedPref:SharedPreferences?=null
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
        sharedPref=activity?.getSharedPreferences(R.string.preference_file_key.toString(),Context.MODE_PRIVATE)
        email = view.findViewById(R.id.login_email_editText)!!
        password = view.findViewById(R.id.login_password_editText)
        loginUserButton = view.findViewById(R.id.login_user_button)
        rememberCheckBox=view.findViewById(R.id.rememberCheckBox)
        loginUserFragmentPresenter.createView()
        return view
    }

    override fun initUi() {
        initClickListener()
    }

    override fun initClickListener() {

        loginUserButton?.setOnClickListener {
            loginUserFragmentPresenter.apply {
                var boolean=checkBoxControl(rememberCheckBox)
            loginUserListener(
                email.text.toString(),
                password.text.toString(),
                boolean,
                sharedPref

            )
        }}

    }

    override fun showCreateUserSuccessfulMessage() {
        activity?.showShortToast(getString(R.string.login_complete))
    }

    override fun showEmptyAreaMessage() {
        activity?.showShortToast(getString(R.string.empty_area))
    }

    override fun intentToMainsActivity() {
        activity?.run {
            launchMainToFeedsActivity()
            finish()
        }
    }

    override fun showInvalidPasswordMessage() {
        activity?.showShortToast(getString(R.string.login_password_error_message))
    }

    override fun showInvalidEmailMessage() {
        activity?.showShortToast(getString(R.string.email_error_message))
    }

    override fun showLoginUserFailureMessage() {
        activity?.showShortToast(getString(R.string.email_not_registered))
    }
}