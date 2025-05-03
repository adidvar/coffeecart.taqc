package com.coffeecart.ui.discardLuckyProposition;

import com.coffeecart.ui.testrunners.BaseTestRunner;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class DiscardLuckyPropositionTest extends BaseTestRunner {
    TestCaseVerifyLuckyPropositionDiscard verifyLuckyPropositionDiscard;
    @Test
    public void testLuckyPropositionDiscard() {
        verifyLuckyPropositionDiscard.selectDrink("Flat White");
    }
}
