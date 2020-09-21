package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {
    @Test
    void testFindDecimalFractionByUserName(){
        assertEquals(List.of(0.0, 1.0, 2.0, 0.2, -0.5, 0.5, 1.0),
                new Searches().findDecimalFractionByUserName("Oscar")
                        .collect(Collectors.toList()));
    }

    @Test
    void testFindHighestFraction(){
        Fraction highestFraction = new Searches().findHighestFraction();

        assertEquals(2, highestFraction.getNumerator());
        assertEquals(1, highestFraction.getDenominator());
    }
}
