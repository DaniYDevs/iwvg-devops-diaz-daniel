package es.upm.miw.devops.functionaltests;

import es.upm.miw.devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    // Stub sencillo de Fraction
    static class Fraction {
        private final int numerator;
        private final int denominator;

        Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }
    }

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setName("Daniel");
        user.setFamilyName("Diaz");
    }

    @Test
    void testGettersAndSetters() {
        user.setName("Alice");
        user.setFamilyName("Smith");

        assertEquals("Alice", user.getName());
        assertEquals("Smith", user.getFamilyName());
    }

    @Test
    void testFullName() {
        // aunque el método esté comentado, este test cubriría su comportamiento
        assertEquals("Daniel Diaz", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("D.", user.initials());
    }

    /*@Test
    void testFractionsList() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(3, 4));

        user.setFractions(fractions);
        assertEquals(2, user.getFractions().size());

        user.addFraction(new Fraction(5, 6));
        assertEquals(3, user.getFractions().size());
    }

    @Test
    void testConstructorWithArgs() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(7, 8));

        User u2 = new User();

        assertEquals("1", u2.getId());
        assertEquals("Bob", u2.getName());
        assertEquals("Marley", u2.getFamilyName());
        assertEquals(1, u2.getFractions().size());
    }

    @Test
    void testToString() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(2, 3));
        user.setFractions(fractions);

        String text = user.toString();
        assertTrue(text.contains("User{"));
        assertTrue(text.contains("name='Daniel'"));
        assertTrue(text.contains("familyName='Diaz'"));
        assertTrue(text.contains("fractions"));
    }*/
}