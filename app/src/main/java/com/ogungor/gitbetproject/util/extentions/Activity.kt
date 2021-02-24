package com.ogungor.gitbetproject.util.extentions

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.ogungor.gitbetproject.feed.FeedActivity
import com.ogungor.gitbetproject.feed.profile.changepswrd.ChangePassword
import com.ogungor.gitbetproject.loginsignup.LoginSignUpActivity
import com.ogungor.gitbetproject.loginsignup.signUpFragment.useracggrement.UserContract

fun Activity.showShortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.launchMainToFeedActivity() {
    this.startActivity(Intent(this, FeedActivity::class.java))
}

fun Activity.launchLogOutToMainActivity() {
    this.startActivity(Intent(this, LoginSignUpActivity::class.java))
}

fun Activity.launchProfileToChgPasswordActivity() {
    this.startActivity(Intent(this, ChangePassword::class.java))
}

fun Activity.launchMainToAgreementActivity() {
    this.startActivity(Intent(this, UserContract::class.java))
}
