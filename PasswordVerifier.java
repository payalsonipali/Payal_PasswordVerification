import java.util.Scanner;
import java.util.regex.Pattern;

class PasswordVerification{
    public static void main(String[] args) throws Exception {
        /* take input for password */

        System.out.print("Enter your password:");
        Scanner scanner = new Scanner(System.in);
        String takeinput = scanner.nextLine();

        verifyPassword(takeinput);

    }

    public static void verifyPassword(String password) throws Exception {

        if(password.length() == 0){
            throw new Exception("password should not be null");
        }
        else {
            if(password.length() <= 8){
                throw new Exception("password should be larger than 8 chars");
            }
            else{
                Boolean hasUpperCase = password.equals(password.toLowerCase());
                if(hasUpperCase){
                    throw new Exception("password should have one uppercase letter at least");
                }
                else{
                    Boolean hasLowerCase = password.equals(password.toUpperCase());
                    if(hasLowerCase){
                        throw new Exception("password should have one lowercase letter at least");
                    }
                    else{
                        Pattern digitPattern = Pattern.compile("(.)*(\\d)(.)*");
                        boolean hasAtleastOneDigit = digitPattern.matcher(password).matches();    
                        if(!hasAtleastOneDigit){
                            throw new Exception("password should have one number at least");
                        }else{
                            System.out.println("Password Verified Successfully"); 
                        }
                    }

                }
            }

        }
    }
}