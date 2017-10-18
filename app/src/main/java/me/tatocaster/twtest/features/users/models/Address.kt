package me.tatocaster.twtest.features.users.models

import io.realm.RealmObject

/**
 * Created by tatocaster on 14.10.17.
 */
open class Address(
        var street: String = "",
        var suite: String = "",
        var city: String = "",
        var zipcode: String = "") : RealmObject()