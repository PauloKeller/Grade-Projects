package com.paulokeller.server

interface CalculatorService {
    fun customLog(base: Double, logNumber: Double): CalculateLogResult
}