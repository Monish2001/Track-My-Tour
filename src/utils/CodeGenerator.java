package utils;

public class CodeGenerator {
    private static final long LIMIT = 10000000000L;
    private static long last = 0;

    public String getCode() {
        // 10 digits.
        long id = System.currentTimeMillis() % LIMIT;
        if (id <= last) {
            id = (last + 1) % LIMIT;
        }
        last = id;
        return last + "";
    }

    public static void main(String[] args) {
        // CodeGenerator obj = new CodeGenerator();
        // CodeGenerator obj1 = new CodeGenerator();
        // System.out.println(obj.getCode());
        // System.out.println(obj1.getCode());
        // String id = CodeGenerator.getID();
        // System.out.println(id);
        // System.out.println(CodeGenerator.getID());
        // System.out.println(CodeGenerator.getID());
        // System.out.println(CodeGenerator.getID());
        // System.out.println(CodeGenerator.getID());
        // System.out.println(CodeGenerator.getID());
        // System.out.println(CodeGenerator.getID());
        // System.out.println(CodeGenerator.getID());
        // System.out.println(CodeGenerator.getID());
    }
}
