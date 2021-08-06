import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Test_toString {
    Withdraw withdraw_toString_checking;
    Withdraw withdraw_toString_saving;
    Deposit deposit_toString_checking;
    Deposit deposit_toString_saving;

    @Before
    public void setup(){
        deposit_toString_checking = new Deposit(100, new Date(), "Checking");
        deposit_toString_saving = new Deposit(100, new Date(), "Saving");
        withdraw_toString_checking = new Withdraw(100, new Date(), "Checking");
        withdraw_toString_saving = new Withdraw(100, new Date(), "Saving");
    }

    @Test
    public void test_toString(){
        //check if the string representations of the objects from the deposit and withdraw contain the correct information
        assertEquals("Deposit of: $100.0 Date: " + new Date() + " into account: Checking", deposit_toString_checking.toString());
        assertEquals("Deposit of: $100.0 Date: " + new Date() + " into account: Saving", deposit_toString_saving.toString());
        assertEquals("Withdraw: $100.0 Date: " + new Date() + " from account: Checking", withdraw_toString_checking.toString());
        assertEquals("Withdraw: $100.0 Date: " + new Date() + " from account: Saving", withdraw_toString_saving.toString());
    }
}
