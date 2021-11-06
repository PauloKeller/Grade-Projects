package com.paulokeller.server

import org.springframework.stereotype.Service
import kotlin.math.log
import kotlin.math.pow
import kotlin.math.roundToInt

@Service("CalculatorService")
class CalculatorServiceImpl: CalculatorService {
    override fun customLog(base: Double, logNumber: Double) : CalculateLogResult {
        val result: Double

        if (base >= 0.0 && logNumber >= 0) {
            result = log(logNumber, base)
            return CalculateLogResult(round(result))
        }

        throw ArithmeticException("Negative values")
    }

    private fun round(value: Double): Double {
        val places = 2
        var value = value
        require(places >= 0)
        val factor = 10.0.pow(places.toDouble()).toLong()
        value *= factor
        val tmp = value.roundToInt()
        return tmp.toDouble() / factor
    }

}