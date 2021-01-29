package utils;

import com.github.javafaker.Faker;

public class Helpers {

    Faker faker = new Faker();

    public static String getNewTitle() {

        return new Faker().letterify("apiRest" + "??????");
    }

    public static Integer getIntegerNumber(Integer digits) {
        Faker faker = new Faker();
        return (faker.number().numberBetween(1,1000));
    }
}
