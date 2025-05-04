package com.coffeecart.ui;

import com.coffeecart.ui.modal.PaymentDetailModal;
import com.coffeecart.ui.modal.SuccessfulPopUp;
import com.coffeecart.ui.page.MenuPage;
import com.coffeecart.ui.testrunners.BaseTestRunner;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class PaymentSubmissionWithValidDataTest extends BaseTestRunner {

    private static final String SUCCESS_MESSAGE = "Thanks for your purchase. Please check your email for payment.";
    private static final String DRINK = "Espresso";

    @Test
    @Description("Verify valid name/email submission shows confirmation message.")
    @Feature("Payment Form Validation")
    @Issue("3")
    @Owner("Nataliia Hrusha")
    public void verifyPaymentSubmissionWithValidData() {
        SoftAssert softAssert = new SoftAssert();

        final String[] expectedTexts = {
                "Payment details",
                "We will send you a payment link via email.",
                "Name",
                "Email",
                "I would like to receive order updates and promotional messages.",
                "Submit"
        };

        PaymentDetailModal paymentModal = new MenuPage(driver)
                .clickDrink(DRINK)
                .clickTotalButton();

        softAssert.assertEquals(paymentModal.getHeaderText(), expectedTexts[0], "Header text mismatch");
        softAssert.assertEquals(paymentModal.getParagraphText(), expectedTexts[1], "Paragraph text mismatch");
        softAssert.assertEquals(paymentModal.getLabelNameText(), expectedTexts[2], "Name label text mismatch");
        softAssert.assertEquals(paymentModal.getLabelEmailText(), expectedTexts[3], "Email label text mismatch");
        softAssert.assertEquals(paymentModal.getLabelCheckboxText(), expectedTexts[4], "Checkbox label text mismatch");
        softAssert.assertEquals(paymentModal.getSubmitButtonText(), expectedTexts[5], "Submit button text mismatch");
        softAssert.assertFalse(paymentModal.isCheckboxMarked(), "Checkbox should be unchecked by default");

//        softAssert.assertTrue(
//                paymentModal.isBackgroundColorOfPaymentDetailModalMatch(),
//                "Payment modal should have correct background color"
//        );

        SuccessfulPopUp successPopup = paymentModal
                .enterName(testValueProvider.getUserName())
                .enterEmail(testValueProvider.getUserEmail())
                .clickSubmitButtonWithValidInput();

        softAssert.assertTrue(successPopup.isDisplayed(), "Successful popup should be visible");
        softAssert.assertEquals(successPopup.getSuccessTitleText(), SUCCESS_MESSAGE, "Success message text mismatch");

        softAssert.assertAll();
    }
}
