package com.example.testfullscreenvideo

import FullScreenMediaController
import android.R
import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import android.widget.MediaController
import android.widget.VideoView


class MainActivity : Activity() {
    private var videoView: VideoView? = null
    private var mediaController: MediaController? = null
    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fullscreen_videoview)

        videoView = findViewById(R.id.videoView)

        val fullScreen = intent.getStringExtra("fullScreenInd")
        if ("y" == fullScreen) {
            window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN)
            getSupportActionBar().hide()
        }

        val videoUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.imageswitcher_example)

        videoView.setVideoURI(videoUri)

        mediaController = FullScreenMediaController(this)
        mediaController.setAnchorView(videoView)

        videoView.setMediaController(mediaController)
        videoView.start()
    }
}