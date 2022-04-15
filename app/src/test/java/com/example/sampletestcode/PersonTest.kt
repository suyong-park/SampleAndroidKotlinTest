package com.example.sampletestcode

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PersonTest {

    private lateinit var person: Person

    @Test
    fun getAge_equals_returnsCorrectResult() {
        person = Person("박수용", 1997)
        val age = person.getAge()

        assertEquals(26, age)
    }

    @Test
    fun getFirstName_equals_returnsCorrectResult() {
        person = Person("박수용", 1997)
        val firstName = person.getFirstName()

        assertEquals("박", firstName)
    }

    @Test
    fun getAge_trueOrFalse_returnsCorrectResult() {
        person = Person("박수용", 2002)

        assertTrue(21 == person.getAge())
    }

    @Test
    fun getFirstName_trueOrFalse_returnsCorrectResult() {
        person = Person("홍길동", 2002)

        assertTrue("홍" == person.getFirstName())
    }
}