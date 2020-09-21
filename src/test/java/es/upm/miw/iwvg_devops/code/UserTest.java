package es.upm.miw.iwvg_devops.code;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private User user;
    private List<Fraction> fractions = new ArrayList<Fraction>();

    @BeforeEach
    void before(){
        fractions.add(new Fraction(3, 4));
        fractions.add(new Fraction(5, 3));
        fractions.add(new Fraction(7, 13));

        user = new User("1", "Adolfo", "Suarez", fractions);
    }

    @Test
    void testConstructor(){
        User voidConstructorUser = new User();
        assertEquals(true, voidConstructorUser.getFractions().isEmpty());
    }

    @Test
    void testGetAttributes(){
        assertEquals("1", user.getId());
        assertEquals("Adolfo", user.getName());
        assertEquals("Suarez", user.getFamilyName());
        assertEquals(fractions, user.getFractions());
    }

    @Test
    void testSetAttributes(){
        List<Fraction> newFractionList = new ArrayList<Fraction>();
        newFractionList.add(new Fraction(1,2));
        newFractionList.add(new Fraction(1,3));

        user.setName("Neymar");
        user.setFamilyName("Junior");
        user.setFractions(newFractionList);

        assertEquals("1", user.getId());
        assertEquals("Neymar", user.getName());
        assertEquals("Junior", user.getFamilyName());
        assertEquals(newFractionList, user.getFractions());
    }

    @Test
    void testMethods(){
        Fraction newFraction = new Fraction(3,9);
        user.addFraction(newFraction);

        assertEquals("Adolfo Suarez", user.fullName());
        assertEquals("A.", user.initials());
        assertEquals(true, user.getFractions().contains(newFraction));
    }
}
