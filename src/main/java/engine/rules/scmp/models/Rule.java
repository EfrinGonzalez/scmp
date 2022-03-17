package engine.rules.scmp.models;


import engine.rules.scmp.enums.RuleAction_deprecated;

import java.util.List;

public class Rule {
    private int id;
    private String name;
    private String description;
    private List<RuleAction_deprecated> actions;

    public Rule() {
    }

    public Rule(int id, String name, String description, List<RuleAction_deprecated> actions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.actions = actions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<RuleAction_deprecated> getActions() {
        return actions;
    }

    public void setActions(List<RuleAction_deprecated> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", actions=" + actions +
                '}';
    }
}
