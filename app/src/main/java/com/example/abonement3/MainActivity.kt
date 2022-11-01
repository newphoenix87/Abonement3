package com.example.abonement3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.asLiveData
import com.example.abonement3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = MainDb.getDB(this)
        db.getDao().getallitems().asLiveData().observe(this){
            it.forEach{
                val text = "Id: ${it.id} Name: ${it.name} Price: ${it.price}\n"
                binding.tvText.append(text)
            }
        }
        binding.button.setOnClickListener {
            val item = Item(null,
                binding.edName.text.toString(),
                binding.edPrice.text.toString()
            )
            Thread{
                db.getDao().insertItem(item)
            }.start()
        }
    }
}