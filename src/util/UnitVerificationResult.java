package util;

public class UnitVerificationResult {

    private final boolean valid;
    private final String type;  // "row", "col", "box"
    private final int[] indices;
    private final int value;


    public UnitVerificationResult(boolean valid, String type, int[] index, int value) {
        this.valid = valid;
        this.type = type;
        this.indices = index;
        this.value = value;
    }

    public int[] getIndices() {
        return indices;
    }

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public boolean isValid() {
        return valid;
    }

    public static UnitVerificationResult ok() {
        return new UnitVerificationResult(true, null,  null, -1);
    }

    public static UnitVerificationResult fail(String type, int[] indices, int value) {
        return new UnitVerificationResult(false, type, indices, value);
    }
}
