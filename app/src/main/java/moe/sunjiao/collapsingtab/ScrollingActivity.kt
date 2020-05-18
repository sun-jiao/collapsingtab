package moe.sunjiao.collapsingtab

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_scrolling.*
import moe.sunjiao.collapsingtab.fragments.FirstFragment
import moe.sunjiao.collapsingtab.fragments.SecondFragment


class ScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)
        initView()
        view_pager.currentItem = 0
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id: Int = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }

    private fun initView() {
        val fragmentList : ArrayList<Fragment> = ArrayList()
        fragmentList.add(FirstFragment.newInstance())
        fragmentList.add(SecondFragment.newInstance())
        val myFragmentStatePagerAdapter = MyFragmentStatePagerAdapter(supportFragmentManager, fragmentList, this)
        view_pager.adapter = myFragmentStatePagerAdapter
        tabs.setupWithViewPager(view_pager)
        tabs.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener {

            override fun onTabReselected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 ->{
                        view_pager.currentItem = 0
                        return
                    }
                    1 ->{
                        view_pager.currentItem = 1
                        return
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
            }
        })

        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(
                tabs));
    }
}
