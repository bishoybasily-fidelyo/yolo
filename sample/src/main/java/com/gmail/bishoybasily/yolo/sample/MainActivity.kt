package com.gmail.bishoybasily.yolo.sample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.gmail.bishoybasily.yolo.annotations.Autowired
import com.gmail.bishoybasily.yolo.annotations.InjectMembers
import com.gmail.bishoybasily.yolo.aspects.annotation.DebugTrace

import kotlinx.android.synthetic.main.activity_main.*

@InjectMembers
class MainActivity : AppCompatActivity() {

    @Autowired
    protected lateinit var inputMethodManager: InputMethodManager
    @Autowired
    protected lateinit var testAspects: TestAspects

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        InjectorMainActivity.inject(this)

        fab.setOnClickListener { view ->
            showSnackbar(view)
        }
    }

    @DebugTrace
    fun showSnackbar(view: View) {
        testAspects.doSomething()
        Snackbar.make(view, "Replace with your own action ${inputMethodManager == null}", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}