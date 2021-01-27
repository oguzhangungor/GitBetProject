package com.ogungor.tabprojecttest.feed.profile

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.ogungor.tabprojecttest.R

class ProfileFragment : Fragment() , ProfileFragmentContract.View{
    private lateinit var profileFragmentPresenter: ProfileFragmentContract.Presenter
    private lateinit var mail_adress:TextView
    private lateinit var change_password:Button
    private lateinit var log_out:Button
    private lateinit var auth: FirebaseAuth




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
        var view= inflater.inflate(R.layout.fragment_profile, container, false)
        mail_adress=view.findViewById(R.id.profile_mail_adress_textView)
        change_password=view.findViewById(R.id.profile_change_password_button)
        log_out=view.findViewById(R.id.profile_logut_button)
        profileFragmentPresenter.apply {
            create()
            showCurrentUserMailAdress()

        }

        return view
    }

    override fun initUi() {
        initClickListener()
    }

    override fun setMailAdress(MailAdress: String) {
        mail_adress.text=MailAdress
    }

    private fun initClickListener() {

        log_out.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                TODO("Not yet implemented")
            }
        })
    }




}