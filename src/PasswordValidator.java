// ดูโจทย์ spec และวิธีทำใน README.md
public class PasswordValidator {

    static final int MIN_LEN = 8;
    static final int MAX_LEN = 20;

    static boolean validate(String pw) {
        
        // TODO: implement ตาม spec ใน README.md (R1-R6)
        if (pw == null) {
            throw new IllegalArgumentException("Password is null");
        }

        if (pw.length()<MIN_LEN || pw.length() >MAX_LEN) {
            return false;
        }
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpace = false;
        boolean hasspcha = false;
        String SpChar = ".*[!@#$%^&*].*'";

        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (c >= 'A' && c <= 'Z') hasUpper = true;
            else if (c >= 'a' && c <= 'z') hasLower = true;
            else if (c >= '0' && c <= '9') hasDigit = true;
            else if (c == ' ') hasSpace = false;
            else if (SpChar.indexOf(i) != -1) hasspcha = true;
        }

        if (!hasUpper) {return false;}
        if (!hasLower) {return false;}
        if (!hasDigit) {return false;}
        if (!hasSpace) {return false;}
        if (!hasspcha) {return false;}

        return true;
    }
}
