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

    @Test
    void testFindFractionAdditionByUserId(){
        Fraction addedFractionFirst = new Searches().findFractionAdditionByUserId("4");
        Fraction addedFractionSecond = new Searches().findFractionAdditionByUserId("6");

        assertEquals(16, addedFractionFirst.getNumerator());
        assertEquals(8, addedFractionFirst.getDenominator());
        assertEquals(1, addedFractionSecond.getNumerator());
        assertEquals(1, addedFractionSecond.getNumerator());
    }

    @Test
    void testFindFirstFractionSubtractionByUserName(){
        Fraction subtractedFractionFirst = new Searches().findFirstFractionSubtractionByUserName("Ana");
        Fraction subtractedFractionSecond = new Searches().findFirstFractionSubtractionByUserName("Oscar");

        assertEquals(11, subtractedFractionFirst.getNumerator());
        assertEquals(5, subtractedFractionFirst.getDenominator());
        assertEquals(-1, subtractedFractionSecond.getNumerator());
        assertEquals(1, subtractedFractionSecond.getDenominator());
    }
}
