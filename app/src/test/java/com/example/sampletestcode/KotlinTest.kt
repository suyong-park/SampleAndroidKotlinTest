package com.example.sampletestcode

import io.kotest.core.spec.style.*
import io.kotest.matchers.collections.sorted
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.*
import io.kotest.matchers.collections.beEmpty
import io.kotest.matchers.maps.contain
import io.kotest.matchers.maps.haveKey
import io.kotest.matchers.maps.haveValue

class StringSpecTest : StringSpec() {
    // StringSpec를 상속 받으며, 보통 init 블럭 내에서 테스트 코드를 작성한다.
    // init 블록 내부의 문자열은 테스트를 설명하는 부분이며, 블럭 내부의 코드가 실제 테스트가 진행되는 부분이다.
    init {
        "문자열.length가 문자열의 길이를 리턴해야 합니다." {
            "kotlin test".length shouldBe 11
        }
    }
}

class FunSpecTest : FunSpec({
    // FunSpec는 함수 형태로 테스트 코드를 작성할 수 있도록 돕는다.
    // 테스트 함수의 매개 변수는 단순 테스트 설명이며, 테스트 함수 내부의 코드가 실제 테스트가 진행되는 부분이다.
    test("문자열의 길이를 리턴해야 합니다.") {
        "kotlin".length shouldBe 6
        "".length shouldBe 0
    }
})

class ShouldSpecTest : ShouldSpec({
    // ShouldSpec는 FunSpec과 유사하다. 다만, test 대신 should 키워드를 사용한다는 차이점이 있다.
    // 아래 should 의 매개 변수는 단순 설명이고, 테스트는 역시 블럭 내부에서 동작한다.
    should("문자열의 길이를 리턴해야 합니다.") {
        "kotlin".length shouldBe 6
        "".length shouldBe 0
    }
})

class WordSpecTest : WordSpec({
    // String.length 부분은 context string이다. 어떠한 환경에서 테스트를 진행할 것인지를 말해 주는 것이다.
    // 아래 한글은 역시 설명 부분이며, 코드 블럭 내부에서 실제 테스트가 동작한다.
    "String.length" should {
        "문자열의 길이를 리턴해야 합니다." {
            "kotlin".length shouldBe 6
            "".length shouldBe 0
        }
    }
})

class BehaviorSpecTest : BehaviorSpec({
    // BehaviorSpec는 BDD (Behaviour Driven Development)
    given("젓가락") {
        `when`("잡는다.") {
            then("음식을 먹는다.") {
                println("젓가락을 잡고, 음식을 먹는다.")
            }
        }
        `when`("던진다.") {
            then("사람이 맞는다.") {
                println("젓가락을 던지면, 사람이 맞는다.")
            }
        }
    }
})

class AnnotationSpecTest : AnnotationSpec() {
    // AnnotationSpec는 JUnit 스타일(PersonTest 파일 참고)로 테스트 코드를 작성할 수 있다.

    @BeforeEach
    fun beforeTest() {
        println("Before Test, Setting")
    }

    @Test
    fun test1() {
        "test".length shouldBe 4
    }

    @Test
    fun test2() {
        "test2".length shouldBe 5
    }
}

class MatcherTest : StringSpec() {
    init {
        // shouldBe는 동일함을 체크하는 Matcher 이다.
        "hello World" shouldBe haveLength(11) // length가 매개변수에 전달된 값이어야 함을 체크한다.
        "hello" should include("ll") // 매개변수 값이 포함되어 있는지 확인한다.
        "hello" should endWith("lo") // 매개변수의 끝이 포함되는지 확인한다.
        "hello" should match("he...") // 매개변수가 매칭되는지 체크한다.
        "hello".shouldBeLowerCase() // 소문자로 작성된 것이 맞는지 체크한다.

        val list = emptyList<String>()
        val list2 = listOf("aaa", "bbb", "ccc")
        val map = mapOf<String, String>(Pair("aa", "11"))

        list should beEmpty() // 원소가 비었는지 확인한다.
        list2 shouldBe sorted<String>() // 해당 자료형이 정렬되어 있는지 확인한다.
        map should contain("aa", "11") // 해당 원소가 포함되어 있는지 확인한다.
        map should haveKey("aa") // 해당 키 값이 포함되어 있는지 확인한다.
        map should haveValue("11") // 해당 value 값이 포함되어 있는지 확인한다.
    }
}