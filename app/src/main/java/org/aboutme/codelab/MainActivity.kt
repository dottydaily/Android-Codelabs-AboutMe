package org.aboutme.codelab

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.aboutme.codelab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Data-binding object
    private lateinit var binding: ActivityMainBinding

    // object of Myname's data class
    private val myName: MyName = MyName("Pornpat Santibuppakul")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        // connect the layout file with the Activity (default way)
//        setContentView(R.layout.activity_main)

        // use setContentView() from DataBindingUtil instead (data-binding)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // binding data
        binding.apply {
            myName = this@MainActivity.myName

            // set on click listener
            doneButton.setOnClickListener { addNickname(it) }
            nicknameText.setOnClickListener { updateNickname(it) }
        }
    }

    // Helper method
    private fun addNickname(view: View) {
        binding.apply {
            if (nickname_edit.text.isBlank()) {
                Toast.makeText(this@MainActivity, "Enter your nickname first!",
                    Toast.LENGTH_SHORT).show()
            } else {
                myName?.nickname = nicknameEdit.text.toString()

                nicknameEdit.visibility = View.GONE
                doneButton.visibility = View.GONE
                nicknameText.visibility = View.VISIBLE

                // invalidate all binding expressions so that they are recreated with the correct data
                invalidateAll()

                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }

    private fun updateNickname(view: View) {
        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
            doneButton.visibility = View.VISIBLE
        }.also {
            view.visibility = View.GONE
        }
    }
}
