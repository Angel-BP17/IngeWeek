package com.angelbustamante.ingeweek

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.angelbustamante.ingeweek.fragments.AgendaFragment
import com.angelbustamante.ingeweek.databinding.ActivityMainBinding
import com.angelbustamante.ingeweek.fragments.CompetenciasFragment
import com.angelbustamante.ingeweek.fragments.SeminariosFragment
import com.angelbustamante.ingeweek.fragments.UbicacionesFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()
        loadFragment(AgendaFragment())
    }

    private fun setupBottomNavigation() {
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_agenda -> loadFragment(AgendaFragment())
                R.id.nav_competencias -> loadFragment(CompetenciasFragment())
                R.id.nav_seminarios -> loadFragment(SeminariosFragment())
                R.id.nav_ubicaciones -> loadFragment(UbicacionesFragment())
                else -> return@setOnItemSelectedListener false
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}