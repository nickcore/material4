package by.vitsoft.material.filter;

import java.util.List;

public class RuleSet {
    private GroupOp groupOp;
    private List<Rule> rules;

    public RuleSet() {
    }

    public RuleSet(GroupOp groupOp, List<Rule> rules) {
        this.groupOp = groupOp;
        this.rules = rules;
    }

    public GroupOp getGroupOp() {
        return groupOp;
    }
    public void setGroupOp(GroupOp groupOp) {
        this.groupOp = groupOp;
    }
    public List<Rule> getRules() {
        return rules;
    }
    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }
    @Override
    public String toString() {
        return "RuleSet [groupOp=" + groupOp + ", rules=" + rules + "]";
    }
}
