package com.ogungor.tabprojecttest.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ogungor.tabprojecttest.MainActivity
import com.ogungor.tabprojecttest.R
import com.ogungor.tabprojecttest.activity.BaseActivity

class SplashActivity :BaseActivity(), SplashActivityContract.View {

    private val DELAY_HANDLER_TIME=4000L

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
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}