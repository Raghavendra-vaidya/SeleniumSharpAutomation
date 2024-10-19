package org.rvaidya.utilities;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.function.Supplier;

public class RandomDataGenerator {

    public synchronized static String getMaleName() {
        Supplier<String> supplier = () -> {

            String randomString = RandomStringUtils.random(6, true, true);
            Faker faker = new Faker();
            return faker.name().malefirstName() + "_" + randomString;
        };
        return supplier.get();
    }

    public synchronized static String getFemaleName() {
        Supplier<String> supplier = () -> {

            String randomString = RandomStringUtils.random(6, true, true);
            Faker faker = new Faker();
            return faker.name().femaleFirstName() + "_" + randomString;
        };
        return supplier.get();
    }

    public synchronized static String getAnimalName() {
        Supplier<String> supplier = () -> {

            String randomString = RandomStringUtils.random(6, true, true);
            Faker faker = new Faker();
            return faker.animal().name() + "_" + randomString;
        };
        return supplier.get();
    }

}
