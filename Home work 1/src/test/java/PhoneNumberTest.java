import org.junit.Assert;
import org.junit.Test;

public class PhoneNumberTest {

    CalculatedService calculator = new CalculatedService();
    PhoneNumberValidator validator = new PhoneNumberValidator();

    @Test
    public void stringWithOutNumerics() throws Exception {
        Assert.assertEquals("0", calculator.calculate("Hello!!!"));
    }

    @Test

    public void stringWithNumerics() throws Exception {
        Assert.assertEquals("10", calculator.calculate("+3-5/2"));
    }

    @Test
    public void tooShortPhoneNumber() throws Exception {
        Assert.assertFalse("phone number too short!!!", validator.validate("1"));
    }

    @Test
    public void tooLongPhoneNumber() throws Exception {
        Assert.assertFalse("phone number too long!!!", validator.validate("99999999999999999999999999999999999999999999"));
    }

    @Test
    public void phoneNumberHasRightLength() throws Exception {
        Assert.assertTrue("phone number in not correct!!!", validator.validate("0555555555"));
    }
}
