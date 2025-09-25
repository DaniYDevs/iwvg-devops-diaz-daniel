package es.upm.miw.devops.functionaltests;

import es.upm.miw.devops.code.Fraction;
import es.upm.miw.devops.code.Searches;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchesTest {
    @Test
    void testFindDecimalImproperFractionByUserName() {
        Searches searches = new Searches();

        List<Double> decimals = searches.findDecimalImproperFractionByUserName("Oscar")
                .collect(Collectors.toList());
        //An improper fraction means that the numerator is bigger or equal than the denominator
        // Fractions of Oscar #1 → [0/1, 1/1, 2/1] → Improper: 1.0, 2.0
        // Fractions of Oscar #3 → [1/5, 3/-6, 1/2, 4/4] → Improper: 4/4=1.0
        assertThat(decimals)
                .containsExactly(1.0, 2.0, 1.0);
    }

    @Test
    void testFindUserNameBySomeImproperFraction() {
        Searches searches = new Searches();

        List<String> result = searches.findUserNameBySomeImproperFraction().toList();

        assertThat(result).containsExactlyInAnyOrder("Oscar", "Ana", "Paula");
    }

    @Test
    void findFirstProperFractionByUserId(){
        Searches searches = new Searches();

        Fraction result = searches.findFirstProperFractionByUserId("2");

        assertThat(result.getNumerator()).isEqualTo(-1);
        assertThat(result.getDenominator()).isEqualTo(5);

    }

    @Test
    void testFindFractionDivisionByUserId() {
        Searches searches = new Searches();

        List<String> result = searches.findFractionDivisionByUserId("2").toList();

        assertThat(result).containsExactly(
                "Fraction{numerator=10, denominator=-1}",
                "Fraction{numerator=8, denominator=2}",
                "Fraction{numerator=6, denominator=4}",
                "Fraction{numerator=-1, denominator=10}",
                "Fraction{numerator=-4, denominator=10}",
                "Fraction{numerator=-3, denominator=20}",
                "Fraction{numerator=2, denominator=8}",
                "Fraction{numerator=10, denominator=-4}",
                "Fraction{numerator=6, denominator=16}",
                "Fraction{numerator=4, denominator=6}",
                "Fraction{numerator=20, denominator=-3}",
                "Fraction{numerator=16, denominator=6}"
        );
    }
}
