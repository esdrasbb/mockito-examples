package org.uni7.pos.segundo.controller;

import org.uni7.pos.segundo.bo.AccumulatesActualsInMonth;
import org.uni7.pos.segundo.bo.CalculatesAverage;
import org.uni7.pos.segundo.bo.CountsHoursInMonth;

import java.math.BigDecimal;

public class UtilizationController {

    private CalculatesAverage calculatesAverage;
    private CountsHoursInMonth countsHoursInMonth;
    private AccumulatesActualsInMonth accumulatesActualsInMonth;

    public BigDecimal calculate(Integer month, Integer year) {
        return calculatesAverage.calculate(
                countsHoursInMonth.count(month, year),
                accumulatesActualsInMonth.accumulate(month, year));
    }

}
