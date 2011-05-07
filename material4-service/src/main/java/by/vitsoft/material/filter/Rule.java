package by.vitsoft.material.filter;

public class Rule {
    private String field;
    private RuleOp op;
    private String data;
    private String column;

    public Rule() {
    }

    public Rule(String field, RuleOp op, String data) {
        this.field = field;
        this.op = op;
        this.data = data;
    }

    public String getField() {
        return field;
    }
    public void setField(String field) {
        this.field = field;
    }
    public RuleOp getOp() {
        return op;
    }
    public void setOp(RuleOp op) {
        this.op = op;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "Rule [column=" + column + ", data=" + data + ", field=" + field + ", op=" + op
                + "]";
    }
}
