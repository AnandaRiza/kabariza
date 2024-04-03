package com.example.kabariza.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kabariza.R

class ReplaceFragment: AppCompatActivity(){
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.Fragment_Container, fragment)
            .commit()
    }
}