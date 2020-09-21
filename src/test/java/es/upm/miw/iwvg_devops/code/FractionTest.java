package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FractionTest {
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
    void testEquivalent(){
        Fraction equivalentFraction = new Fraction(6, 8);
        Fraction notEquivalentFraction = new Fraction(2,3);

        assertEquals(true, fraction.isEquivalent(equivalentFraction));
        assertEquals(false, fraction.isEquivalent(notEquivalentFraction));
    }

    @Test
    void testAdd(){
        Fraction toAddFraction = new Fraction(2,3);
        Fraction addedFraction = fraction.add(toAddFraction);

        assertEquals(17, addedFraction.getNumerator());
        assertEquals(12, addedFraction.getDenominator());
    }

    @Test
    void testMultiply(){
        Fraction toMultiplyFraction = new Fraction(2,5);
        Fraction multipliedFraction = fraction.multiply(toMultiplyFraction);

        assertEquals(6, multipliedFraction.getNumerator());
        assertEquals(20, multipliedFraction.getDenominator());
    }

    @Test
    void testDivide(){
        Fraction toDivideFraction = new Fraction(2,5);
        Fraction dividedFraction = fraction.divide(toDivideFraction);

        assertEquals(15, dividedFraction.getNumerator());
        assertEquals(8, dividedFraction.getDenominator());
    }

    @Test
    void testMethods(){
        assertEquals(0.75, fraction.decimal(), 10e-5);
        assertEquals(true, fraction.isProper());
        assertEquals(false, fraction.isImproper());

        Fraction testProper = new Fraction();
        assertEquals(false, testProper.isProper());
        assertEquals(false, testProper.isImproper());
    }
}
