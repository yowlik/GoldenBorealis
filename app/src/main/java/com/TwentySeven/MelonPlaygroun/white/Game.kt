package com.TwentySeven.MelonPlaygroun.white

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import com.TwentySeven.MelonPlaygroun.R
import com.TwentySeven.MelonPlaygroun.databinding.ActivityGameBinding
import kotlinx.android.synthetic.main.activity_game.*
import org.w3c.dom.Text
import kotlin.concurrent.timer


class Game : AppCompatActivity() {
    var src=0
    lateinit var im1:ImageView
    lateinit var im2:ImageView
    val roll=mutableListOf<String>("Cow","Owl","Rabbit","1","2")
    private var timer:CountDownTimer?=null
    private lateinit var binding: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
                startTimer(30000)
        }


        }
    fun check(i:String,im: ImageView){
        if(i=="Cow"){
            im.setImageResource(R.drawable.planet07)
        }else if(i=="Owl"){
            im.setImageResource(R.drawable.planet08)

        }
        else if(i=="1"||i=="2") {
            im.setImageResource(R.drawable.planet09)

        }
        else
        {
            im.setImageResource(R.drawable.planet03)
        }

    }
    private fun startTimer(timeMillis:Long){

        timer=object : CountDownTimer(timeMillis,1000){

            override fun onTick(TimeEl: Long) {
                val im22="1"
                check(im22,binding.imageView2)
                var im11=roll.random()
                check(im11,binding.imageView)
                binding.imageView2.setOnClickListener{
                    if(im11==im22||im11=="2"){
                        src++
                        binding.scoret.text="$src"
                    }
                    else{
                        src--
                        binding.scoret.text="$src"
                    }
                }
                binding.timend.text="${(TimeEl/1000).toString()}"

            }

            override fun onFinish() {
                val scrscr:String = src.toString()
                val intent = Intent(this@Game, Result::class.java)
                intent.putExtra("key", scrscr)
                startActivity(intent)

            }

        }.start()

    }

 }


