package ru.netology.web;

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

    @Test
    public void shouldFormTest() throws InterruptedException {
        DataGenerator dataGenerator = new DataGenerator();
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue(dataGenerator.getCity());
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        String planningDate = generateDate(4);
        $("[data-test-id=date] input").setValue(planningDate);
        $("[data-test-id=name] input").setValue(dataGenerator.getName());
        $("[data-test-id=phone] input").setValue(dataGenerator.getPhone());
        $(".checkbox__box").click();
        $(".button__text").click();
        $("[data-test-id='success-notification'] [class='notification__title']").shouldHave(text("Успешно"), Duration.ofSeconds(15));
        $(".notification__content").shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(text("Встреча успешно запланирована на " + planningDate));
        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);
        planningDate = generateDate(7);
        $("[data-test-id=date] input").setValue(planningDate);
        Thread.sleep(5000);
        $(".button__text").click();
        Thread.sleep(5000);
        $(byText("Перепланировать")).shouldBe(visible, Duration.ofSeconds(15)).click();
        $(".notification__content").shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(exactText("Встреча успешно запланирована на " + planningDate));
            }

    String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
