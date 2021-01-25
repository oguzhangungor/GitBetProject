package com.ogungor.tabprojecttestlist.util.extentions

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.ogungor.tabprojecttestlist.feed.FeedActivity
import com.ogungor.tabprojecttestlist.loginsignup.LoginSignUpActivity

fun Activity.showShortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Activity.launchMainToFeedsActivity() {
    this.startActivity(Intent(this, FeedActivity::class.java))
}


fun Activity.launchMainToLoginSignUpActivity() {
    this.startActivity(Intent(this, LoginSignUpActivity::class.java))
}
