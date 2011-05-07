package by.vitsoft.material.filter;

public enum RuleOp {
    EQUAL("eq"), NOT_EQUAL("ne"), LT("lt"), LE("le"), GT("gt"), GE("ge"),
    BEGINS_WITH("bw"), NOT_BEGIN_WITH ("bn"), IN("in"), NOT_IN("ni"),
    ENDS_WITH("ew"), NOT_ENDS_WITH("en"), CONTAINS("cn"), NOT_CONTAINS("nc");

    private final String value;

    RuleOp(String v) {
        value = v;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
