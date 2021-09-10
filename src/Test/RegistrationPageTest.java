import TechPrali.RegistrationPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationPageTest {

    @Test
    void reg_test1() {
        String pas="1";
        String pasw="1";
        RegistrationPage reg=new RegistrationPage();
        boolean result=reg.reg_test(pas,pasw);
        assertEquals(true,result);
    }
    @Test
    void reg_test2() {
        String pas="1";
        String pasw="4";
        RegistrationPage reg=new RegistrationPage();
        boolean result=reg.reg_test(pas,pasw);
        assertEquals(true,result);
    }


}