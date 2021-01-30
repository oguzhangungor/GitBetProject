package com.ogungor.tabprojecttest.feed.profile.changepswrd

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ogungor.tabprojecttest.R


class ChangePasswordFragment : Fragment() , ChangePasswordFragmentContract.View{
        private lateinit var changePasswordFragmentPresenter: ChangePasswordFragmentContract.Presenter
        private lateinit var change_password_first_text:TextView
        private lateinit var change_password_repeat_text:TextView
        private lateinit var change_password_confirm_button:TextView




    override fun onAttach(context: Context) {
        super.onAttach(context)
        changePasswordFragmentPresenter=ChangePasswordFragmentPresenter().apply {
            setView(this@ChangePasswordFragment)
        }

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view=inflater.inflate(R.layout.fragment_change_password, container, false)
        change_password_first_text=view.findViewById(R.id.change_password_first_text)
        change_password_repeat_text=view.findViewById(R.id.change_password_repeat_text)
        change_password_confirm_button=view.findViewById(R.id.change_password_confirm_button)

        changePasswordFragmentPresenter.create()

       return  view

    }

    override fun initUi() {
        ChangePassWordClick()
    }

    private fun ChangePassWordClick() {

    }

}