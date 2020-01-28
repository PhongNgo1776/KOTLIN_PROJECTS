/*
 * Copyright 2017 Dev Labs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sw.serieshkfilms

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import bg.devlabs.fullscreenvideoview.orientation.LandscapeOrientation
import bg.devlabs.fullscreenvideoview.orientation.PortraitOrientation
import bg.devlabs.fullscreenvideoview.playbackspeed.PlaybackSpeedOptions
import kotlinx.android.synthetic.main.activity_action_bar.*
import java.io.File
import java.time.Duration


/**
 * Created by Slavi Petrov on 13.10.2017
 * Dev Labs
 * slavi@devlabs.bg
 */
class ActionBarActivity : AppCompatActivity() {
    var index = 0
    val urls = arrayOf(
            "https://video.xx.fbcdn.net/v/t39.24130-2/10000000_436361210592336_2238282300415174398_n.mp4?_nc_cat=108&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=1yKGk228yoQAQmsXxMA9apxakClZKJb5iDZvblX-aUFrmOKtCaeVP2LGw&_nc_ht=video.xx&oh=d86abd4004c521ff3dbc4ec7908ca2ea&oe=5E82E123",
            "https://video.xx.fbcdn.net/v/t39.24130-2/10000000_1690940984374696_2634330658137698865_n.mp4?_nc_cat=107&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=_VLUBQZnRSIAQlhkC2f1e7b-0I8KgxJkAh2c3ErUeRYavXeTrAs_XTODw&_nc_ht=video.xx&oh=022aef12308d3c82ac4b411e875af121&oe=5E46B18A",
            "https://video.xx.fbcdn.net/v/t42.9040-2/10000000_1345869978929091_8480308553951739904_n.mp4?_nc_cat=101&vs=a0cd8aa43f5be5c&_nc_vs=HBksFQAYJEdJQ1dtQUREQndMR0Q4Z0VBQUFBQUFDekc3QjFibEFqQUFBRhUAABUAGCRHSUNXbUFDcGFGQW1YT2NJQUFBQUFBQ1pGa1lVYnY0R0FBQUYVAgBLAYgScHJvZ3Jlc3NpdmVfcmVjaXBlATEVACUAHAAAGA8xMDAwMDM2NzczMzUxMjIW3OPfpMyapQYVhk4ZBRgCQzMYC3Z0c19wcmV2aWV3HBdApDPTdLxqfxgYZGFzaF92NF9ocTFfZnJhZ18yX3ZpZGVvEgAYGHZpZGVvcy52dHMuY2FsbGJhY2sucHJvZBkcFQAVhPkCACgSVklERU9fVklFV19SRVFVRVNUGwOIFW9lbV90YXJnZXRfZW5jb2RlX3RhZwZvZXBfaGQTb2VtX3JlcXVlc3RfdGltZV9tcw0xNTc1NjQ4OTU5MDQ5DG9lbV9jZmdfcnVsZQd1bm11dGVkJQIcHBwVABsBVQAAGwFVAAAcFQIAAAAAAA%3D%3D&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=OvEHlDYdWOgAQkXfjXq7ykwYy6hyQvWzcFj2X5kZlFbAx038B8XJ9hC3A&_nc_ht=video.xx&oh=c6c13dced632d619db54e8559dd377f1&oe=5DEC5642&_nc_rid=56803494944a4e0",
            "https://video.xx.fbcdn.net/v/t42.9040-2/10000000_3383505555023122_3119781999485648896_n.mp4?_nc_cat=111&vs=a79330622acfe4fb&_nc_vs=HBksFQAYJEdJQ1dtQUFTNWJQR1J3VU1BQUFBQUFBenNVc3JibEFqQUFBRhUAABUAGCRHSUNXbUFDcHVnUUFsbm9DQUFBQUFBQ0lIVXRUYnY0R0FBQUYVAgBLAYgScHJvZ3Jlc3NpdmVfcmVjaXBlATEVACUAHAAAGA8xMDAwMDM2NzczMzUxMjIW9uLui4XvpAYVhk4ZBRgCQzMYC3Z0c19wcmV2aWV3HBdApKNIMSbpeRgYZGFzaF92NF9ocTFfZnJhZ18yX3ZpZGVvEgAYGHZpZGVvcy52dHMuY2FsbGJhY2sucHJvZBkcFQAVhPkCACgSVklERU9fVklFV19SRVFVRVNUGwOIFW9lbV90YXJnZXRfZW5jb2RlX3RhZwZvZXBfaGQTb2VtX3JlcXVlc3RfdGltZV9tcw0xNTc1NjQ4OTkwNjgwDG9lbV9jZmdfcnVsZQd1bm11dGVkJQIcHBwVABsBVQAAGwFVAAAcFQIAAAAAAA%3D%3D&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=JINjlQOTIwQAQmG5GX_7XIqGuZT-rMDRW8pW_usskbeFNamxlu8nhWkoA&_nc_ht=video.xx&oh=58e36ce003e44f97394af15b62fd7cf8&oe=5DED77BB&_nc_rid=215cefc704e9422",
            "https://video.xx.fbcdn.net/v/t42.9040-2/10000000_476884026292560_1411690140274786304_n.mp4?_nc_cat=108&vs=918b35e402e8f3e8&_nc_vs=HBksFQAYJEdJQ1dtQUJRZWZ3MnViRUJBQUFBQUFDMFZKY1RibEFqQUFBRhUAABUAGCRHSUNXbUFDOGNWUHRRZ1FKQUFBQUFBREtIOFI1YnY0R0FBQUYVAgBLAYgScHJvZ3Jlc3NpdmVfcmVjaXBlATEVACUAHAAAGA8xMDAwMDM2NzczMzUxMjIW4rvXtofvpAYVhk4ZBRgCQzMYC3Z0c19wcmV2aWV3HBdApKw%2Bdsi0ORgYZGFzaF92NF9ocTFfZnJhZ18yX3ZpZGVvEgAYGHZpZGVvcy52dHMuY2FsbGJhY2sucHJvZBkcFQAVhPkCACgSVklERU9fVklFV19SRVFVRVNUGwOIFW9lbV90YXJnZXRfZW5jb2RlX3RhZwZvZXBfaGQTb2VtX3JlcXVlc3RfdGltZV9tcw0xNTc1NjQ5MDE3NjA3DG9lbV9jZmdfcnVsZQd1bm11dGVkJQIcHBwVABsBVQAAGwFVAAAcFQIAAAAAAA%3D%3D&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=WR0Hu-RNPmQAQkw2WJ4GyYicU567wAp1vFdVW8j6_AMtu6FWCg3jX_HFw&_nc_ht=video.xx&oh=97820de2513659108c4ad688c0e9a16e&oe=5DEC47EC&_nc_rid=3cbf5c49bdf5440",
            "https://video.xx.fbcdn.net/v/t42.9040-2/10000000_419305438747603_7879927479509450752_n.mp4?_nc_cat=106&vs=a75c87aa67246074&_nc_vs=HBksFQAYJEdJQ1dtQURUbTdvblczMEJBQUFBQUFCTElGdHRibEFqQUFBRhUAABUAGCRHSUNXbUFCdjIxODVYc3dDQUFBQUFBQ0JYdmRmYnY0R0FBQUYVAgBLAYgScHJvZ3Jlc3NpdmVfcmVjaXBlATEVACUAHAAAGA8xMDAwMDM2NzczMzUxMjIWvOnw64jvpAYVhk4ZBRgCQzMYC3Z0c19wcmV2aWV3HBdApJ0DEm6XjRgYZGFzaF92NF9ocTFfZnJhZ18yX3ZpZGVvEgAYGHZpZGVvcy52dHMuY2FsbGJhY2sucHJvZBkcFQAVhPkCACgSVklERU9fVklFV19SRVFVRVNUGwOIFW9lbV90YXJnZXRfZW5jb2RlX3RhZwZvZXBfaGQTb2VtX3JlcXVlc3RfdGltZV9tcw0xNTc1NjQ5MDQxOTQyDG9lbV9jZmdfcnVsZQd1bm11dGVkJQIcHBwVABsBVQAAGwFVAAAcFQIAAAAAAA%3D%3D&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=0BzVJXIfvnAAQkIpn_Zl2j7Au4Lcj89vEF3ZZD5mv2S_BN13VycXry2qA&_nc_ht=video.xx&oh=5adad8d321c853a85caafc1691e4dce6&oe=5DEC839B&_nc_rid=c048b901350943e",
            "https://video.xx.fbcdn.net/v/t42.9040-2/10000000_505791853343039_4883105553280139264_n.mp4?_nc_cat=100&vs=6c694093544215fb&_nc_vs=HBksFQAYJEdJQ1dtQUEtc2ItWEE4d0JBQUFBQUFDaFJzUkRibEFqQUFBRhUAABUAGCRHSUNXbUFBNGxaQ0xIcEVCQUFBQUFBQkVEcmQ3YnY0R0FBQUYVAgBLAYgScHJvZ3Jlc3NpdmVfcmVjaXBlATEVACUAHAAAGA8xMDAwMDM2NzczMzUxMjIW6Nf8sIrvpAYVhk4ZBRgCQzMYC3Z0c19wcmV2aWV3HBdApK4CDEm6XhgYZGFzaF92NF9ocTFfZnJhZ18yX3ZpZGVvEgAYGHZpZGVvcy52dHMuY2FsbGJhY2sucHJvZBkcFQAVhPkCACgSVklERU9fVklFV19SRVFVRVNUGwOIFW9lbV90YXJnZXRfZW5jb2RlX3RhZwZvZXBfaGQTb2VtX3JlcXVlc3RfdGltZV9tcw0xNTc1NjQ5MDYxNjU1DG9lbV9jZmdfcnVsZQd1bm11dGVkJQIcHBwVABsBVQAAGwFVAAAcFQIAAAAAAA%3D%3D&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=WQtSDW_NBb8AQmG1hqUobgFoMBmfFtT36KbnvY7ZtDlJzqY66RweQFpuQ&_nc_ht=video.xx&oh=fdadde02e2c296e2356a3ad56520570b&oe=5DEC719C&_nc_rid=aa1f37dffdd44d4",
            "https://video.xx.fbcdn.net/v/t42.9040-2/10000000_458261428160394_7055715331192389632_n.mp4?_nc_cat=111&vs=3d3f5075dff1c762&_nc_vs=HBksFQAYJEdJQ1dtQUNLeDZOTnlhQUJBQUFBQUFDMjdfcGhibEFqQUFBRhUAABUAGCRHSUNXbUFBLUd1enZyUzRJQUFBQUFBQzZKYmtYYnY0R0FBQUYVAgBLAYgScHJvZ3Jlc3NpdmVfcmVjaXBlATEVACUAHAAAGA8xMDAwMDM2NzczMzUxMjIW0I%2B1o4vvpAYVhk4ZBRgCQzMYC3Z0c19wcmV2aWV3HBdApKydsi0OVhgYZGFzaF92NF9ocTFfZnJhZ18yX3ZpZGVvEgAYGHZpZGVvcy52dHMuY2FsbGJhY2sucHJvZBkcFQAVhPkCACgSVklERU9fVklFV19SRVFVRVNUGwOIFW9lbV90YXJnZXRfZW5jb2RlX3RhZwZvZXBfaGQTb2VtX3JlcXVlc3RfdGltZV9tcw0xNTc1NjQ5MDgzMDQ0DG9lbV9jZmdfcnVsZQd1bm11dGVkJQIcHBwVABsBVQAAGwFVAAAcFQIAAAAAAA%3D%3D&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=csThi-g309AAQnvbO6NG62tAY961VpFRPvN3PlkEoC3Mj7f_RiXx00b3Q&_nc_ht=video.xx&oh=14e3003305f9bdcd26b019bd872f3e2d&oe=5DED73F3&_nc_rid=d684bf3860a749f",
            "https://video.xx.fbcdn.net/v/t42.9040-2/10000000_2511446449090103_8075372921251430400_n.mp4?_nc_cat=105&vs=69c4689b18e028cb&_nc_vs=HBksFQAYJEdJQ1dtQUEzYm5peEpld0lBQUFBQUFEamZCRndibEFqQUFBRhUAABUAGCRHSUNXbUFBOEFKZGdpYUFCQUFBQUFBQ3lFMzVNYnY0R0FBQUYVAgBLAYgScHJvZ3Jlc3NpdmVfcmVjaXBlATEVACUAHAAAGA8xMDAwMDM2NzczMzUxMjIWvrmf%2BYvvpAYVhk4ZBRgCQzMYC3Z0c19wcmV2aWV3HBdApIdrAgxJuhgYZGFzaF92NF9ocTFfZnJhZ18yX3ZpZGVvEgAYGHZpZGVvcy52dHMuY2FsbGJhY2sucHJvZBkcFQAVhPkCACgSVklERU9fVklFV19SRVFVRVNUGwOIFW9lbV90YXJnZXRfZW5jb2RlX3RhZwZvZXBfaGQTb2VtX3JlcXVlc3RfdGltZV9tcw0xNTc1NjQ5MTA3OTg2DG9lbV9jZmdfcnVsZQd1bm11dGVkJQIcHBwVABsBVQAAGwFVAAAcFQIAAAAAAA%3D%3D&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=XvK0_CJH8gYAQnVcwyF0Oq-xFKrH45j1PNuoCUkJqFyOLdh5viNn7ziTg&_nc_ht=video.xx&oh=bb865911aed2992b100afff143264076&oe=5DEC96E7&_nc_rid=7622f5ca15e24ba",
            "https://video.xx.fbcdn.net/v/t39.24130-2/10000000_184071482760377_4516616172634221526_n.mp4?_nc_cat=104&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=84smV4jVlDgAQlbsi0ydR9LR3_yl2WN2se0qt_z4hWrkL65yzzHglZxvg&_nc_ht=video.xx&oh=d31cb5820dd2b9d55f009c49663e03ee&oe=5E6FD574"
    )

