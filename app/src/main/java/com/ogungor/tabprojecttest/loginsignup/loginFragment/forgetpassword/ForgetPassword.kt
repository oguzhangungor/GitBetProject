package com.ogungor.tabprojecttest.loginsignup.loginFragment.forgetpassword

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.ogungor.tabprojecttest.R

class ForgetPassword :DialogFragment(), ForgetPasswordContract.View {
    private lateinit var forgetPasswordPresenter: ForgetPasswordContract.Presenter


    override fun onAttach(context: Context) {
        super.onAttach(context)
        forgetPasswordPresenter=ForgetPasswordPresenter().apply {
            setView(this@ForgetPassword)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.forgetpass_layout, container, false)
        forgetPasswordPresenter.create()
        return view
    }

    override fun onResume() {
        super.onResume()
        dialog!!.window?.setLayout(1000,900)
    }



    override fun initUi() {

    }



}