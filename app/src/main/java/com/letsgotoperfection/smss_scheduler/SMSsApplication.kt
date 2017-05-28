package com.letsgotoperfection.smss_scheduler

import android.app.Application
import io.realm.Realm

/**
 * @author hossam.
 */
class SMSsApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}