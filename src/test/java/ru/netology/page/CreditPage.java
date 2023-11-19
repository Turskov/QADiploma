package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreditPage {
    private final SelenideElement creditDataCard = $(byText("Кредит по данным карты"));
    private final SelenideElement enteringTheCardNumber = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement enteringTheMonth = $("[placeholder='08']");
    private final SelenideElement enteringTheYear = $("[placeholder='22']");
    private final SelenideElement enteringTheName = $$(".input__control").get(3);
    private final SelenideElement enteringCvc = $("[placeholder='999']");
    private final SelenideElement clickTheButtonContinue = $(byText("Продолжить"));
    private final SelenideElement successMessage = $(".notification_status_ok");
    private final SelenideElement errorMessage = $(".notification_status_error");
    private final SelenideElement invalidFormat = $(".input_invalid .input__sub");
    private final SelenideElement errorMessageForInvalidMonth = $(".input-group__input-case_invalid .input__sub");
    private final SelenideElement errorMessageForInvalidYear = $(byText("Истёк срок действия карты"));
    private final SelenideElement errorMessageForFullName = $(byText("Поле обязательно для заполнения"));

    public CreditPage() {
        creditDataCard.shouldBe(visible);
    }

    public void enteringCreditCard(DataHelper.CardInfo cardInfo) {
        enteringTheCardNumber.setValue(cardInfo.getCardNumber());
        enteringTheMonth.setValue(cardInfo.getMonth());
        enteringTheName.setValue(cardInfo.getName());
        enteringCvc.setValue(cardInfo.getCvc());
        clickTheButtonContinue.click();
    }

    public void verifySuccessMessage() {
        successMessage.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void verifyErrorMessage() {
        errorMessage.shouldBe(visible, Duration.ofSeconds(15));
    }

    public CreditPage clickTheButtonContinue() {
        clickTheButtonContinue.click();
        return this;
    }

    public void verifyInvalidFormatMonth() {
        errorMessageForInvalidMonth.shouldBe(visible);
    }

    public void verifyInvalidFormatYear() {
        errorMessageForInvalidYear.shouldBe(visible);
    }

    public void verifyFullName() {
        errorMessageForFullName.shouldBe(visible);
    }

    public void verifyInvalidFormat() {
        invalidFormat.shouldBe(visible);
    }
}