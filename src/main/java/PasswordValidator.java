public class PasswordValidator {

    public boolean validatePassword(String password, String type){
        return lengthValidatePassword(password,  type) && numValidatePassword(password) && charValidatePassword(password);
    }

    public boolean lengthValidatePassword(String password, String type) {
        boolean res = false;
        if (type == "normal"){
            if (password.length() >= 6){
                res = true;
            }
        }
        if (type == "admin"){
            if (password.length() >= 10){
                res = true;
            }
        }
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
}
