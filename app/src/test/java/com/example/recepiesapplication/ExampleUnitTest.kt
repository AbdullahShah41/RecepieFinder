package com.example.recepiesapplication

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.recepiesapplication.utils.Common
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun testingQueryUrl() {
        val query = "SeaFood"
        println("finalURL : ${Common.PATHS.PATH_URL_SEARCH + query}")
    }

}