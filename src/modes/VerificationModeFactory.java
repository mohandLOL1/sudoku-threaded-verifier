package modes;


public class VerificationModeFactory {

    public static VerificationMode getMode(String modeName) {
        return switch (modeName.toLowerCase()) {
            case "sequential" -> new SequentialVerificationMode();
            case "3-threaded" -> new ThreeThreadVerificationMode();
            case "27-threaded" -> new TwentySevenThreadVerificationMode();
            default -> throw new IllegalArgumentException("Unknown mode: " + modeName);
        };
    }
}