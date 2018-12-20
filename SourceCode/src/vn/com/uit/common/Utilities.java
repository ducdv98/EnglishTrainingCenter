package vn.com.uit.common;

/**
 *
 * @author Admin
 */
public class Utilities {

    public static boolean isContainLetters(String text) {
        return !text.matches("[0-9]+") || text.length() <= 0;
    }
    
    public static boolean isValidPhoneNumber(String phongNo){
        return phongNo.startsWith("0") && phongNo.length() == 10 && !isContainLetters(phongNo);
    }
    
    public static boolean isContainOnlyLetters(String text){
        return text.chars().allMatch(Character::isLetter);
    }

}
