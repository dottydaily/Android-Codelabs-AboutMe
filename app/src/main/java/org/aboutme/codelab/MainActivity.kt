package org.aboutme.codelab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // connect the layout file with the Activity
        setContentView(R.layout.activity_main)
    }
}
