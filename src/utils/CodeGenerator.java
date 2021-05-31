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

}
