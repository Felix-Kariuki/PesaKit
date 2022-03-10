package com.flexcode.pesakit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.flexcode.pesakit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()


        val homeFragment = HomeFragment()
        val insightsFragment = InsightsFragment()
        val myProfileFragment = MyProfileFragment()
        val logOutFragment = LogOutFragment()

        binding.bottomNavigation.selectedItemId = R.id.nav_home

        binding.bottomNavigation.setOnItemSelectedListener {

            when(it.itemId){
                R.id.nav_insights -> setCurrentFragment(insightsFragment)
                R.id.nav_home -> setCurrentFragment(homeFragment)
                R.id.nav_log_out -> setCurrentFragment(logOutFragment)
                R.id.nav_profile -> setCurrentFragment(myProfileFragment)
            }
            true
        }
        
        setCurrentFragment(homeFragment)
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container,fragment)
            commit()
        }
    }
}