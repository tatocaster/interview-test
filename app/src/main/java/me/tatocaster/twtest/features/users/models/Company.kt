package me.tatocaster.twtest.features.users.models

import io.realm.RealmObject


open class Company(
        var name: String = "",
        var catchPhrase: String = ""
) : RealmObject()