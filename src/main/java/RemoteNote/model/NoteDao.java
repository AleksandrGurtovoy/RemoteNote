package RemoteNote.model;

import java.util.List;

public interface NoteDao {
    List<Note> getNotesByLogin(String login);
}
