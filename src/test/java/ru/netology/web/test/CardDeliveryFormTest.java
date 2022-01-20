package ru.netology.web.test;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardDeliveryFormTest {


    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }


    @Test
    public void shouldFormTest() throws InterruptedException {


        $("[placeholder='Город']").setValue(DataGenerator.generateCity("ru"));
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        String planningDate = DataGenerator.generateDate(4);
        $("[data-test-id=date] input").setValue(planningDate);
        $("[data-test-id=name] input").setValue(DataGenerator.generateLastName("ru") + " " + DataGenerator.generateFirstName("ru"));
        $("[data-test-id=phone] input").setValue(DataGenerator.generatePhone("ru"));
        $(".checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='success-notification'] [class='notification__title']").shouldHave(text("Успешно"),
                Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(text("Встреча успешно запланирована на " + planningDate));
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        planningDate = DataGenerator.generateDate(7);
        $("[data-test-id=date] input").setValue(planningDate);
        $(".button__text").click();
        $(byText("Перепланировать")).shouldBe(visible, Duration.ofSeconds(15)).click();
        $(".notification__content").shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(exactText("Встреча успешно запланирована на " + planningDate));
    }

    @Test
    public void shouldFormTestSameDate() throws InterruptedException {

        $("[placeholder='Город']").setValue(DataGenerator.generateCity("ru"));
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        String planningDate = DataGenerator.generateDate(4);
        $("[data-test-id=date] input").setValue(planningDate);
        $("[data-test-id=name] input").setValue(DataGenerator.generateLastName("ru") + " " + DataGenerator.generateFirstName("ru"));
        $("[data-test-id=phone] input").setValue(DataGenerator.generatePhone("ru"));
        $(".checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='success-notification'] [class='notification__title']").shouldHave(text("Успешно"),
                Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(text("Встреча успешно запланирована на " + planningDate));
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        planningDate = DataGenerator.generateDate(4);
        $("[data-test-id=date] input").setValue(planningDate);
        $(".button__text").click();
        $("[data-test-id=replan-notification] .notification__content")
                .shouldHave(text("У вас уже запланирована встреча на " + planningDate));
    }

}
