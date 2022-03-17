package engine.rules.scmp.models;

import engine.rules.scmp.enums.RuleAction_deprecated;


public class Action_deprecated {
    private int id;
    private String description;
    private RuleAction_deprecated action;

    public Action_deprecated(int id, String description, RuleAction_deprecated action) {
        this.id = id;
        this.description = description;
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RuleAction_deprecated getAction() {
        return action;
    }

    public void setAction(RuleAction_deprecated action) {
        this.action = action;
    }
}
