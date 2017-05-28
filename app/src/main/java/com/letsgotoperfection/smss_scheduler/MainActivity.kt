package com.letsgotoperfection.smss_scheduler

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.letsgotoperfection.smss_scheduler.adapters.AdapterContacts
import com.letsgotoperfection.smss_scheduler.models.Contact
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    val realm = Realm.getDefaultInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

//        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

//        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

//        val navigationView = findViewById(R.id.nav_view) as NavigationView
        nav_view.setNavigationItemSelectedListener(this)
        init()
    }

    override fun onBackPressed() {
//        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun init() {
        createTestData()
//        realm.where(Contact::class.java).findAll()
        rvContacts.layoutManager = (LinearLayoutManager(this))
        rvContacts.adapter = AdapterContacts(realm.where(Contact::class.java).findAll())
    }

    // Create test data
    private fun createTestData() {
        val x = Contact("Hossam", "20101582523", "test@test.test", System.currentTimeMillis())
        val y = Contact("Ahmed", "9998734557847", "test@test.test", System.currentTimeMillis())
        val z = Contact("Yasser", "97349745305", "test@test.test", System.currentTimeMillis())
        val a = Contact("Wael", "8723857857", "test@test.test", System.currentTimeMillis())
        val b = Contact("Mohamed", "9839793554", "test@test.test", System.currentTimeMillis())
        val contacts = mutableListOf<Contact>()
        contacts.add(x)
        contacts.add(y)
        contacts.add(z)
        contacts.add(a)
        contacts.add(b)


//        val r = Random(42)
        realm.executeTransaction { realm ->
            for (contact in contacts) {
                val c = realm.createObject(Contact::class.java)
                c.name = contact.name
                c.phone = contact.phone
                c.email = contact.email
                c.nextMessageDateTimestamp = contact.nextMessageDateTimestamp
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

//        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
