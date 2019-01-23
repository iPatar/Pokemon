package nl.hva.pokemon.features.presentation.moves

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MovePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    //gets page for each fragment
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            else -> SecondFragment()
        }
    }

    //defines number of pages in pageradapter
    override fun getCount(): Int {
        return 2
    }

    //gets title of each page
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "By level up"
            else -> "By machine"
        }
    }

}