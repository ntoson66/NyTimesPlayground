package com.hdeva.nytimes.ui.home

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.hdeva.nytimes.R
import com.hdeva.nytimes.arch.base.BaseActivity
import com.hdeva.nytimes.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.NyTimes_Theme)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
    }
}
