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

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var btn_toast = findViewById<Button>(R.id.btn_toast)
        var idtext = findViewById<EditText>(R.id.idtext)
        var password = findViewById<EditText>(R.id.password)

        btn_toast.setOnClickListener {

            if (idtext.text.isEmpty() || password.text.isEmpty()) {//아이디 혹은 비밀번호가 입력 안됐을때
                Toast.makeText(this, "아이디/비밀번호 입력해주세요", Toast.LENGTH_SHORT).show()
            } else {//둘다 입력됐을 때 = 로그인 할 수 있는 조건일 때 '로그인성공'
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val it_login = Intent(this, HomeActivity::class.java)
                it_login.putExtra("IDDETA", idtext.text.toString())
                startActivity(it_login)
            }
        }
        var join2 = findViewById<Button>(R.id.join2)

        join2.setOnClickListener{
            val signUp = Intent(this,SignUpActivity::class.java)
            startActivity(signUp)
        }


    }
}


