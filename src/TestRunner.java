// ดูโจทย์ วิธีทำใน README.md
// หน้าที่ของคุณ: ออกแบบ test เอง แล้วเติม check(...) ให้ครบทุก branch
public class TestRunner {

    static int pass = 0, fail = 0;

    static void check(String name, boolean ok) {
        if (ok) { pass++; System.out.println("  [PASS] " + name); }
        else    { fail++; System.out.println("  [FAIL] " + name); }
    }

    public static void main(String[] a) {
        boolean ea = false;
        assert ea = true;
        if (!ea) System.out.println("** คำเตือน: assertion ปิดอยู่ รันด้วย  java -ea TestRunner **");

        System.out.println("== Password Validation ==");

        // ตัวอย่าง assertion ปกติ (ตัวแทนกลุ่ม valid)
        check("'Abcdef12' valid", !PasswordValidator.validate("Abcdef12"));

        // ตัวอย่างแพตเทิร์นทดสอบ "ต้อง throw" ด้วย try/catch
        boolean threw = false;
        try { PasswordValidator.validate(null); }
        catch (IllegalArgumentException e) { threw = true; }
        check("null -> throws IllegalArgumentException", threw);

        // TODO: R2 - boundary ความยาว (เช่น 7, 8, 20, 21)
        check("pass<8", !PasswordValidator.validate("Ab12345"));
        check("pass=8", !PasswordValidator.validate("Ab123456"));
        check("pass=20", !PasswordValidator.validate("Ab123456789012345678"));
        check("pass>20", !PasswordValidator.validate("Ab1234567890123456789"));
        // TODO: R3 - ไม่มีตัวพิมพ์ใหญ่ -> false
        check("pass ไม่มีตัวพิมพ์ใหญ่", !PasswordValidator.validate("12345abcde"));
        //check("pass มีตัวพิมพ์ใหญ่", PasswordValidator.validate("12345ABcde"));
        // TODO: R4 - ไม่มีตัวพิมพ์เล็ก -> false
        check("pass ไม่มีตัวพิมพ์เล็ก", !PasswordValidator.validate("12345ABCDE"));
        //check("pass มีตัวพิมพ์เล็ก", PasswordValidator.validate("12345abCDE"));
        // TODO: R5 - ไม่มีตัวเลข -> false
        check("pass ไม่มีตัวเลข", !PasswordValidator.validate("abcdefghij"));
        //check("pass มีตัวเลข", PasswordValidator.validate("12345abcde"));
        // TODO: R6 - มีช่องว่าง -> false
        check("มีช่องว่างในรหัสผ่าน", !PasswordValidator.validate(" Abcd 12345"));
        // TODO: boundary อื่นๆ ที่คุณคิดว่าจำเป็น
        check("pass=", !PasswordValidator.validate(""));
        check("pass มีตัวอักษรพิเศษ", !PasswordValidator.validate(".*[!@#$%^&*].*'"));
        System.out.println("==================================");
        System.out.printf("PASS %d / FAIL %d%n", pass, fail);
        System.out.println("==================================");
        System.exit(fail == 0 ? 0 : 1);
    }
}
