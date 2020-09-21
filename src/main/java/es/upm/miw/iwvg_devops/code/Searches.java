package es.upm.miw.iwvg_devops.code;

import java.util.Comparator;
import java.util.stream.Stream;

public class Searches {
    public Stream<Double> findDecimalFractionByUserName(String name){
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream()
                        .map(Fraction::decimal));
    }

    public Fraction findHighestFraction(){
        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream())
                .max(Comparator.comparingDouble(Fraction::decimal))
                .orElseThrow();
    }

    public Fraction findFractionAdditionByUserId(String id){
        return new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .reduce((accumulatorFraction, nextFraction) -> accumulatorFraction.add(nextFraction))
                .orElseThrow();
    }

    public Fraction findFirstFractionSubtractionByUserName(String name){
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream())
                .limit(2)
                .reduce((accumulatorFraction, nextFraction) -> accumulatorFraction.subtract(nextFraction))
                .orElseThrow();
    }
}
