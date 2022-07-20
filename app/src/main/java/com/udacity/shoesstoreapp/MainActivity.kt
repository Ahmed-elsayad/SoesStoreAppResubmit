package com.udacity.shoesstoreapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoesstoreapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.storeNavHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration =
            AppBarConfiguration.Builder(R.id.shoeListFragment, R.id.loginFragment).build()


        // Link the NavController to the ActionBar with NavigationUI.setupWithNavController
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    //The NavGraph whose start destination should be considered the only top level destination.
    // The Up button will not be displayed when on the start destination of the graph
    override fun onSupportNavigateUp(): Boolean {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.storeNavHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration =
            AppBarConfiguration.Builder(R.id.shoeListFragment, R.id.loginFragment).build()
        return NavigationUI.navigateUp(
            navController,
            appBarConfiguration
        ) || super.onSupportNavigateUp()
    }


}