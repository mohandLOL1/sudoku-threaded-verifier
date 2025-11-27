package util;

public class VerificationResult {
    private final boolean valid;
    private final String type;  // "row", "col", "box"
    private final int index;
    private final int value;

    public VerificationResult(boolean valid, String type, int index, int value) {
        this.valid = valid;
        this.type = type;
        this.index = index;
        this.value = value;
    }

    public static VerificationResult ok() {
        return new VerificationResult(true, null, -1, -1);
    }

    public static VerificationResult fail(String type, int index, int value) {
        return new VerificationResult(false, type, index, value);
    }
}