    companion object {
        fun start(context: Context) {
            val starter = Intent(context, ActionBarActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_bar)

        index = (0..9).random();
        Toast.makeText(this,index.toString(), Toast.LENGTH_SHORT).show()
        // Change the ActionBar title
        supportActionBar?.title = getString(R.string.action_bar_activity)
        fullscreenVideoView.videoUrl(urls[0])
                .progressBarColor(R.color.colorAccent)
                .landscapeOrientation(LandscapeOrientation.SENSOR)
                .portraitOrientation(PortraitOrientation.DEFAULT)
                .thumbnail(R.drawable.video_thumbnail)
                .addSeekForwardButton()
                .addSeekBackwardButton()
                .enableAutoStart()
                .playbackSpeedOptions(
                        PlaybackSpeedOptions()
                                .addSpeeds(arrayListOf(0.25f, 0.5f, 0.75f, 1f))
                )

        btnClickMe.setOnClickListener {
            index++
            if(index == 10) index = 0

            fullscreenVideoView.videoUrl(urls[1])
            // your code to perform when the user clicks on the button
            //Setting MediaController and URI, then starting the videoView
//            fullscreenVideoView.videoUrl(urls[index])
//                    .progressBarColor(R.color.colorAccent)
//                    .landscapeOrientation(LandscapeOrientation.SENSOR)
//                    .portraitOrientation(PortraitOrientation.DEFAULT)
//                    .thumbnail(R.drawable.video_thumbnail)
//                    .addSeekForwardButton()
//                    .addSeekBackwardButton()
//                    .playbackSpeedOptions(
//                            PlaybackSpeedOptions()
//                                    .addSpeeds(arrayListOf(0.25f, 0.5f, 0.75f, 1f))
//                    )
            //Toast.makeText(this,"Phong....", Toast.LENGTH_SHORT).show()
        }
    }
}