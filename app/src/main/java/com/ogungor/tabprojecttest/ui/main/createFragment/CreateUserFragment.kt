package com.ogungor.tabprojecttest.ui.main.createFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.auth.FirebaseAuth
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.feed.FeedActivity
import com.ogungor.tabprojecttest.splash.SplashActivity

class CreateUserFragment : Fragment(), CreateUserFragmentContract.View {

    private var createUserFragmentPresenter: CreateUserFragmentContract.Presenter? = null

    private lateinit var email: EditText
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var passwordRepeat: EditText

    private lateinit var auth: FirebaseAuth


    private var createUserButton: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        createUserFragmentPresenter = CreateUserFragmentPresenter().apply {
            setView(this@CreateUserFragment)
            create()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.create_user_layout, container, false)

        email = view?.findViewById(R.id.create_mail_address_editText)!!
        username = view?.findViewById(R.id.create_user_name_editText)!!
        passwordRepeat = view?.findViewById(R.id.password_repeat_editText)!!
        password = view?.findViewById(R.id.create_password_editText)!!

        createUserButton = view?.findViewById(R.id.create_user_button)


        createUserButton?.setOnClickListener {

            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                        Toast.makeText(activity, "oldu", Toast.LENGTH_LONG).show()

                        val intent = Intent(activity, FeedActivity::class.java)
                        startActivity(intent)
                        activity?.finish()
                    }
                }.addOnFailureListener { exception ->
                    if (exception != null) {
                        Toast.makeText(
                            activity,
                            exception.localizedMessage.toString(),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }


        }
        return view
    }

    override fun initUi() {


    }

    override fun goSplash() {
        val intent = Intent(activity, SplashActivity::class.java)
        startActivity(intent)
    }


}
