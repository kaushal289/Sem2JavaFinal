import TechPrali.LoginPage;
import TechPrali.Mobiledata;
import TechPrali.RegistrationPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllTests {

    @Test
    void Test_reg1() {
        String pas="1";
        String pasw="1";
        RegistrationPage reg=new RegistrationPage();
        boolean result=reg.reg_test(pas,pasw);
        assertEquals(true,result);
    }
    @Test
    void Test_reg2() {
        String pas="1";
        String pasw="1";
        RegistrationPage reg=new RegistrationPage();
        boolean result=reg.reg_test(pas,pasw);
        assertEquals(false,result);
    }
    @Test
    void Test_login1(){
        String usname="kaushal";
        String pass="1235";
        LoginPage reg=new LoginPage();
        boolean result=reg.log_test(usname,pass);
        assertEquals(true,result);
    }
    @Test
    void Test_login2(){
        String usname="kaushal";
        String pass="1235";
        LoginPage reg=new LoginPage();
        boolean result=reg.log_test(usname,pass);
        assertEquals(false,result);
    }
    @Test
    void Test_mobile_data1(){
        String usname="kaushal";
        String pass="1235";
        LoginPage reg=new LoginPage();
        boolean result=reg.log_test(usname,pass);
        assertEquals(false,result);
    }
}