package com.example.odev6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.odev6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSearchView()


        binding.rv.layoutManager =LinearLayoutManager(this)

        val sandayelerListesi = ArrayList<Sandalyeler>()

        val s1 = Sandalyeler("INGOLF", "sandalye","beyaz" ,"ingolf_sandalye",529)
        val s2 = Sandalyeler("ADDE", "sandalye","siyah" ,"adde",139)
        val s3 = Sandalyeler("TOBIAS", "sandalye", "şeffaf-krom kaplama", "tobias",899)
        val s4 = Sandalyeler("INGOLF", "bar taburesi", "beyaz","ingolf_bar",629)
        val s5 = Sandalyeler("TEODORES", "sandalye","beyaz" ,"teodores",299)
        val s6 = Sandalyeler("BEKVAM", "basamaklı tabure", "beyaz - 43x50 cm","bekvam",139)

        sandayelerListesi.add(s1)
        sandayelerListesi.add(s2)
        sandayelerListesi.add(s3)
        sandayelerListesi.add(s4)
        sandayelerListesi.add(s5)
        sandayelerListesi.add(s6)

        val adapter = SandalyelerAdapter(this, sandayelerListesi)
        binding.rv.adapter = adapter

    }


    private fun setupSearchView() {
        val searchView = SearchView(this)
        searchView.setIconifiedByDefault(false)
        searchView.queryHint = getString(R.string.enter_some_text)
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT
        )
        searchView.layoutParams = layoutParams
        binding.aramaLayout.addView(searchView)

        // Set query text listener...
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                /*val isMatchFound = sandalyelerListesi.contains(p0)
                val msg = if (isMatchFound) "Found: $p0" else getString(R.string.no_match)
                Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()*/
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                return false
            }
        })
    }


}