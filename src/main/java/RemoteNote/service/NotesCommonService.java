package RemoteNote.service;

import RemoteNote.brules.BusinessRules;
import RemoteNote.model.Note;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotesCommonService {
    private static final Logger LOG = Logger.getLogger(NotesCommonService.class);
    private BusinessRules businessRules = new BusinessRules();

    public List<Note> getNotes(Long id) {
        LOG.info("NotesCommonService, getting notes by id " + id + " started");
        return businessRules.getNotesByLogin(id);
    }

    public void saveNote(Note note){
        LOG.info("NotesCommonService, saving note started");
        businessRules.saveNote(note);
    }
}
