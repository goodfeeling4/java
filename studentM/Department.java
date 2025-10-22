public enum Department {
    CSE("CS", "Dr. Smith"),
    EEE("EE", "Dr. Johnson"),
    MECH("ME", "Dr. Lee");

    private final String code;
    private final String hodName;

    Department(String code, String hodName) {
        this.code = code;
        this.hodName = hodName;
    }

    public String getCode() { return code; }
    public String getHodName() { return hodName; }
}
