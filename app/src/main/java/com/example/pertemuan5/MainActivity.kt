package com.example.pertemuan5

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pertemuan5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "Lifecycle"
    private val EXTRA_NAME = "EXT_NAME"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnToSecond.setOnClickListener{
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra(EXTRA_NAME, textInput.text.toString())
                startActivity(intent)
            }

            btnSend.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, "Hallo Message")
                startActivity(intent)
            }

            btnPhone.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:12345678")
                startActivity(intent)
            }

            btnUrl.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.google.com")
                startActivity(intent)
            }
        }
        Log.d(TAG, "onCreate: Hello")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Hello")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Hello")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Hello")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Hello")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Hello")
    }
}