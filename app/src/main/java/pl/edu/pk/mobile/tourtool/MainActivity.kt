package pl.edu.pk.mobile.tourtool

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val navController: NavController = findNavController(R.id.nav_host_fragment)

    findViewById<NavigationView>(R.id.nav_view)
      .setupWithNavController(navController)
  }
}
