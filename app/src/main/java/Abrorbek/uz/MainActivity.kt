package Abrorbek.uz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val asosiy =  AsosiyFragment()
        supportFragmentManager.beginTransaction().add( R .id.my_container, asosiy).commit()
    }
}
