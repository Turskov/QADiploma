package ru.netology.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.PaymentPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreditTest {

    PaymentPage paymentPage;

    @BeforeEach
    void setUp() {
        paymentPage = open("http://localhost:8080", PaymentPage.class);
    }

    @Test
    void shouldSuccessfullyProcessPaymentWithApprovedCard() {
        var cardInfo = new DataHelper().getValidCardInfo("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifySuccessMessage();
        assertEquals ("APPROVED", new SQLHelper().getCreditStatus());
    }

    @Test
    void shouldNotProcessPaymentWithEmptyCardNumber() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyCardNumber();
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithEmptyMonthForApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyMonth("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithEmptyYearApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyYear("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithEmptyNameApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyName("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyFullName();
    }

    @Test
    void shouldNotProcessPaymentWithEmptyCvcApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyCvc("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCardNumber() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCardNumber();
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCardNumberWithLetters() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCardNumberWithLetters();
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCardNumberWithSymbols() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCardNumberWithSymbols();
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCardNumberWithNotExistNumber() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCardNumberWithNotExistNumber();
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyErrorMessage();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidMonthApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonth("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidMonthWithOneNumberApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithOneNumber("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidMonthWithLettersApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithLetters("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidMonthWithSymbolsApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithSymbols("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidYearApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYear("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormatYear();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidYearWithOneNumberApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithOneNumber("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidYearWithLettersApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithLetters("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidYearWithSymbolsApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithSymbols("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidNameWithOneLetterApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithOneLetter("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidNameWithNumbersApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithNumbers("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidNameWithCyrillicApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithCyrillic("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidNameWithSymbolsApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithSymbols("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCvcWithOneNumberApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithOneNumber("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCvcWithLettersApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithLetters("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCvcWithSymbolsApprovedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithSymbols("approved");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldSuccessfullyProcessPaymentDeclinedCard() {
        var cardInfo = new DataHelper().getValidCardInfo("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyErrorMessage();
        assertEquals ("DECLINED", new SQLHelper().getCreditStatus());
    }

    @Test
    void shouldNotProcessPaymentWithEmptyMonthDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyMonth("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithEmptyYearDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyYear("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithEmptyNameDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyName("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyFullName();
    }

    @Test
    void shouldNotPayProcessPaymentWithEmptyCvcDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithEmptyCvc("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidMonthDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonth("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidMonthWithOneNumberDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithOneNumber("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidMonthWithLettersDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithLetters("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidMonthWithSymbolsDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidMonthWithSymbols("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormatMonth();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidYearDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYear("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormatYear();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidYearWithOneNumberDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithOneNumber("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidYearWithLettersDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithLetters("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidYearWithSymbolsDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidYearWithSymbols("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidNameWithOneLetterDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithOneLetter("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidNameWithNumbersDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithNumbers("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidNameWithCyrillicDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithCyrillic("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidNameWithSymbolsDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidNameWithSymbols("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCvcWithOneNumberDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithOneNumber("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCvcWithLettersDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithLetters("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }

    @Test
    void shouldNotProcessPaymentWithInvalidCvcWithSymbolsDeclinedCard() {
        var cardInfo = new DataHelper().getInvalidCardInfoWithInvalidCvcWithSymbols("declined");
        var creditPage = paymentPage.creditPayment(cardInfo);
        creditPage.enteringCreditCard(cardInfo);
        creditPage.verifyInvalidFormat();
    }
}
