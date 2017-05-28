package com.letsgotoperfection.smss_scheduler.models

import io.realm.RealmObject


/**
 * @author hossam.
 */
public open class Contact(var name: String?,
                   var phone: String?,
                   var email: String?,
                   var nextMessageDateTimestamp: Long?) : RealmObject() {

    constructor() : this("","","", System.currentTimeMillis())
}