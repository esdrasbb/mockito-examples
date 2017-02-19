package org.uni7.pos.segundo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.uni7.pos.segundo.bo.AccumulatesActualsInMonth;
import org.uni7.pos.segundo.bo.CalculatesAverage;
import org.uni7.pos.segundo.bo.CountsHoursInMonth;
import org.uni7.pos.segundo.controller.UtilizationController;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UtilizationControllerTest {

    @InjectMocks
    private UtilizationController subject;

    @Mock
    private CalculatesAverage calculatesAverage;

    @Mock
    private CountsHoursInMonth countsHoursInMonth;

    @Mock
    private AccumulatesActualsInMonth accumulatesActualsInMonth;

    @Test
    public void calculatesAverageBasedOnActualsAndAvailable() {
        Integer month = 2;
        Integer year = 2017;
        Integer totalAvailableHours = 98765;
        Integer totalActualHours = 12345;

        when(countsHoursInMonth.count(month, year)).thenReturn(totalAvailableHours);
        when(accumulatesActualsInMonth.accumulate(month, year)).thenReturn(totalActualHours);
        when(calculatesAverage.calculate(totalAvailableHours, totalActualHours)).thenReturn(new BigDecimal("12.34"));

        BigDecimal result = subject.calculate(month, year);

        assertEquals(new BigDecimal("12.34"), result);
    }
}