package me.tatocaster.twtest.data.models

import io.realm.RealmObject


open class Company(
        var name: String = "",
        var catchPhrase: String = ""
) : RealmObject()