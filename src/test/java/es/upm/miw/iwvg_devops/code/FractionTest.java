package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FractionTest {
    private Fraction fraction;

    @BeforeEach
    void before(){
        fraction = new Fraction(3,4);
    }

    @Test
    void testVoidConstructor(){
        Fraction voidConsFraction = new Fraction();

        assertEquals(1, voidConsFraction.getNumerator());
        assertEquals(1, voidConsFraction.getDenominator());
    }

    @Test
    void testGetAttributes(){
        assertEquals(3, fraction.getNumerator());
        assertEquals(4, fraction.getDenominator());
    }

    @Test
    void testSetAttributes(){
        fraction.setNumerator(5);
        fraction.setDenominator(7);

        assertEquals(5, fraction.getNumerator());
        assertEquals(7, fraction.getDenominator());
    }

    @Test
    void testMethods(){
        assertEquals(0.75, fraction.decimal(), 10e-5);
    }
}
