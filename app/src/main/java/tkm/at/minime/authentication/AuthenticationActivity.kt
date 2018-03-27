package tkm.at.minime.authentication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import tkm.at.minime.R
import tkm.at.minime.authentication.login.LoginFragment
import tkm.at.minime.authentication.registration.CreateUserActivity
import tkm.at.minime.authentication.registration.RegistrationFragment
import tkm.at.minime.base.MMActivity

class AuthenticationActivity : MMActivity() {

    private lateinit var mActionBar: ActionBar
    var mToolBarNavigationListenerIsRegistered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authentication_activity)

        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        mActionBar = supportActionBar!!

        replaceLoginFragment()
    }

    override fun onBackPressed() {
        var count = fragmentManager.backStackEntryCount

        if (count > 1) {
            fragmentManager.popBackStack()
            mActionBar.title = "Login"
            mActionBar.setDisplayHomeAsUpEnabled(false)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            //Title bar back press triggers onBackPressed()
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun replaceLoginFragment() {
        val transaction = fragmentManager.beginTransaction()
        val fragment = LoginFragment()
        fragment.registrationClicked.subscribe { _ ->
            replaceRegistrationFragment()
        }
        transaction.replace(R.id.authentication_content_frame, fragment)
        transaction.addToBackStack("LoginFragment")
        transaction.commit()
        mActionBar.setDisplayHomeAsUpEnabled(false)
        mActionBar.title = "Login"
    }

    private fun replaceRegistrationFragment() {
        val transaction = fragmentManager.beginTransaction()
        val fragment = RegistrationFragment()
        fragment.registrationSuccessful.subscribe {
            val intent = Intent(this, CreateUserActivity::class.java)
            startActivity(intent)
        }
        transaction.replace(R.id.authentication_content_frame, fragment)
        transaction.addToBackStack("RegistrationFragment")
        transaction.commit()

        mActionBar.title = "Registrierung"
        mActionBar.setDisplayHomeAsUpEnabled(true)
    }
}