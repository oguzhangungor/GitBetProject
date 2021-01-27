package com.ogungor.tabprojecttest.util.extentions

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.ogungor.tabprojecttest.feed.FeedActivity
import com.ogungor.tabprojecttest.loginsignup.LoginSignUpActivity

fun Activity.showShortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.launchMainToFeedActivity() {
    this.startActivity(Intent(this, FeedActivity::class.java))
}

fun Activity.launchLogOutToMainActivity() {
    this.startActivity(Intent(this, LoginSignUpActivity::class.java))
}
