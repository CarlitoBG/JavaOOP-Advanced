import emergency.utils.RegistrationTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class RegistrationTimeTests {

    private RegistrationTime registrationTime;

    @Before
    public void initialize() {
        String mockedTime = "12:24 25/02/2016";
        this.registrationTime = new RegistrationTime(mockedTime);
    }

    @Test
    public void testToStringMethodShouldReturnFullTimeCorrectly() {
        String expected = "12:24 25/02/2016";
        String actual = this.registrationTime.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetDayMethodShouldReturnDayCorrectly() {
        Integer expected = 25;
        Integer actual = this.registrationTime.getDay();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMonthMethodShouldReturnMonthCorrectly() {
        Integer expected = 2;
        Integer actual = this.registrationTime.getMonth();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetYearMethodShouldReturnYearCorrectly() {
        Integer expected = 2016;
        Integer actual = this.registrationTime.getYear();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetHourMethodShouldReturnHourCorrectly() {
        Integer expected = 12;
        Integer actual = this.registrationTime.getHour();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMinutesMethodShouldReturnMinutesCorrectly() {
        Integer expected = 24;
        Integer actual = this.registrationTime.getMinutes();

        Assert.assertEquals(expected, actual);
    }
}