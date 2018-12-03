package RemoteNote.model;

public class User {

    private String login;
    private String fullName;
    private String password;
    private String dateOfBirthday;
    private Boolean isStudent;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }


    public Boolean getStudent() {
        return isStudent;
    }

    public void setStudent(Boolean student) {
        isStudent = student;
    }
}
