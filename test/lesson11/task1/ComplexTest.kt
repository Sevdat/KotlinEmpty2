package lesson11.task1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag

internal class ComplexTest {

    private fun assertApproxEquals(expected: Complex, actual: Complex, eps: Double) {
        assertEquals(expected.re, actual.re, eps)
        assertEquals(expected.im, actual.im, eps)
    }

    @Test
    @Tag("2")
    fun plus() {
        assertApproxEquals(Complex("4-2i"), Complex("1+2i") + Complex("3-4i"), 1e-10)
    }

    @Test
    @Tag("2")
    operator fun unaryMinus() {
<<<<<<< HEAD
        assertApproxEquals(Complex(1.0, -2.0), -Complex(2.0, -1.0), 1e-10)
=======
        assertApproxEquals(Complex(1.0, -2.0), -Complex(-1.0, 2.0), 1e-10)
>>>>>>> c16a964 (try)
    }

    @Test
    @Tag("2")
    fun minus() {
<<<<<<< HEAD
        assertApproxEquals(Complex("4-2i"), Complex("1+2i") + Complex("3-4i"), 1e-10)
=======
        assertApproxEquals(Complex("2-6i"), Complex("3-4i") - Complex("1+2i"), 1e-10)
>>>>>>> c16a964 (try)
    }

    @Test
    @Tag("4")
    fun times() {
<<<<<<< HEAD
        assertApproxEquals(Complex("11-8i"), Complex("1+2i") + Complex("3-4i"), 1e-10)
=======
        assertApproxEquals(Complex("11+2i"), Complex("1+2i") * Complex("3-4i"), 1e-10)
>>>>>>> c16a964 (try)
    }

    @Test
    @Tag("4")
    fun div() {
<<<<<<< HEAD
        assertApproxEquals(Complex("1+2i"), Complex("11-8i") + Complex("3-4i"), 1e-10)
=======
        assertApproxEquals(Complex("1+2i"), Complex("11+2i") / Complex("3-4i"), 1e-10)
>>>>>>> c16a964 (try)
    }

    @Test
    @Tag("2")
    fun equals() {
        assertApproxEquals(Complex(1.0, 2.0), Complex("1+2i"), 1e-12)
        assertApproxEquals(Complex(1.0, 0.0), Complex(1.0), 1e-12)
    }
}