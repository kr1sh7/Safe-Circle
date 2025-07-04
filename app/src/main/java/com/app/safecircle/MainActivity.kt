package com.app.safecircle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

private fun MainActivity.openScreen() {
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottomBar)

        bottomBar.setOnItemSelectedListener { menuItem ->

            if (menuItem.itemId == R.id.nav_security) {
                inflateSecurityFragment()
            } else if (menuItem.itemId == R.id.nav_home) {
                inflateHomeFragment()
            } else if (menuItem.itemId == R.id.nav_dashboard) {
                inflateDashboardFragment()
            } else if (menuItem.itemId == R.id.nav_profile) {
                inflateProfileFragment()
            }

            true
        }

        bottomBar.selectedItemId = R.id.nav_home
    }

    private fun MainActivity.inflateDashboardFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, DashboardFragment.newInstance())
        transaction.commit()
    }

    private fun MainActivity.inflateSecurityFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, SecurityFragment.newInstance())
        transaction.commit()
    }

    private fun MainActivity.inflateHomeFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, HomeFragment.newInstance())
        transaction.commit()
    }

    private fun MainActivity.inflateProfileFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, ProfileFragment.newInstance())
        transaction.commit()
    }
}
