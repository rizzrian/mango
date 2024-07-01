package com.example.wow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var bt_join = findViewById<Button>(R.id.bt_join)
        var tv_homePW: EditText = findViewById<EditText>(R.id.tv_homePW)
        var tv_homeName: EditText = findViewById<EditText>(R.id.tv_homeName)
        var tv_homeID: EditText = findViewById<EditText>(R.id.tv_homeId)

        bt_join.setOnClickListener {

            if (tv_homeID.text.isEmpty() || tv_homeName.text.isEmpty() || tv_homePW.text.isEmpty()) {

                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "회원가입성공", Toast.LENGTH_SHORT).show()

                val bt_join = Intent(this, SignInActivity::class.java)
                bt_join.putExtra("PSNALDATA", tv_homeID.text.toString())
                startActivity(bt_join)
            }
        }
    }
}