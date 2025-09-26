package es.upm.miw.devops.functionaltests;

import es.upm.miw.devops.code.Fraction;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FractionTest {

    @Test
    void testDefaultConstructor() {
        Fraction fraction = new Fraction();
        assertThat(fraction.getNumerator()).isEqualTo(1);
        assertThat(fraction.getDenominator()).isEqualTo(1);
    }

    @Test
    void testCustomConstructorAndGetters() {
        Fraction fraction = new Fraction(3, 4);
        assertThat(fraction.getNumerator()).isEqualTo(3);
        assertThat(fraction.getDenominator()).isEqualTo(4);
    }

    @Test
    void testSetters() {
        Fraction fraction = new Fraction();
        fraction.setNumerator(5);
        fraction.setDenominator(6);
        assertThat(fraction.getNumerator()).isEqualTo(5);
        assertThat(fraction.getDenominator()).isEqualTo(6);
    }

    @Test
    void testDecimal() {
        Fraction fraction = new Fraction(1, 2);
        assertThat(fraction.decimal()).isEqualTo(0.5);
    }

    @Test
    void testIsProper() {
        assertThat(new Fraction(1, 2).isProper()).isTrue();
        assertThat(new Fraction(3, 2).isProper()).isFalse();
    }

    @Test
    void testIsImproper() {
        assertThat(new Fraction(1, 2).isImproper()).isFalse();
        assertThat(new Fraction(3, 2).isImproper()).isTrue();
    }

    @Test
    void testIsEquivalent() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 4);

        assertThat(f1.isEquivalent(f2)).isTrue();
        assertThat(f1.isEquivalent(f3)).isFalse();
    }

    @Test
    void testAdd() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction result = f1.add(f2);

        assertThat(result).isEqualTo(new Fraction(5, 6)); // (1*3 + 1*2) / (2*3) = 5/6
    }

    @Test
    void testMultiply() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);
        Fraction result = f1.multiply(f2);

        assertThat(result).isEqualTo(new Fraction(6, 12)); // sin simplificar
    }

    @Test
    void testDivide() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);
        Fraction result = f1.divide(f2);

        assertThat(result).isEqualTo(new Fraction(8, 9));
    }

    @Test
    void testDivideByZeroFraction() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(0, 1);

        assertThatThrownBy(() -> f1.divide(f2))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("division by zero");
    }

    @Test
    void testToString() {
        Fraction fraction = new Fraction(3, 5);
        assertThat(fraction.toString()).contains("numerator=3").contains("denominator=5");
    }

    @Test
    void testEqualsAndHashCode() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 2);
        Fraction f3 = new Fraction(2, 3);

        assertThat(f1)
                .isEqualTo(f2)
                .hasSameHashCodeAs(f2)
                .isNotEqualTo(f3);
    }
}
