package com.example.android1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android1.databinding.ActivityMainBinding
import com.example.android1.databinding.FragmentTwoBinding


class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    //내부 클래스에서 뷰페이지 어댑터 적용
    //뷰 페이지 어댑터
    class MyFragmentPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
        val fragments: List<Fragment>
        init {
            fragments = listOf(OneFragment(), TwoFragment(), ThreeFragment())
        }

        override fun getItemCount(): Int{
            return fragments.size
        }
        override fun createFragment(position: Int): Fragment {
            return fragments[position]
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        //ActionBarDrawerToggle 버튼 적용
        toggle = ActionBarDrawerToggle(
            this, binding.drawer, R.string.drawer_opened,
            R.string.drawer_closed
        )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
        //뷰 페이지에 어댑터 적용
        val adapter = MyFragmentPagerAdapter(this)
        binding.viewPager.adapter = adapter



        //네비게이션 뷰 에서 아이템 선택 이벤트 추가
        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_story -> {
                    Log.d("myLog","story 메뉴 선택")
                    val intent = Intent(this, userActivity::class.java)
                    startActivity(intent)
                }
                R.id.menu_save -> {
                    val intent = Intent(this, userActivity::class.java)
                    Log.d("myLog","save 메뉴 선택")
                    startActivity(intent)
                }
                R.id.menu_option -> {
                    val intent = Intent(this, userActivity::class.java)
                    Log.d("myLog","option 메뉴 선택")
                    startActivity(intent)
                }
                R.id.menu_user -> {
                    val intent = Intent(this, userActivity::class.java)
                    Log.d("myLog","user 메뉴 선택")
                    startActivity(intent)
                }
                R.id.menu_info-> {
                    val intent = Intent(this, userActivity::class.java)
                    Log.d("myLog","info 메뉴 선택")
                    startActivity(intent)
                }
            }
            true
        }

        //페이지로 이동
        binding.navView.setOnClickListener {
            val intent = Intent(this,userActivity::class.java)
            startActivity(intent)
        }

    }

    //메뉴생성한 레이아웃을 구현
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        //MenuItem 객체를 얻고 그 안에 포함된 ActionView 객체 획득
        val menuItem = menu?.findItem(R.id.menu_search)
        val searchView = menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText : String?): Boolean {
                // 검색어 변경 이벤트
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                // 키보드의 검색 버튼을 클릭한 순간의 이벤트
                Log.d("myLog", "search text : ${query}")
                return true
            }
        })
        return true
    }

    //토글버튼 클릭시 이벤트
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 이벤트가 토글 버튼에서 발생하면면
        if(toggle.onOptionsItemSelected(item)){
            Log.d("myLog","토글버튼클릭")
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}

