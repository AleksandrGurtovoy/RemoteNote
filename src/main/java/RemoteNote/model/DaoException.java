package RemoteNote.model;

public class DaoException extends RuntimeException {
    public DaoException() {

    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(Throwable tr, String message) {
        super(message, tr);
    }

    public DaoException(Throwable tr){
        super(tr);
    }
}
