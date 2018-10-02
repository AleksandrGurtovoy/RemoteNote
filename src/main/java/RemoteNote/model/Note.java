package RemoteNote.model;

import java.time.LocalDateTime;

public class Note {
    private String title;
    private String body;
    private String author;
    private LocalDateTime dateOfEdit;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDateOfEdit() {
        return dateOfEdit;
    }

    public void setDateOfEdit(LocalDateTime dateOfEdit) {
        this.dateOfEdit = dateOfEdit;
    }
}
