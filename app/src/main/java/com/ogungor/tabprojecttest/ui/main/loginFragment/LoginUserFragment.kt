package com.ogungor.tabprojecttest.ui.main.loginFragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.feed.FeedActivity
import com.ogungor.tabprojecttest.splash.SplashActivity

class LoginUserFragment : Fragment(), LoginUserFragmentContract.View {
    private var loginUserFragmentPresenter: LoginUserFragmentContract.Presenter? = null

    private lateinit var auth: FirebaseAuth

    private lateinit var email: EditText
    private lateinit var password: EditText

    private var loginUserButton: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
        loginUserFragmentPresenter = LoginUserFragmentPresenter().apply {
            setView(this@LoginUserFragment)
            create()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.login_user_layout, container, false)

        email = view?.findViewById(R.id.login_user_name_editText)!!
        password = view.findViewById(R.id.login_password_editText)
        loginUserButton = view?.findViewById(R.id.login_user_button)
        loginUserButton?.setOnClickListener {

            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener { task: Task<AuthResult> ->
                    if (task.isSuccessful) {

                        Toast.makeText(
                            activity,
                            "Hoş geldiniz:  ${auth.currentUser?.email.toString()}",
                            Toast.LENGTH_LONG
                        ).show()

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