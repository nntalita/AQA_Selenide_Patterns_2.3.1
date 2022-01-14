package ru.netology.web;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import javax.print.attribute.standard.RequestingUserName;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataGenerator {
//    private String nameG;
//    private String surname;


    Faker faker = new Faker(new Locale("ru","RU"));

    private final String name = faker.name().fullName();
    private final String phone = faker.phoneNumber().cellPhone();
    private final String city = faker.address().cityName();


    String firstName = faker.name().firstName(); // Emory
    String lastName = faker.name().lastName(); // Barton



}
