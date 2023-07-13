package be.technifuture.exo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import be.technifuture.exo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(this,navController)

        // Config du bouton add dans la toolbar
        binding.buttonAddItem.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToAddItemFragment()
            navController.navigate(direction)
        }

        // Change name of toolbar
        navController.addOnDestinationChangedListener{ _, destination, _ ->
            when(destination.id){
                R.id.addItemFragment -> {
                    binding.buttonAddItem.visibility = View.INVISIBLE
                }
                else -> binding.buttonAddItem.visibility = View.VISIBLE
            }

        }
    }
}