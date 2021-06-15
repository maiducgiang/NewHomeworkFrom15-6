package com.example.navigationagain

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.navigationagain.databinding.ActivityMainBinding
import com.example.navigationagain.fragments.DashboardFragment
import com.example.navigationagain.fragments.InfoFragment
import com.example.navigationagain.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {

    private val dashboardFragment = DashboardFragment()

    private val inforFargment = InfoFragment()

    private val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        replaceFragment(dashboardFragment)
        val buttonDashboard: Button = findViewById(R.id.button_main_dashboard)
        buttonDashboard.setOnClickListener {
            replaceFragment(dashboardFragment)
        }
        val buttonInfo: Button = findViewById(R.id.button_main_info)
        buttonInfo.setOnClickListener {
            replaceFragment(inforFargment)
        }
        val buttonSetting: Button = findViewById(R.id.button_main_setting)
        buttonSetting.setOnClickListener {
            replaceFragment(settingsFragment)
        }
    }
    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}