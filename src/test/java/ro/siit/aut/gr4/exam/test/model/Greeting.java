package ro.siit.aut.gr4.exam.test.model;

public class Greeting {

    private int id;
    private String content;
    private String date;

    public Greeting() {

    }

    public Greeting(int id, String content, String date) {
        this.id = id;
        this.content = content;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
