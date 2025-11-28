package util;

import java.util.Arrays;

public class FailedVerificationResult {
    private final String unitType;  // "row", "column", "box"
    private final int unitIndex;    // which row/col/box
    private final int value;        // duplicated value
    private final int[] positions;  // indices where duplicates occurred

    public FailedVerificationResult(String unitType, int unitIndex, int value, int[] positions) {
        this.unitType = unitType;
        this.unitIndex = unitIndex;
        this.value = value;
        this.positions = positions;
    }

    @Override
    public String toString() {
        return String.format(
                "%s %d, #%d, %s",
                unitType.toUpperCase(),
                unitIndex + 1,
                value,
                Arrays.toString(positions)
        );
    }
}