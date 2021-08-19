package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SendFormTest {
    @Test
    void shouldSubmitRequestWithFullData() {
        open("http://localhost:9999");
        $("[type=\"text\"]").setValue("Мария Иванова");
        $("[type=\"tel\"]").setValue("+79273330000");
        $("[data-test-id=\"agreement\"]").click();
        $("[type=button]").click();
        $("[data-test-id=\"order-success\"]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
