package com.letsgotoperfection.smss_scheduler.models

import io.realm.RealmObject

/**
 * @author hossam.
 */
public open class Message(var text: String) : RealmObject() {
//    enum class TYPE {
//        LONG, SHORT
//    }
//    , var type: TYPE? = Message.TYPE.SHORT
    constructor() : this("")

}