package com.hdeva.nytimes.service

import android.content.ComponentName
import android.content.Context
import android.net.Uri
import android.support.customtabs.CustomTabsClient
import android.support.customtabs.CustomTabsIntent
import android.support.customtabs.CustomTabsServiceConnection
import android.support.customtabs.CustomTabsSession
import android.support.v4.content.ContextCompat
import com.hdeva.nytimes.R
import javax.inject.Inject

class WebHelper @Inject constructor() : CustomTabsServiceConnection() {

    private var client: CustomTabsClient? = null
    private var session: CustomTabsSession? = null

    fun connect(context: Context) {
        CustomTabsClient.bindCustomTabsService(context, context.packageName, this)
    }

    fun disconnect(context: Context) {
        context.unbindService(this)
    }

    fun open(context: Context, url: String) {
        val builder = CustomTabsIntent.Builder(session)
        builder.setToolbarColor(ContextCompat.getColor(context, R.color.color_primary)).setShowTitle(true)
        builder.build().launchUrl(context, Uri.parse(url))
    }

    override fun onCustomTabsServiceConnected(name: ComponentName?, newClient: CustomTabsClient?) {
        client = newClient
        client?.warmup(0L)
        session = client?.newSession(null)
    }

    override fun onServiceDisconnected(name: ComponentName?) {
        client = null
    }
}
