package com.amadeus.tne

import org.junit.Assert.assertEquals

import org.junit.Before
import org.junit.Test

/**
 * Unit tests for [PriceCalculator].
 */
class PriceCalculatorTest {

    private var priceCalculator: PriceCalculator? = null

    @Before
    fun prepare() {
        priceCalculator = PriceCalculator()
    }

    /**
     * Test that for only 1 item then the total price is 17 Euros.
     */
    @Test
    fun testNormalPricing() {
        val result = priceCalculator!!.getPrice(1, false)
        assertEquals(17, result.toLong())
    }

    /**
     * Test that for 100 items then the total price is calculated with the discount, so 100 * 15 = 1500 Euros.
     */
    @Test
    fun testDiscountPricingByAmount() {
        val result = priceCalculator!!.getPrice(100, false)
        assertEquals(1500, result.toLong())
    }

    /**
     * Test that for only 1 item, but with a coupon, then the total price is 15 Euros.
     */
    @Test
    fun testDiscountPricingWithCoupon() {
        val result = priceCalculator!!.getPrice(1, true)
        assertEquals(15, result.toLong())
    }

    /**
     * Test that for exactly 20 items then the total price is calculated with the discount, so 20 * 15 = 300 Euros.
     */
    @Test
    fun testDiscountPricingCornerCase() {
        val result = priceCalculator!!.getPrice(20, true)
        assertEquals(300, result.toLong())
    }

}