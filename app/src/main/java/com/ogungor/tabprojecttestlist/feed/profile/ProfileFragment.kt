package com.ogungor.tabprojecttestlist.feed.profile

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.ogungor.tabprojecttestlist.R

class ProfileFragment : Fragment() , ProfileFragmentContract.View{
    private lateinit var profileFragmentPresenter: ProfileFragmentContract.Presenter

   private lateinit var email:TextView
   private lateinit var changePassWord:Button
   private lateinit var logOut:Button

    override fun onAttach(context: Context) {
        super.onAttach(context)
        profileFragmentPresenter=ProfileFragmentPresenter().apply {
            setView(this@ProfileFragment)
//            getDataFromFireStore()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_profile, container, false)
        email = view.findViewById(R.id.profile_mail_adress_textView)!!
        changePassWord = view.findViewById(R.id.profile_change_password_button)!!
        logOut = view.findViewById(R.id.profile_logut_button)!!
        profileFragmentPresenter.create()


        return view
    }

    override fun initUi() {
        initClickListener()
    }

    private fun initClickListener() {


    }


}