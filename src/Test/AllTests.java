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
    void Test_mobile_data3(){
        Mobiledata data=new Mobiledata("kaushal","iphone13","apple","8","128","180000","A15 bionic","13","9865558257");
        assertEquals("kaushal",data.getUsername());
    }

    @Test
    void Test_mobile_data4(){
        Mobiledata data=new Mobiledata("kaushal","iphone13","apple","8","128","180000","A15 bionic","13","9865558257");
        assertEquals("wrong username",data.getUsername());
    }

    @Test
    void Test_mobile_data5(){
        Mobiledata data=new Mobiledata("kaushal","iphone13","apple","8","128","180000","A15 bionic","13","9865558257");
        assertEquals("",data.getMobilename());
    }

    @Test
    void Test_mobile_data6(){
        Mobiledata data=new Mobiledata("kaushal","iphone13","apple","8","128","180000","A15 bionic","13","9865558257");
        assertEquals("iphone13",data.getMobilename());
    }

}