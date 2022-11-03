package com.tencent.igh

import android.app.Application
import android.content.Context
import android.util.Log
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.onesignal.OneSignal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Glo: Application() {
companion object {
    const val fvjfvheveejv = "PjiXuNmoFnBEoEuEajpJui"
    const val yhfgsnxb = "2939fbda-346e-4eb1-aeca-2b381498d19a"

    val fowerhfhc = "http://solar"
    val ovjervncds = "aurora.xyz/apps.txt"

    var lknfr: String? = ""
    var G1: String? = "c11"
    var H1: String? = "d11"
    var CH: String? = "check"

}

override fun onCreate() {
    super.onCreate()

    GlobalScope.launch(Dispatchers.IO) {
        kfherfhhf(context = applicationContext)
    }
    OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
    // OneSignal Initialization
    OneSignal.initWithContext(this)
    OneSignal.setAppId(yhfgsnxb)
}

private suspend fun kfherfhhf(context: Context) {
    val advertisingInfo = Adv(context)
    val idInfo = advertisingInfo.getAdvertisingId()

    val prefs = getSharedPreferences("SP", Application.MODE_PRIVATE)
    val editor = prefs.edit()

    editor.putString(lknfr, idInfo)
    editor.apply()
}

}

class Adv (context: Context) {
    private val adInfo = AdvertisingIdClient(context.applicationContext)

    suspend fun getAdvertisingId(): String =
        withContext(Dispatchers.IO) {
            adInfo.start()
            val adIdInfo = adInfo.info
            Log.d("getAdvertisingId = ", adIdInfo.id.toString())
            adIdInfo.id
        }
}