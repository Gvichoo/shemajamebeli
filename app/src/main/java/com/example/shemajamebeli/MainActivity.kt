package com.example.shemajamebeli

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.shemajamebeli.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val listOfWords = mutableListOf<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.saveButton.setOnClickListener {
            val enteredAnagram = binding.enterAnagram.text.toString()
            if (enteredAnagram.isEmpty()){
                Toast.makeText(this,"Enter a word!",Toast.LENGTH_LONG ).show()
            }else{
                listOfWords.add(enteredAnagram)
                binding.enterAnagram.text.clear()
            }

        }

        binding.clearButton.setOnClickListener {
            binding.enterAnagram.text.clear()
            binding.anagramsTextView.text = "Anagrams"
            listOfWords.clear()
            Toast.makeText(this,"Cleared!",Toast.LENGTH_LONG).show()
        }
        binding.outputButton.setOnClickListener {
            val groupedAnagrams = listOfWords.groupBy { it.toCharArray().sorted().joinToString("") }
            val result = groupedAnagrams.values.joinToString("\n") { it.toString() }
            binding.anagramsTextView.text = result
            binding.numOfAnagrams.text ="number of anagrams: ${groupedAnagrams.size}"
        }
        binding.connectButton.setOnClickListener {
            Toast.makeText(this,"Text:Hello i am hacker from tbc it academy - has been sent to the other devices.",Toast.LENGTH_LONG).show()
        }
    }
}