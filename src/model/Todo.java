package model;

public class Todo {
    int id;
    String owner;
    String text;
    boolean isCompleted;

    public Todo(int id, String owner, String text, boolean isCompleted) {
        this.id = id;
        this.owner = owner;
        this.text = text;
        this.isCompleted = isCompleted;
    }

    public Todo(String owner, String text) {
        this.owner = owner;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getText() {
        return text;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

}
