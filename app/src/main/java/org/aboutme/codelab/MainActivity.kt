package org.aboutme.codelab

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // connect the layout file with the Activity
        setContentView(R.layout.activity_main)

        done_button.setOnClickListener {
            addNickname(it)
        }

        nickname_text.setOnClickListener {
            updateNickname(it)
        }
    }

    // Helper method
    private fun addNickname(view: View) {
        if (nickname_text.text.isBlank()) {
            Toast.makeText(this, "Enter your nickname first!", Toast.LENGTH_SHORT).show()
        } else {
            nickname_text.apply {
                text = nickname_edit.text
                visibility = View.VISIBLE
            }.also {
                nickname_edit.visibility = View.GONE
                done_button.visibility = View.GONE
            }

            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun updateNickname(view: View) {
        let {
            nickname_edit.visibility = View.VISIBLE
            done_button.visibility = View.VISIBLE
        }.also {
            view.visibility = View.GONE
        }
    }
}
