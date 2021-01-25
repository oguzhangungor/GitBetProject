package com.ogungor.tabprojecttestlist.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ogungor.tabprojecttestlist.loginsignup.LoginSignUpActivity
import com.ogungor.tabprojecttestlist.R
import com.ogungor.tabprojecttestlist.activity.BaseActivity

class SplashActivity :BaseActivity(), SplashActivityContract.View {

    private val DELAY_HANDLER_TIME=2000L
    private lateinit var splashActivityPresenter: SplashActivityContract.Presenter
    private lateinit var splashGif: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashActivityPresenter=SplashActivityPresenter().apply {
            setView(this@SplashActivity)
            create()
        }
    }

    override fun getLayout(): Int = R.layout.activity_splash

    override fun initUi() {
        splashGif=findViewById(R.id.splashGifAnim)
    }

    override fun startGif() {
        Glide.with(this).load(R.drawable.splahgif).into(splashGif)
    }

    override fun startHandler() {
        Handler().postDelayed({splashActivityPresenter.stopHandler()},DELAY_HANDLER_TIME)
    }

    override fun finApp() {
        this.finish()
        val intent = Intent(this, LoginSignUpActivity::class.java)
        startActivity(intent)
    }
}