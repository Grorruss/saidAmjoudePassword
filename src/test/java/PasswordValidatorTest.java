import org.junit.jupiter.api.*;

public class PasswordValidatorTest {

    static PasswordValidator passwordValidator;

    @BeforeAll
    public static void initPasswordValidator(){
        passwordValidator = new PasswordValidator();
    }

    @Test
    public void smallLengthPasswordTest(){
        Assertions.assertFalse(passwordValidator.lengthValidatePassword("abcd2", "normal"));
    }

    @Test
    public void numberOnlyPasswordTest(){
        Assertions.assertFalse(passwordValidator.charValidatePassword("123456"));
    }

    @Test
    public void lettersOnlyPasswordTest(){
        Assertions.assertFalse(passwordValidator.numValidatePassword("abcdef"));
    }

    @Test
    public void lengthPasswordTest(){
        Assertions.assertTrue(passwordValidator.lengthValidatePassword("abcdef2", "normal"));
    }

    @Test
    public void numPasswordTest(){
        Assertions.assertTrue(passwordValidator.numValidatePassword("abcde3"));
    }

    @Test
    public void charPasswordTest(){
        Assertions.assertTrue(passwordValidator.charValidatePassword("abcdef"));
    }

    @Test
    public void specialCharPasswordTest(){
        Assertions.assertTrue(passwordValidator.specialCharPassword("abcdef*"));
    }

    @Test
    public void noSpecialCharPasswordTest(){
        Assertions.assertFalse(passwordValidator.specialCharPassword("abcdef"));
    }

    @Test
    public void validatePasswordTest(){
        Assertions.assertTrue(passwordValidator.validatePassword("abcdef2", "normal"));
    }

    @Test
    public void notValidatePasswordTest(){
        Assertions.assertFalse(passwordValidator.validatePassword("abcd", "normal"));
    }

    @Test
    public void adminPasswordTest(){
        Assertions.assertTrue(passwordValidator.adminPassword("abcdefghijkl2*"));
    }

    @Test
    public void notAdminPasswordTest(){
        Assertions.assertFalse(passwordValidator.adminPassword("abcdef2*"));
    }
}
