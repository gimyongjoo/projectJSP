package todoController.dto;

public class Todo {
    private int id;
    private String content;
    private boolean done;

    @Override
    public String toString() {
        return id + " | " + content + " | " + (done ? "완료" : "미완료");
    }

    public Todo() {
    }

    public Todo(String content) {
        this.content = content;
    }

    public Todo(int id, String content, boolean done) {
        this.id = id;
        this.content = content;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
