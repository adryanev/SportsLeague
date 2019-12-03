package com.adryanev.sportsleague

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.adryanev.sportsleague.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.jetbrains.anko.custom.ankoView

class MainActivity : AppCompatActivity() {


    private lateinit var  appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        navController = findNavController(R.id.main_nav_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)

        // Set up ActionBar
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)





    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)

        val menuItem = menu?.findItem(R.id.app_bar_search)
        if(menuItem !== null){

            menuItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
                override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                   return true
                }

                override fun onMenuItemActionCollapse(item: MenuItem): Boolean {

                    return true
                }
            })
        }
        return super.onCreateOptionsMenu(menu)
    }
}
