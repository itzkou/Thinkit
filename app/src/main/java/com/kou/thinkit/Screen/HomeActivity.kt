package com.kou.thinkit.Screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.format.DateUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kou.thinkit.Adapter.RvHomeAdapter
import com.kou.thinkit.Model.Room
import com.kou.thinkit.R
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*

class HomeActivity : AppCompatActivity() {
    private lateinit var name: String
    private lateinit var mAdapter: RvHomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val R1 = Room("Living Room", 4, R.drawable.livingroom)
        val R2 = Room("Media Room", 6, R.drawable.mediaroom)
        val R3 = Room("Bathroom", 1, R.drawable.bathroom)
        val R4 = Room("Bedroom", 3, R.drawable.bedroom)

        /** Name and Local Date **/
        name = intent.getStringExtra(NAME) ?: return finish()
        tvName.text = "$name!"
        val currentDate = DateUtils.formatDateTime(
            this,
            System.currentTimeMillis(),
            0
        ) + " , " + Calendar.getInstance().get(Calendar.YEAR)

        tvTime.text = currentDate

        /** Feeding the recyclerView **/
        mAdapter = RvHomeAdapter()
        mAdapter.updateRooms(listOf(R1, R2, R3, R4))
        rvHome.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvHome.adapter = mAdapter


    }

    companion object {
        private const val NAME = "NAME"


        fun start(context: Context, name: String) {
            val intent = Intent(context, HomeActivity::class.java)
            intent.putExtra(NAME, name)

            context.startActivity(intent)
        }
    }
}