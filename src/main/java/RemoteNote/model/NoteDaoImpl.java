package RemoteNote.model;

import RemoteNote.db.DBConnectionImpl;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class NoteDaoImpl implements NoteDao{
    @Override
    public List<Note> getNotesByLogin(String login) {
        DBConnectionImpl connection = new DBConnectionImpl();
        List<Note> notes = new ArrayList<>();
        try {
            notes = connection.getNotesByLogin(login);
        } catch (DaoException ex) {
            throw new DaoException(ex, ex.getMessage());
        }
        return notes;
    }
}
