package nl.hva.buurman.features.presentation.moves

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_move.*
import nl.hva.buurman.R

class MoveActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, MoveActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)
        supportActionBar?.title = getString(R.string.moves_title)

        initTabLayout()
    }

    private fun initTabLayout() {
        val fragmentAdapter = MovePagerAdapter(supportFragmentManager)
        viewPagerDetail.adapter = fragmentAdapter
        tabsDetail.setupWithViewPager(viewPagerDetail)
    }

}