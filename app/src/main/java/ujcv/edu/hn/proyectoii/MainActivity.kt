package ujcv.edu.hn.proyectoii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View

import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth

import java.util.Arrays

class MainActivity : AppCompatActivity() {
     val RC_SIGN_IN = 42

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun Registrar(view: View) {
        val providers = Arrays.asList<AuthUI.IdpConfig>(
                AuthUI.IdpConfig.EmailBuilder().build(),
                AuthUI.IdpConfig.AnonymousBuilder().build())

        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN)

    }

    fun toQuotes (view: View){
       val user = FirebaseAuth.getInstance().currentUser
        if (user != null){
            val intent = Intent(this,QuotesActivity::class.java)
            startActivity(intent)

        }

    }

    fun SingOut(view: View){
        FirebaseAuth.getInstance().signOut()
    }


}
