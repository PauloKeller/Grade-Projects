package com.paulokeller.server

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = ["/calculator"])
class CalculatorController {
    @Autowired
    lateinit var calculatorService: CalculatorServiceImpl

    @PostMapping
    @CrossOrigin(origins = ["*"])
    fun calculateLog(@RequestBody body: CalculateLogModel): CalculateLogResult {
        return calculatorService.customLog(body.base, body.logNumber)
    }

}