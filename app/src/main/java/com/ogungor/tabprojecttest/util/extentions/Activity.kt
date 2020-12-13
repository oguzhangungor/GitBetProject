package com.ogungor.tabprojecttest.util.extentions

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import com.ogungor.tabprojecttest.feed.FeedActivity

fun Activity.showLongToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Activity.launchFeedsActivity() {
    this.startActivity(Intent(this, FeedActivity::class.java))
}