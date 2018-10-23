package RemoteNote.service;

public class ServiceException extends RuntimeException {

    public ServiceException(Throwable tr, String message) {
        super(message, tr);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException() {

    }

    public ServiceException(Throwable tr) {
        super(tr);
    }

}
