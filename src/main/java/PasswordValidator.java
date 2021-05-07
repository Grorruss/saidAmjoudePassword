public class PasswordValidator {

    public boolean validatePassword(String password, String type){
        return lengthValidatePassword(password,  type) && numValidatePassword(password) && charValidatePassword(password);
    }

    public boolean lengthValidatePassword(String password, String type) {
        boolean res = false;
        if (type.equals("normal")){
            if (password.length() >= 6){
                res = true;
            }
        }
        if (type.equals("admin")){
            if (password.length() >= 10){
                res = true;
            }
        }
        System.out.println(verifyErrors(password, type));
        return res;
    }

    public boolean charValidatePassword(String password) {
        return password.matches(".*[a-zA-Z].*");
    }

    public boolean numValidatePassword(String password) {
        return password.matches(".*[0-9].*");
    }

    public boolean adminPassword(String password){
        return validatePassword(password, "admin") && specialCharPassword(password);
    }

    public boolean specialCharPassword(String password){
        return password.matches(".*[^a-zA-Z0-9].*");
    }

    public String verifyErrors(String password, String type) {
        if (!lengthValidatePassword(password, type)){
            return "the password is too short ! length error !";
        }
        if (!charValidatePassword(password)){
            return "the password must contains at least one letter ! char error !";
        }
        if (!numValidatePassword(password)){
            return "the password must contains at least one number ! char error !";
        }
        if (type.equals("admin")) {
            if (!specialCharPassword(password)){
                return "the password must contains at least one special char ! char error !";
            }
        }
        return "all good";
    }
}
