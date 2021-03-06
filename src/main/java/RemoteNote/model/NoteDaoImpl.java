package RemoteNote.model;

import RemoteNote.db.DBConnectionImpl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NoteDaoImpl implements NoteDao {
    @Override
    public List<Note> getNotesByLogin(Long id) {
        DBConnectionImpl connection = new DBConnectionImpl();
        List<Note> notes = new ArrayList<>();
        try {
            notes = connection.getNotesByLogin(id);
        } catch (DaoException ex) {
            throw new DaoException(ex, ex.getMessage());
        }
        return notes;
    }

    @Override
    public void saveNote(Note note) {
        DBConnectionImpl connection = new DBConnectionImpl();
        try {
            connection.saveNote(note);
        } catch (DaoException ex) {
            throw new DaoException(ex, ex.getMessage());
        }
    }

    @Override
    public void updateNote(Note note) {
        DBConnectionImpl connection = new DBConnectionImpl();
        try {
            connection.updateNote(note);
        } catch (DaoException ex) {
            throw new DaoException(ex, ex.getMessage());
        }
    }
}
