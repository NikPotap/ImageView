package com.example.imageview

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var toolbarSecondTB: Toolbar
    private lateinit var imageViewIV: ImageView
    private lateinit var buttonNextBTN: Button
    private val images = listOf("one", "two", "three", "four", "five")
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        toolbarSecondTB = findViewById(R.id.toolbarSecondTB)
        setSupportActionBar(toolbarSecondTB)

        imageViewIV = findViewById(R.id.imageViewIV)

        buttonNextBTN = findViewById(R.id.buttonNextBTN)
        imageViewIV.setImageResource(R.drawable.one)
        buttonNextBTN.setOnClickListener {
            if (++counter == images.size){
                val intent = Intent(this, LastActivity::class.java)
                finish()
                startActivity(intent)
            }

            val resID = getResources().getIdentifier(images[counter], "drawable", getPackageName());
            imageViewIV.setImageResource(resID)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.second_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
    override fun onClick(per: View?) {}
}