package es.upm.miw.devops.functionaltests;

import es.upm.miw.devops.code.User;
import es.upm.miw.devops.code.Fraction;   // ✅ Importa la buena
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void testFullName() {
        User user = new User("1", "Daniel", "Díaz", new ArrayList<>());

        assertThat(user.fullName()).isEqualTo("Daniel Díaz");
    }

    @Test
    void testInitials() {
        User user = new User("2", "Daniel", "Díaz", new ArrayList<>());

        assertThat(user.initials()).isEqualTo("D.");
    }

    @Test
    void testFractions() {
        List<Fraction> fractions = new ArrayList<>();
        fractions.add(new Fraction(1, 2));
        fractions.add(new Fraction(3, 4));

        User user = new User("3", "Daniel", "Díaz", fractions);

        assertThat(user.getFractions())
                .hasSize(2)
                .containsExactly(new Fraction(1, 2), new Fraction(3, 4));
    }

    @Test
    void testEmptyConstructorAndSetters() {
        User user = new User();  // usa el constructor vacío
        user.setName("Ana");
        user.setFamilyName("García");
        user.setFractions(new ArrayList<>());

        assertThat(user.getName()).isEqualTo("Ana");
        assertThat(user.getFamilyName()).isEqualTo("García");
        assertThat(user.getFractions()).isEmpty();
    }

    @Test
    void testAddFraction() {
        User user = new User("10", "Pepe", "López", new ArrayList<>());
        Fraction fraction = new Fraction(5, 7);

        user.addFraction(fraction);

        assertThat(user.getFractions()).containsExactly(fraction);
    }

    @Test
    void testToStringContainsFields() {
        User user = new User("20", "Laura", "Sánchez", new ArrayList<>());

        String result = user.toString();

        assertThat(result).contains("Laura").contains("Sánchez").contains("20");
    }
}
