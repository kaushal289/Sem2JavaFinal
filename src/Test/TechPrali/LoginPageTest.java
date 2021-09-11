package TechPrali;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class LoginPageTest {
    @Test
    void insert_Test() {
        JDBCoperation db = new JDBCoperation();
        String query = "insert into register(username,fullname,email,gender,password,copassword)values('" + 4 + "','" + 2 + "','" + 2 + "','" + 2 + "','" + 2 + "','" + 2 + "')";
        int result = db.insert(query);
        assertEquals(1, result);
    }

    @Test
    void select_Test() throws SQLException {
        JDBCoperation db = new JDBCoperation();
        String username = "1";
        String query = "select * from register where username='" + username + "'";
        ResultSet rs = db.select(query);
        int count = rs.getRow();
        assertEquals(0, count);
    }

    @Test
    void delete_Test() {
        JDBCoperation db = new JDBCoperation();
        String sql = "DELETE FROM buysell WHERE id='" + 2 + "'";
        int rowsDeleted = db.executeDelete(sql);
        assertEquals(1, rowsDeleted);
    }

    @Test
    void test_update() {
        String query = "update register set fullname='" + 2 + "' where username='" + 2 + "'";
        JDBCoperation db = new JDBCoperation();
        int rs = db.Update(query);
        assertEquals(1, rs);
    }

    @Test
    void Test_mobile_data3() {
        Mobiledata data = new Mobiledata("kaushal", "iphone13", "apple", "8", "128", "180000", "A15 bionic", "13", "9865558257");
        assertEquals("kaushal", data.getUsername());
    }

    @Test
    void Test_mobile_data4() {
        Mobiledata data = new Mobiledata("kaushal", "iphone13", "apple", "8", "128", "180000", "A15 bionic", "13", "9865558257");
        assertEquals("wrong username", data.getUsername());
    }

    @Test
    void Test_mobile_data5() {
        Mobiledata data = new Mobiledata("kaushal", "iphone13", "apple", "8", "128", "180000", "A15 bionic", "13", "9865558257");
        assertEquals("iphone13", data.getMobilename());
    }

    @Test
    void Test_mobile_data6() {
        Mobiledata data = new Mobiledata("kaushal", "iphone13", "apple", "8", "128", "180000", "A15 bionic", "13", "9865558257");
        assertEquals("", data.getMobilename());

    }
    @Test
    void Test_reg1() {
        String pas="1";
        String pasw="1";
        RegistrationPage reg=new RegistrationPage();
        boolean result=reg.reg_test(pas,pasw);
        assertEquals(true,result);
    }
    @Test
    void Test_login1(){
        String usname="kaushal";
        String pass="1235";
        LoginPage reg=new LoginPage();
        boolean result=reg.log_test(usname,pass);
        assertEquals(true,result);
    }
}