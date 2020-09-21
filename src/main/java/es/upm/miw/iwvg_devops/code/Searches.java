package es.upm.miw.iwvg_devops.code;

import org.apache.logging.log4j.LogManager;

import java.util.Comparator;
import java.util.stream.Stream;

public class Searches {
    public Stream findDecimalFractionByUserName(String name){
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
}
