package org.jointwork.filehub.core

import org.junit.Assert
import org.junit.Test

class SampleTest {
    private val sample = Sample()

    @Test
    fun testAdd(){
        Assert.assertEquals("ab", sample.add("a","b"))
    }
}