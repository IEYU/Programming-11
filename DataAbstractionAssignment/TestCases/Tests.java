import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Tests {
    Customer test_customer;

    @Before
    public void setup() {
        test_customer = new Customer();
    }

    @Test
    public void test_saving() {
        //check the saving account currently has a balance of $0
        assertEquals(0, test_customer.getSavingBalance(), 0);
        //the customer deposits $400 into checking account
        test_customer.deposit(500, new Date(), Customer.SAVING);
        //check the saving account now has a balance of $500 after the deposit
        assertEquals(500, test_customer.getSavingBalance(), 0);

        //the customer withdraw all $500 from saving account
        test_customer.withdraw(500, new Date(), Customer.SAVING);
        //check the saving account now has $0 remaining
        assertEquals(0, test_customer.getSavingBalance(), 0);

        //display the deposit and withdrawal the customer just made
        test_customer.displayDeposits();
        test_customer.displayWithdraws();
    }

    @Test
    public void test_checking() {
        //check the checking account has a balance of $0 before the deposit
        assertEquals(test_customer.getCheckBalance(), 0, 0);
        //the customer deposits $500 into saving account
        test_customer.deposit(400, new Date(), Customer.CHECKING);
        //check the checking account now has a balance of $400 after the deposit
        assertEquals(test_customer.getCheckBalance(), 400, 0);

        //the customer withdraw all $400 from checking account
        test_customer.withdraw(400, new Date(), Customer.CHECKING);
        //check the checking account now has $0 remaining
        assertEquals(0, test_customer.getCheckBalance(), 0);

        //display the deposit and withdrawal the customer just made
        test_customer.displayDeposits();
        test_customer.displayWithdraws();
    }


    @Test
    public void test_withdraw_saving_overdraft() {
        //check the saving account has a balance of $0 before the withdrawal
        assertEquals(test_customer.getSavingBalance(), 0, 0);
        //the customer attempts to withdraw another $50 from saving account
        test_customer.withdraw(50, new Date(), Customer.SAVING);
        //the withdrawal successes because this is within the overdraft limit
        //check the saving account has a balance of $-50
        assertEquals(test_customer.getSavingBalance(), -50, 0);

        //check the saving account has a balance of $-50
        assertEquals(test_customer.getSavingBalance(), -50, 0);
        //the customer attempts to withdraw another $100 from saving account
        test_customer.withdraw(100, new Date(), Customer.SAVING);
        //the withdrawal fails because it is beyond the overdraft limit
        //check the saving account's balance remains at $-50
        assertEquals(test_customer.getSavingBalance(), -50, 0);

        //show the withdrawal the customer just made
        test_customer.displayWithdraws();
    }

    @Test
    public void test_withdraw_checking_overdraft() {
        //check the checking account has a balance of $0 before the withdrawal
        assertEquals(test_customer.getCheckBalance(), 0, 0);
        //the customer attempts to withdraw another $50 from checking account
        test_customer.withdraw(50, new Date(), Customer.CHECKING);
        //successes because this is within the overdraft limit
        //check the checking account's balance remains at $-50
        assertEquals(test_customer.getCheckBalance(), -50, 0);

        //check the checking account's balance remains at $-50
        assertEquals(test_customer.getCheckBalance(), -50, 0);
        //the customer attempts to withdraw another $100 from checking account
        test_customer.withdraw(100, new Date(), Customer.CHECKING);
        //the withdrawal fails because it is beyond the overdraft limit
        //check the saving account's balance remains at $-50
        assertEquals(test_customer.getCheckBalance(), -50, 0);

        //show the withdrawal the customer just made
        test_customer.displayWithdraws();
    }
}
