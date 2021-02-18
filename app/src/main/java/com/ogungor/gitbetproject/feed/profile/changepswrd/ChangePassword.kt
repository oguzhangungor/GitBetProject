package com.ogungor.gitbetproject.feed.profile.changepswrd

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.ogungor.gitbetproject.R
import com.ogungor.gitbetproject.activity.BaseActivity
import com.ogungor.gitbetproject.util.extentions.launchLogOutToMainActivity
import com.ogungor.gitbetproject.util.extentions.showShortToast


class ChangePassword : BaseActivity(), ChangePasswordContract.View {
    private lateinit var changePasswordFragmentPresenter: ChangePasswordContract.Presenter
    private lateinit var change_password_first_text: EditText
    private lateinit var change_password_repeat_text: EditText
    private lateinit var change_password_confirm_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changePasswordFragmentPresenter = ChangePasswordPresenter().apply {
            setView(this@ChangePassword)
            create()
        }
    }

    override fun initUi() {
        change_password_first_text = findViewById(R.id.change_password_first_text)
        change_password_repeat_text = findViewById(R.id.change_password_repeat_text)
        change_password_confirm_button = findViewById(R.id.change_password_confirm_button)
        ChangePassWordClick()
    }

    private fun ChangePassWordClick() {
    change_password_confirm_button.setOnClickListener {
        changePasswordFragmentPresenter.changePasswordListener(
            change_password_first_text.text.toString(),
            change_password_repeat_text.text.toString()
        )
    }
    }

    override fun showToast(message:String){
        showShortToast(message)
    }

    override fun logOutChangePassword() {
        launchLogOutToMainActivity()
    }

    override fun getLayout(): Int = R.layout.activity_password_change
}