package me.tatocaster.twtest.features.users.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import me.tatocaster.twtest.data.models.Address
import me.tatocaster.twtest.data.models.Company

/**
 * Created by tatocaster on 11.10.17.
 */
open class User(
        @PrimaryKey
        var id: Int,

        var name: String = "",
        var username: String = "",
        var email: String = "",
        var phone: String = "",
        var website: String = "",
        var address: Address?,
        var company: Company?) : RealmObject() {

    constructor() : this(0, "", "", "", "", "", null, null)

    fun getFullAddress() = address?.suite + ", " + address?.street + ", " + address?.city + " " + address?.zipcode

    fun getCompanyInfo() = company?.name + " - " + company?.catchPhrase
}