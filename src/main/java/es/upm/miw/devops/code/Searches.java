package es.upm.miw.devops.code;

import java.util.Objects;
import java.util.stream.Stream;

public class Searches {

    /*public Stream<String> findFractionDivisionByUserId() {
        return Stream.empty();
    }*/

    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        UsersDatabase usersDatabase = new UsersDatabase();

        return usersDatabase.findAll()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream())
                .filter(Fraction::isImproper)
                .filter(f -> f.getDenominator() != 0) // avoid NaN/Infinity
                .map(Fraction::decimal);
    }

    public Fraction findFirstProperFractionByUserId(String id) {
        UsersDatabase usersDatabase = new UsersDatabase();

        return usersDatabase.findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .filter(Fraction::isProper)
                .findFirst()
                .orElse(null); // chatGPT Line
    }


    public Stream<String> findUserNameBySomeImproperFraction() {
        UsersDatabase usersDatabase = new UsersDatabase();

        return usersDatabase.findAll()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isImproper))
                .map(User::getName)
                .distinct();
    }
}