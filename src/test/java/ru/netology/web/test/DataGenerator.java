package ru.netology.web.test;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataGenerator {

         private DataGenerator() {
    }

    static Faker faker = new Faker(new Locale("ru","RU"));


    public static String generateCity(String locale) {
        String city = faker.address().cityName();
        return city;
    }

    public static String generateFirstName(String locale) {
        final String firstName = faker.name().firstName();
        return firstName;
    }

    public static String generateLastName(String locale) {
        final String lastName = faker.name().lastName();;
        return lastName;
    }

    public static String generatePhone(String locale) {
       final String phone = faker.phoneNumber().cellPhone();
        return phone;
    }
    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
//    public static class Registration {
//        private Registration() {
//        }
//
//        public static UserInfo generateUser(String locale) {
//            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
//            // generateName(locale), generatePhone(locale)
//            return user;
//        }
//    }
//
//    @Value
//    public static class UserInfo {
//        String city;
//        String name;
//        String phone;
//    }
}
