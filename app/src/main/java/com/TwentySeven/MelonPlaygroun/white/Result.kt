package com.TwentySeven.MelonPlaygroun.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.TwentySeven.MelonPlaygroun.R

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val score=findViewById<TextView>(R.id.score)
        val btn=findViewById<ImageView>(R.id.restart)
        score.text = getIntent().getStringExtra("key")
        btn.setOnClickListener{
            startActivity(Intent(this, Game::class.java))
        }
    }
}