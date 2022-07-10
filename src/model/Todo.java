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

}
