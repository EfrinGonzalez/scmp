package engine.rules.scmp.models;


import java.util.ArrayList;

public class Rule {
    private int id;
    private String description;
    private ArrayList<Action> actions;

    public Rule(int id, String description, ArrayList<Action> actions) {
        this.id = id;
        this.description = description;
        this.actions = actions;
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

    public ArrayList<Action> getActions() {
        return actions;
    }

    public void setActions(ArrayList<Action> actions) {
        this.actions = actions;
    }
}
