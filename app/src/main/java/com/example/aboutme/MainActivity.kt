package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Adam Kovacs")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main) HELYETT:
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        // findViewById<Button>(R.id.done_button).setOnClickListener {
        //    addNickname(it)
        // }
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
        // val editText = findViewById<EditText>(R.id.nickname_edit)
        // val nicknameTextView = findViewById<TextView>(R.id.nickText)

        binding.apply {
            // nicknameTextView.text = editText.text HELYETT:
            // nickText.text = nicknameEdit.text HELYETT:
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll() // Invalidate all previous binding expressions

            // editText.visibility = View.GONE HELYETT:
            nicknameEdit.visibility = View.GONE
            // view.visibility = View.GONE HELYETT:
            doneButton.visibility = View.GONE
            // nicknameTextView.visibility = View.VISIBLE HELYETT:
            nickText.visibility = View.VISIBLE
        }

        //Hide keyboard - Billentyuzetet elrejt
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
