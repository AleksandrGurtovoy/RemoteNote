package RemoteNote.brules;

import RemoteNote.model.*;
import RemoteNote.service.ServiceException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BusinessRules {


    private UserDaoImpl userDao = new UserDaoImpl();
    private NoteDaoImpl noteDao = new NoteDaoImpl();

    public User getUser(String login) {
        if (Objects.isNull(login)) {
            throw new ServiceException("Login is null");
        }
        User user;
        try {
            user = userDao.getUserByLogin(login);
        } catch (DaoException ex) {
            throw new ServiceException(ex, ex.getMessage());
        }
        if (Objects.isNull(user)) {
            throw new RuntimeException("User with login = " + login + " not found");
        }
        return user;
    }

    public Boolean saveUserData(String login, String fullName, String date) {
        if (Objects.isNull(fullName)) {
            fullName = "";
        }
        if (Objects.isNull(date)) {
            date = "";
        }
        if (Objects.isNull(login)) {
            throw new RuntimeException("Login must be not null");
        }
        Boolean result = false;
        try {
            result = userDao.saveUserData(login, fullName, date);
        } catch (DaoException ex) {
            throw new ServiceException(ex, ex.getMessage());
        }
        return result;
    }

    public List<Note> getNotesByLogin(Long id) {
        if (Objects.isNull(id)) {
            throw new RuntimeException("Login must be not null");
        }
        List<Note> notes = new ArrayList<>();
        try {
            notes = noteDao.getNotesByLogin(id);
        } catch (DaoException ex) {
            throw new ServiceException(ex, ex.getMessage());
        }
        return notes;
    }


    public String getPhoto(String login) {
        if (Objects.isNull(login)) {
            throw new ServiceException("Login is null");
        }
        String photo;
        try {
            photo = userDao.getPhotoByLogin(login);
        } catch (DaoException ex) {
            throw new ServiceException(ex, ex.getMessage());
        }
        if (Objects.isNull(photo)) {
            throw new RuntimeException("Photo by login = " + login + " not found");
        }
        return photo;
    }

    public String setPhoto(String login, String photo) {
        if (Objects.isNull(login)) {
            throw new ServiceException("Login is null");
        }
        if (Objects.isNull(photo)) {
            throw new ServiceException("photo is null");
        }
        try {
            userDao.setPhotoByLogin(login, photo);
            return "Ok";
        } catch (Exception ex) {
            throw new ServiceException(ex, ex.getMessage());
        }
    }

    public void saveNote(Note note){
        if(Objects.isNull(note)){
            throw new ServiceException("note is null");
        }
        if(Objects.isNull(note.getBody())){
            throw new ServiceException("body is null");
        }
        if(Objects.isNull(note.getId())){
            throw new ServiceException("id is null");
        }
        if(Objects.isNull(note.getTitle())){
            throw new ServiceException("title is null");
        }
        try{
            noteDao.saveNote(note);
        } catch (Exception ex) {
        throw new ServiceException(ex, ex.getMessage());
    }
    }
}
