package com.nextin.recyclerviewdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nextin.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding :ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var userArray :ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val newsImageArray = arrayOf(
            R.drawable.jaishankar1,
            R.drawable.modi,
            R.drawable.jaishankar,
            R.drawable.news_img1,
            R.drawable.news_img2,
            R.drawable.news_img3,
            R.drawable.news_img4,
            R.drawable.news_img5,
            R.drawable.news_img6
        )
        val newsHeading = arrayOf(
            "EAM Jaishankar & Sri Lanka President Wickremesinghe formally commission Maritime Rescue Coordination Centre",
            "Eid-ul-Adha 2024: PM Modi extends greetings to Maldives President Mizzu, emphasises values of",
            "Jaishankar meets US National Security Advisor Sullivan in Delhi, discusses bilateral, global issues",
            "OpenAI competitor Anthropic launches new AI model called Claude 3.5 Sonnet, says it is their best yet",
            "NEET row: Accused Amit Anand with Bihar Deputy Chief Minister, RJD shares pic",
            "Singapore-based Indian man explains why he has decided to move to Bengaluru. Viral",
            "Delhi High Court puts Arvind Kejriwal's bail order on hold until it hears ED’s challenge",
            "Delhi Minister Atishi at Rajghat, to start hunger strike over water crisis soon",
            "Jackie Shroff asks paps to breathe on International Yoga Day: Heart ke lafde ho…"
        )

        val newsDetails = arrayOf(
            getString(R.string.jaishakarOne),
            getString(R.string.jaishakarOne),
            getString(R.string.jaishakarOne),
            getString(R.string.jaishakarOne),
            getString(R.string.jaishakarOne),
            getString(R.string.jaishakarOne),
            getString(R.string.jaishakarOne),
            getString(R.string.jaishakarOne),
            getString(R.string.jaishakarOne),

        )

        userArray = ArrayList()
        binding.reView.layoutManager = LinearLayoutManager(this)

        for(index in newsImageArray.indices)
        {
            val news = News(newsHeading[index],newsImageArray[index],newsDetails[index])
            userArray.add(news)
        }

        val myAdapter = MyAdapter(this,userArray)
        binding.reView.adapter = myAdapter

        myAdapter.setOnItemClickListener(object :MyAdapter.OnItemClickListener{
            override fun onItemSelecting(position: Int) {

                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                intent.putExtra("newsTitle",userArray[position].newsHedind)
                intent.putExtra("content",userArray[position].newsContent)
                intent.putExtra("newsImage",userArray[position].newsImage)
                startActivity(intent)
            }
        })
    }
}