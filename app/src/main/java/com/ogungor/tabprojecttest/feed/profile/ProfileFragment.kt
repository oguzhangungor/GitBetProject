package com.ogungor.tabprojecttest.feed.profile

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.util.extentions.launchLogOutToMainActivity

class ProfileFragment : Fragment() , ProfileFragmentContract.View{
    private lateinit var profileFragmentPresenter: ProfileFragmentContract.Presenter
    private var mail_adress:TextView?=null
    private lateinit var change_password:AppCompatButton
    private lateinit var log_out:AppCompatButton

    private var auth: FirebaseAuth? = FirebaseAuth.getInstance()
    private var currentUser: FirebaseUser?=auth?.currentUser




    override fun onAttach(context: Context) {
        super.onAttach(context)
        profileFragmentPresenter=ProfileFragmentPresenter().apply{
            setView(this@ProfileFragment)


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_profile, container, false)
        mail_adress=view.findViewById(R.id.profile_mail_adress_textView)
        change_password=view.findViewById(R.id.profile_change_password_button)
        log_out=view.findViewById(R.id.profile_logut_button)
        setMailAdrress()
        profileFragmentPresenter.create()

        return view
    }

    override fun initUi() {
        initClickListeners()
    }



     fun setMailAdrress( ) {
        mail_adress?.text=currentUser?.email.toString()
    }

    override fun initClickListeners() {
        log_out?.setOnClickListener {
            profileFragmentPresenter. logOutUser()
        }
    }

    override fun intentLogOutToMainActivity() {
        activity?.run {
            launchLogOutToMainActivity()
            finish()
        }
    }


}