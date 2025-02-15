package com.hsefakcay.androidalertdialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hsefakcay.androidalertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Context
        //aktivite context , app context

        // toast message dialog   (kendiliğinde gözükür ve kaybolur)
        Toast.makeText(this@MainActivity, "Welcome", Toast.LENGTH_LONG).show()

        /*
        binding.button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                println("Butona tıklandı")
            }
        })
         */




    }
    fun save(view: View){
        val alert = AlertDialog.Builder(this@MainActivity)
        alert.setTitle("Kayıt Et")
        alert.setMessage("Kayıt Etmek İstediğinize Emin misiniz ?")

        alert.setPositiveButton("Evet") { dialog, which ->
            Toast.makeText(this@MainActivity, "Kayıt Edildi", Toast.LENGTH_LONG).show()
        }

        alert.setNegativeButton("Hayır", object : DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                Toast.makeText(this@MainActivity,"Kayıt İptal Edildi", Toast.LENGTH_LONG).show()
            }
        } )

        alert.show()


    }
}