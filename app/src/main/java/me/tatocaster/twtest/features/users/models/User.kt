package me.tatocaster.twtest.features.users.models

import me.tatocaster.twtest.data.models.Address
import me.tatocaster.twtest.data.models.Company

/**
 * Created by tatocaster on 11.10.17.
 */
data class User(
        val id: String = "",
        val name: String = "",
        val username: String = "",
        val email: String = "",
        val phone: String = "",
        val website: String = "",
        val address: Address?,
        val company: Company?) {

    fun getFullAddress() = address?.suite + ", " + address?.street + ", " + address?.city + " " + address?.zipcode

    fun getCompanyInfo() = company?.name + " - " + company?.catchPhrase
}