package com.hdeva.nytimes.ui.home

import android.os.Bundle
import com.hdeva.nytimes.R
import com.hdeva.nytimes.arch.base.BaseActivity
import com.hdeva.nytimes.databinding.ActivityHomeBinding
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    lateinit var binding: ActivityHomeBinding
    lateinit var viewModel: HomeActivityViewModel

    @Inject
    lateinit var presenter: HomeActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.NyTimes_Theme)
        super.onCreate(savedInstanceState)
        presenter.create()
    }
}
