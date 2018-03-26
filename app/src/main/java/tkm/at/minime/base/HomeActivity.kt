package tkm.at.minime.base

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import tkm.at.minime.CalendarFragment
import tkm.at.minime.R

/**
 * [Add class description here]
 *
 * Created 26.03.18
 *
 * @author Thomas Krainz-Mischitz (Level1 GmbH)
 * @version %I%, %G%
 */
class HomeActivity : MMActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var mActionBar: ActionBar
    var mToolBarNavigationListenerIsRegistered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nav_drawer)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        mActionBar = supportActionBar!!

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        toggle = ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        replaceFragment(CalendarFragment())

        navigationView.menu.getItem(0).isChecked = true
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        }

        fragmentManager.popBackStack("Training", 0)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        /**
        if (id == R.id.nav_home) {
        replaceFragment(OverviewFragment())
        LogEventsHelper(this).logMenuClick("home")
        } else if (id == R.id.nav_exercises) {
        replaceFragment(TrainingsOverViewFragment())
        LogEventsHelper(this).logMenuClick("exercises")
        } else if (id == R.id.nav_statistics) {
        replaceFragment(StatisticsActivity())
        LogEventsHelper(this).logMenuClick("statistics")
        } else if (id == R.id.nav_rate) {
        this.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=sdt.tkm.at.steeldarttrainer")))
        LogEventsHelper(this).logMenuClick("tate")
        } else if (id == R.id.nav_tos) {
        replaceFragment(PrivacyPolicyFragment())
        LogEventsHelper(this).logMenuClick("privacy_policy")
        }
         */
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.content_frame, fragment)

        transaction.commit()
        showUpButton(false)
    }

    open fun showUpButton(show: Boolean) {
        if (show) {
            toggle.isDrawerIndicatorEnabled = false
            mActionBar.setDisplayHomeAsUpEnabled(true)
            if (!mToolBarNavigationListenerIsRegistered) {
                toggle.toolbarNavigationClickListener = View.OnClickListener { onBackPressed() }

                mToolBarNavigationListenerIsRegistered = true
            }

        } else {
            mActionBar.setDisplayHomeAsUpEnabled(false)
            toggle.isDrawerIndicatorEnabled = true
            toggle.toolbarNavigationClickListener = null
            mToolBarNavigationListenerIsRegistered = false
        }
    }
}