package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView


class MainActivity : AppCompatActivity() {
    var index = 0
    val urls = arrayOf(
        "https://video.xx.fbcdn.net/v/t39.24130-2/10000000_436361210592336_2238282300415174398_n.mp4?_nc_cat=108&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=1yKGk228yoQAQmsXxMA9apxakClZKJb5iDZvblX-aUFrmOKtCaeVP2LGw&_nc_ht=video.xx&oh=d86abd4004c521ff3dbc4ec7908ca2ea&oe=5E82E123",
        "https://video.xx.fbcdn.net/v/t39.24130-2/10000000_1690940984374696_2634330658137698865_n.mp4?_nc_cat=107&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=_VLUBQZnRSIAQlhkC2f1e7b-0I8KgxJkAh2c3ErUeRYavXeTrAs_XTODw&_nc_ht=video.xx&oh=022aef12308d3c82ac4b411e875af121&oe=5E46B18A",
        "https://video.xx.fbcdn.net/v/t42.9040-2/10000000_508917189694755_1784848800305643520_n.mp4?_nc_cat=102&vs=b922733d487e396e&_nc_vs=HBksFQAYJEdJQ1dtQUFqMVVfRTI4NEJBQUFBQUFDSERzVVlibEFqQUFBRhUAABUAGCRHSUNXbUFCSE54TjctNkVJQUFBQUFBRDhpZEJYYnY0R0FBQUYVAgBLAYgScHJvZ3Jlc3NpdmVfcmVjaXBlATEVACUAHAAAGA8xMDAwMDM2NzczMzUxMjIWsuvuwZudpAYVhk4ZBRgCQzMYC3Z0c19wcmV2aWV3HBdApJ%2FMSbpeNRgYZGFzaF92NF9ocTJfZnJhZ18yX3ZpZGVvEgAYGHZpZGVvcy52dHMuY2FsbGJhY2sucHJvZBkcFQAVhPkCACgSVklERU9fVklFV19SRVFVRVNUGwOIFW9lbV90YXJnZXRfZW5jb2RlX3RhZwZvZXBfaGQTb2VtX3JlcXVlc3RfdGltZV9tcw0xNTc0OTIzNTAwMDE2DG9lbV9jZmdfcnVsZQd1bm11dGVkJQIcHBwVABsBVQAAGwFVAAAcFQIAAAAAAA%3D%3D&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=Z1x2Z7FkJH4AQmrYyqc3osj0-t8e9xFqbhwO_oqEn5GD5Gq3DsXZzyDYQ&_nc_ht=video.xx&oh=401d79b2a47b75671a147ed5392e228b&oe=5DE2507A&_nc_rid=f9581c111a604bd",
        "https://video.xx.fbcdn.net/v/t42.27313-2/10000000_1500590396745497_7596801723528642560_n.mp4?_nc_cat=111&vs=6cccb8e527edaa6c&_nc_vs=HBksFQAYJEdJQ1dtQUFaSjQxdHgxUUZBQUFBQUFEclFtMXBickZxQUFBRhUAABUAGCRHSUNXbUFCV3NrTXg3SkFCQUFBQUFBRFlMNU5JYnJGcUFBQUYVAgBLAYgScHJvZ3Jlc3NpdmVfcmVjaXBlATEVACUAHAAAGA8xMDAwMDM2NzczMzUxMjIW%2BpWG3aidpAYVhk4ZBRgCQzMYC3Z0c19wcmV2aWV3HBdApJXcKPXCjxgeZGFzaF9iYXNpY192NF9ocTFfZnJhZ18yX3ZpZGVvEgAYGHZpZGVvcy52dHMuY2FsbGJhY2sucHJvZBkcFQAVhPkCACgSVklERU9fVklFV19SRVFVRVNUGwOIFW9lbV90YXJnZXRfZW5jb2RlX3RhZwZvZXBfaGQTb2VtX3JlcXVlc3RfdGltZV9tcw0xNTc0OTIzNTM3MTYzDG9lbV9jZmdfcnVsZQd1bm11dGVkJQIcHBwVABsBVQAAGwFVAAAcFQIAAAAAAA%3D%3D&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=-6qD6riR-ngAQmBbozZFFZD3FwPT_sxzyx89bdLBQP45zrJk1ntC-9gqQ&_nc_ht=video.xx&oh=c6980902799bbf5f31234aed09a3184e&oe=5DE11E59&_nc_rid=a389c6783c2f462",
        "https://video.xx.fbcdn.net/v/t42.9040-2/10000000_440820246834015_5292834687310364672_n.mp4?_nc_cat=107&vs=735eb8e1ef8c69a5&_nc_vs=HBksFQAYJEdJQ1dtQUJmNnpoMjdKQUJBQUFBQUFBYjdYTkpibEFqQUFBRhUAABUAGCRHSUNXbUFBcGhTNTVBNlFKQUFBQUFBRFpEMVVsYnY0R0FBQUYVAgBLAYgScHJvZ3Jlc3NpdmVfcmVjaXBlATEVACUAHAAAGA8xMDAwMDM2NzczMzUxMjIW1sOxwtimpAYVhk4ZBRgCQzMYC3Z0c19wcmV2aWV3HBdApFsFHrhR7BgYZGFzaF92NF9ocTFfZnJhZ18yX3ZpZGVvEgAYGHZpZGVvcy52dHMuY2FsbGJhY2sucHJvZBkcFQAVhPkCACgSVklERU9fVklFV19SRVFVRVNUGwOIFW9lbV90YXJnZXRfZW5jb2RlX3RhZwZvZXBfaGQTb2VtX3JlcXVlc3RfdGltZV9tcw0xNTc0OTIzNTU4MTk5DG9lbV9jZmdfcnVsZQd1bm11dGVkJQIcHBwVABsBVQAAGwFVAAAcFQIAAAAAAA%3D%3D&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=g89CEdDBlfoAQlI5pE4QwqC3clOviFtIZB7k4LB4inMVvOehp3UIVQuDA&_nc_ht=video.xx&oh=252a252831ba95626f2100ee1defd5d1&oe=5DE21D98&_nc_rid=596709a34d38453",
        "https://video.xx.fbcdn.net/v/t42.9040-2/10000000_533472014165995_5937905257244786688_n.mp4?_nc_cat=108&vs=cd9f26f262f2cf93&_nc_vs=HBksFQAYJEdJQ1dtQURyNV9haE1PVUJBQUFBQUFCZnJXZFNibEFqQUFBRhUAABUAGCRHSUNXbUFEMlFUdVpVZDhDQUFBQUFBQ0ZDMHg1YnY0R0FBQUYVAgBLAYgScHJvZ3Jlc3NpdmVfcmVjaXBlATEVACUAHAAAGA8xMDAwMDM2NzczMzUxMjIW%2Fouv%2BOqHpQYVhk4ZBRgCQzMYC3Z0c19wcmV2aWV3HBdApJ8CDEm6XhgYZGFzaF92NF9ocTFfZnJhZ18yX3ZpZGVvEgAYGHZpZGVvcy52dHMuY2FsbGJhY2sucHJvZBkcFQAVhPkCACgSVklERU9fVklFV19SRVFVRVNUGwOIFW9lbV90YXJnZXRfZW5jb2RlX3RhZwZvZXBfaGQTb2VtX3JlcXVlc3RfdGltZV9tcw0xNTc0OTIzNTgwNTU1DG9lbV9jZmdfcnVsZQd1bm11dGVkJQIcHBwVABsBVQAAGwFVAAAcFQIAAAAAAA%3D%3D&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=xwKT5VSg9HgAQk6IR4WozguxpBr6Nx8JUyzWEQs5rG3ttdhSfekRDK5pw&_nc_ht=video.xx&oh=3c4ee7949b49add645df513c11b26fec&oe=5DE21F23&_nc_rid=e08ba6aa025a428",
        "https://video.xx.fbcdn.net/v/t42.9040-2/10000000_511480773042953_4161169332333707264_n.mp4?_nc_cat=102&vs=4274f6e08b2e6943&_nc_vs=HBksFQAYJEdJQ1dtQUFKWThsbE1ORUJBQUFBQUFCMmNiODVibEFqQUFBRhUAABUAGCRHSUNXbUFELThPNGxWSHNDQUFBQUFBQ3VjMW81YnY0R0FBQUYVAgBLAYgScHJvZ3Jlc3NpdmVfcmVjaXBlATEVACUAHAAAGA8xMDAwMDM2NzczMzUxMjIWvrbO7fX7pAYVhk4ZBRgCQzMYC3Z0c19wcmV2aWV3HBdApJgi0OVgQhgYZGFzaF92NF9ocTFfZnJhZ18yX3ZpZGVvEgAYGHZpZGVvcy52dHMuY2FsbGJhY2sucHJvZBkcFQAVhPkCACgSVklERU9fVklFV19SRVFVRVNUGwOIFW9lbV90YXJnZXRfZW5jb2RlX3RhZwZvZXBfaGQTb2VtX3JlcXVlc3RfdGltZV9tcw0xNTc0OTIzNzg3MTA3DG9lbV9jZmdfcnVsZQd1bm11dGVkJQIcHBwVABsBVQAAGwFVAAAcFQIAAAAAAA%3D%3D&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=8q9zPWtgNjAAQm8vUKsGIhj07taWapdwU-QjaqJgrIFlgDk0UlLssn78A&_nc_ht=video.xx&oh=edb769a2d4ae6d6af0c8752dbd92c4fa&oe=5DE20C84&_nc_rid=c1eeece5868d44f",
        "https://video.xx.fbcdn.net/v/t42.9040-2/10000000_433174887341909_5274856796022898688_n.mp4?_nc_cat=108&vs=a7e4dd2b75beb7e&_nc_vs=HBksFQAYJEdJQ1dtQUJWSDBsal9Ja0JBQUFBQUFCUERqUkpibEFqQUFBRhUAABUAGCRHSUNXbUFCcFR6UkM3QThEQUFBQUFBRE42Y3NEYnY0R0FBQUYVAgBLAYgScHJvZ3Jlc3NpdmVfcmVjaXBlATEVACUAHAAAGA8xMDAwMDM2NzczMzUxMjIWzq3ZoNf3pAYVhk4ZBRgCQzMYC3Z0c19wcmV2aWV3HBdApJaan752yRgYZGFzaF92NF9ocTFfZnJhZ18yX3ZpZGVvEgAYGHZpZGVvcy52dHMuY2FsbGJhY2sucHJvZBkcFQAVhPkCACgSVklERU9fVklFV19SRVFVRVNUGwOIFW9lbV90YXJnZXRfZW5jb2RlX3RhZwZvZXBfaGQTb2VtX3JlcXVlc3RfdGltZV9tcw0xNTc0OTIzODA5MzAxDG9lbV9jZmdfcnVsZQd1bm11dGVkJQIcHBwVABsBVQAAGwFVAAAcFQIAAAAAAA%3D%3D&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=k8KSer22In0AQluGccmvRwBSwVV2-JOd4kiTUeyd7Gwf5EH7_fjqHC3ug&_nc_ht=video.xx&oh=4989ba79bce2d1b6eb861de7b08dcfb1&oe=5DE2001F&_nc_rid=2cc1ffb7dc55459",
        "https://video.xx.fbcdn.net/v/t42.9040-2/10000000_419834552027072_3701903123548209152_n.mp4?_nc_cat=105&vs=ef6292c5dda00e18&_nc_vs=HBksFQAYJEdJQ1dtQURBaDFaWjFuMEJBQUFBQUFCSHpWOHpibEFqQUFBRhUAABUAGCRHSUNXbUFBZzZrVDR4SkFCQUFBQUFBQlNJdlFaYnY0R0FBQUYVAgBLAYgScHJvZ3Jlc3NpdmVfcmVjaXBlATEVACUAHAAAGA8xMDAwMDM2NzczMzUxMjIW4uad64XvpAYVhk4ZBRgCQzIYC3Z0c19wcmV2aWV3HBdApJnO2RaHKxgYZGFzaF92NF9ocTFfZnJhZ18yX3ZpZGVvEgAYGHZpZGVvcy52dHMuY2FsbGJhY2sucHJvZBkcFQAVhPkCACgSVklERU9fVklFV19SRVFVRVNUGwOIFW9lbV90YXJnZXRfZW5jb2RlX3RhZwZvZXBfaGQTb2VtX3JlcXVlc3RfdGltZV9tcw0xNTc0OTIzODMzMDI5DG9lbV9jZmdfcnVsZQd1bm11dGVkJQIcHBwVABsBVQAAGwFVAAAcFQIAAAAAAA%3D%3D&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=QzR-h08fEWgAQnvevirWkDHs5ElwHEmcZNKgH6TLk8l-EAxSmBNhcBFGA&_nc_ht=video.xx&oh=caa94eade16eca6db0deef1757a83906&oe=5DE232AD&_nc_rid=b9347031e4274c0",
        "https://video.xx.fbcdn.net/v/t42.9040-2/10000000_956732788032294_7358016776120041472_n.mp4?_nc_cat=106&vs=400b0c5ffd543039&_nc_vs=HBksFQAYJEdJQ1dtQUFtdy1tMUpHWURBQUFBQUFCRzdSeG1ibEFqQUFBRhUAABUAGCRHSUNXbUFEWDU0YjNRUndDQUFBQUFBQkFLZE01YnY0R0FBQUYVAgBLAYgScHJvZ3Jlc3NpdmVfcmVjaXBlATEVACUAHAAAGA8xMDAwMDM2NzczMzUxMjIW7MTH%2BPibpQYVhk4ZBRgCQzMYC3Z0c19wcmV2aWV3HBdAo%2FoN0vGp%2FBgYZGFzaF92NF9ocTFfZnJhZ18yX3ZpZGVvEgAYGHZpZGVvcy52dHMuY2FsbGJhY2sucHJvZBkcFQAVhPkCACgSVklERU9fVklFV19SRVFVRVNUGwOIFW9lbV90YXJnZXRfZW5jb2RlX3RhZwZvZXBfaGQTb2VtX3JlcXVlc3RfdGltZV9tcw0xNTc0OTIzODU3OTUwDG9lbV9jZmdfcnVsZQd1bm11dGVkJQIcHBwVABsBVQAAGwFVAAAcFQIAAAAAAA%3D%3D&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=93dhvlMVafEAQnQrdVBDinnTLm8yjvXaiTnrOTR7hvYt8CfTZKBCuPcmQ&_nc_ht=video.xx&oh=6d3dfee658ea7961f5e4429e19f55ada&oe=5DE1FC60&_nc_rid=67b40a76291348b"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoView = findViewById<VideoView>(R.id.videoView)
        val videoUrl = "http://clips.vorwaerts-gmbh.de/VfE_html5.mp4"
        //Creating MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        /* try {
            // ID của file video.
            int id = this.getRawResIdByName("myvideo");
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        */
        videoView.setOnPreparedListener { mediaPlayer ->
            mediaController.setAnchorView(videoView)

            // Khi màn hình Video thay đổi kích thước
            mediaPlayer.setOnVideoSizeChangedListener { mp, width, height ->
                // Neo lại vị trí của bộ điều khiển của nó vào VideoView.
                mediaController.setAnchorView(videoView)
            }
        }

        //specify the location of media file
        val uri:Uri = Uri.parse(urls[index])
        //Setting MediaController and URI, then starting the videoView
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()

        // get reference to button
        /*val btn_click_me = findViewById(R.id.btn_click_me) as Button
        // set on-click listener
        btn_click_me.setOnClickListener {
            index++
            if(index == 10) index = 0
            videoView.suspend();
            // your code to perform when the user clicks on the button
            val uri:Uri = Uri.parse(urls[index])
            //Setting MediaController and URI, then starting the videoView
            videoView.setMediaController(mediaController)
            videoView.setVideoURI(uri)
            videoView.requestFocus()
            videoView.start()
        }

        // get reference to button
        val btn_exit = findViewById(R.id.btn_exit) as Button
        // set on-click listener
        btn_exit.setOnClickListener {
            finish();
            System.exit(0);
        }

        val btn_rate = findViewById(R.id.btn_rate) as Button
        // set on-click listener
        btn_rate.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID)
                )
            )
        }*/


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
