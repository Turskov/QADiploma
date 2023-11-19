package ru.netology.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DebitTest {
    PaymentPage paymentPage;

    @BeforeEach
    void setUp() {
        paymentPage = open("http://localhost:8080", PaymentPage.class);
    }

    @Test
    void shouldSuccessfullyProcessPayment() {
        var cardInfo = new DataHelper().getValidCardInfo("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifySuccessMessage();
        assertEquals ("APPROVED", new SQLHelper().getDebitStatus());
    }

    @Test
    void shouldNotProcessPaymentWithEmptyCardNumber() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyCardNumber();
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithEmptyMonthApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyMonth("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithEmptyYearApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyYear("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithEmptyNameApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyName("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyNullName();
    }

    @Test
    void shouldNotProcessPaymentWithEmptyCvcApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyCvc("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCardNumber() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCardNumber();
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCardNumberWithLetters() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCardNumberWithLetters();
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCardNumberWithSymbols() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCardNumberWithSymbols();
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCardNumberWithNotExistNumber() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCardNumberWithNotExistNumber();
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyErrorMessage();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidMonthApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonth("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidMonthWithOneNumberApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithOneNumber("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidMonthWithLettersApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithLetters("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidMonthWithSymbolsApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithSymbols("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidYearApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYear("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatYear();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidYearWithOneNumberApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithOneNumber("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidYearWithLettersApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithLetters("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidYearWithSymbolsApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithSymbols("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidNameWithOneLetterApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithOneLetter("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidNameWithNumbersApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithNumbers("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidNameWithCyrillicApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithCyrillic("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidNameWithSymbolsApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithSymbols("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCvcWithOneNumberApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithOneNumber("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCvcWithLettersApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithLetters("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCvcWithSymbolsApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithSymbols("approved");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldSuccessfullyProcessPaymentDeclinedCard() {
        var cardInfo = new DataHelper().getValidCardInfo("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyErrorMessage();
        assertEquals ("DECLINED", new SQLHelper().getDebitStatus());
    }

    @Test
    void shouldNotProcessPaymentWithEmptyMonthDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyMonth("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayProcessPaymentWithEmptyYearDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyYear("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayProcessPaymentWithEmptyNameDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyName("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyNullName();
    }

    @Test
    void shouldNotProcessPaymentWithEmptyCvcDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyCvc("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidMonthDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonth("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidMonthWithOneNumberDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithOneNumber("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotPayProcessPaymentWithInvalidMonthWithLettersDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithLetters("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidMonthWithSymbolsDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithSymbols("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidYearDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYear("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormatYear();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidYearWithOneNumberDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithOneNumber("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidYearWithLettersDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithLetters("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidYearWithSymbolsDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithSymbols("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidNameWithOneLetterDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithOneLetter("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidNameWithNumbersDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithNumbers("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidNameWithCyrillicDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithCyrillic("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidNameWithSymbolsDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithSymbols("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCvcWithOneNumberDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithOneNumber("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotPayProcessPaymentWithInvalidCvcWithLettersDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithLetters("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCvcWithSymbolsDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithSymbols("declined");
        var debitPage = paymentPage.debitPayment(cardInfo);
        debitPage.enterCardData(cardInfo);
        debitPage.verifyInvalidFormat();
    }
}
