package com.drestaurant.common.domain.model

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
import org.apache.commons.lang.builder.ToStringBuilder
import java.math.BigDecimal

/**
 * A simple abstraction of the 'money' concept
 */
class Money(val amount: BigDecimal) {

    fun add(delta: Money): Money {
        return Money(amount.add(delta.amount))
    }

    fun isGreaterThanOrEqual(other: Money): Boolean {
        return amount.compareTo(other.amount) >= 0
    }

    fun multiply(x: Int): Money {
        return Money(amount.multiply(BigDecimal(x)))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true

        if (other == null || javaClass != other.javaClass)
            return false

        val money = other as Money

        return EqualsBuilder().append(amount, money.amount).isEquals
    }

    override fun hashCode(): Int {
        return HashCodeBuilder(17, 37).append(amount).toHashCode()
    }

    override fun toString(): String {
        return ToStringBuilder(this).append("amount", amount).toString()
    }

}
