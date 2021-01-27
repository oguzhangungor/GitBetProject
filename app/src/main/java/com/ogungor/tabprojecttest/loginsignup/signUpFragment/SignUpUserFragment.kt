package com.ogungor.tabprojecttest.loginsignup.signUpFragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.R.layout
import com.ogungor.tabprojecttest.util.extentions.launchMainToFeedActivity
import com.ogungor.tabprojecttest.util.extentions.showShortToast

class SignUpUserFragment : Fragment(), SignUpUserFragmentContract.View {

    private lateinit var createUserFragmentPresenter: SignUpUserFragmentContract.Presenter
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var passwordRepeat: EditText
    private var createUserButton: ImageButton? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        createUserFragmentPresenter = SignUpUserFragmentPresenter().apply {
            setView(this@SignUpUserFragment)
        }
    }

    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(layout.signup_user_layout, container, false)
        email = view.findViewById(R.id.create_mail_address_editText)!!
        passwordRepeat = view.findViewById(R.id.password_repeat_editText)!!
        password = view.findViewById(R.id.create_password_editText)!!
        createUserButton = view.findViewById(R.id.create_user_button)
        createUserFragmentPresenter.createView()
        return view
    }

    override fun initUi() {
        initClickListeners()
    }

    override fun initClickListeners() {
        createUserButton?.setOnClickListener {
            createUserFragmentPresenter.createUserClicked(
                email.text.toString(),
                password.text.toString(),
                passwordRepeat.text.toString()
            )
        }
    }

    override fun showPasswordNotEqualMessage() {
        activity?.showShortToast(getString(R.string.create_password_repeat_error_message))
    }

    override fun showEmptyAreaMessage() {
        activity?.showShortToast(getString(R.string.empty_area))
    }

    override fun showCreateUserFailureMessage(message: String?) {
        message?.let {
            activity?.showShortToast(it)
        }
    }

    override fun showCreateUserSuccessfullMessage() {
        activity?.showShortToast(getString(R.string.create_complete))
    }

    override fun showInvalidEmailMessage() {
        activity?.showShortToast(getString(R.string.email_error_message))
    }

    override fun showInvalidPasswordMessage() {
        activity?.showShortToast(getString(R.string.create_password_error_message))
    }

    override fun intentToMainActivity() {
        activity?.run {
            launchMainToFeedActivity()
            finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        createUserFragmentPresenter.destroy()
    }
}
