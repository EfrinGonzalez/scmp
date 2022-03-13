package engine.rules.scmp.models;

import engine.rules.scmp.enums.RuleAction;


public class Action {
    private int id;
    private String description;
    private RuleAction action;

    public Action(int id, String description, RuleAction action) {
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

    public RuleAction getAction() {
        return action;
    }

    public void setAction(RuleAction action) {
        this.action = action;
    }
}
