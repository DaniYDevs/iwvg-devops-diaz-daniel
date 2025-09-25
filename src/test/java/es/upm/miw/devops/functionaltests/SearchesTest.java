package es.upm.miw.devops.functionaltests;

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
}
