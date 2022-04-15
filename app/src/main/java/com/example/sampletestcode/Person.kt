package com.example.sampletestcode

import java.util.*

class Person(
    private val name: String,
    private val birthYear: Int
    ) {

    fun getAge(): Int {
        val nowYear = Calendar.getInstance().get(Calendar.YEAR)
        return (nowYear - birthYear) + 1
    }

    fun getFirstName() = name[0].toString()
}