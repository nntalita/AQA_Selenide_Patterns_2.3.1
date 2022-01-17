package ru.netology.web.test;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataGenerator {

    Faker faker = new Faker(new Locale("ru","RU"));

    private final String phone = faker.phoneNumber().cellPhone();
    private final String city = faker.address().cityName();
    private final String firstName = faker.name().firstName();
    private final String lastName = faker.name().lastName();
}
