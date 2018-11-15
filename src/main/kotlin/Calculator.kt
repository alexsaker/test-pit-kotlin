package com.amadeus.tne

/**
 * Calculates the total price of an order using the following rules:
 *
 *  * The price of an item is **17 Euros**;
 *  * If you buy <u>20 or more</u>, all items cost **15 Euros**;
 *  * If you have a <u>coupon</u>, all items cost **15 Euros**.
 *
 */
class PriceCalculator {

    fun getPrice(numberOfItems: Int, coupon: Boolean): Int {
        return if (numberOfItems >= DISCOUNT_THRESHOLD || coupon) {
            numberOfItems * DISCOUNT_PRICE
        } else numberOfItems * NORMAL_PRICE
    }

    companion object {

        private val NORMAL_PRICE = 17

        private val DISCOUNT_PRICE = 15

        private val DISCOUNT_THRESHOLD = 20
    }

}