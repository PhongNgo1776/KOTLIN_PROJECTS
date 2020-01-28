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
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_no_action_bar.*

class NoActionBarActivity : AppCompatActivity() {
    companion object {
        fun start(context: Context) {
            val starter = Intent(context, NoActionBarActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_action_bar)
        val videoPath = "https://video.xx.fbcdn.net/v/t39.24130-2/10000000_184071482760377_4516616172634221526_n.mp4?_nc_cat=104&efg=eyJ2ZW5jb2RlX3RhZyI6Im9lcF9oZCJ9&_nc_ohc=84smV4jVlDgAQlbsi0ydR9LR3_yl2WN2se0qt_z4hWrkL65yzzHglZxvg&_nc_ht=video.xx&oh=d31cb5820dd2b9d55f009c49663e03ee&oe=5E6FD574"
        fullscreenVideoView.videoUrl(videoPath)
    }
}
