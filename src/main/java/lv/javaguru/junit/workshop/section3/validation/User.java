package lv.javaguru.junit.workshop.section3.validation;


public class User {

    private String login;
    private String password;
    private String confirmedPassword;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (confirmedPassword != null ? !confirmedPassword.equals(user.confirmedPassword) : user.confirmedPassword != null)
            return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (confirmedPassword != null ? confirmedPassword.hashCode() : 0);
        return result;
    }

    public static class Builder {
        private String login;
        private String password;
        private String confirmedPassword;

        public Builder() {}

        public Builder withLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withConfirmedPassword(String confirmedPassword) {
            this.confirmedPassword = confirmedPassword;
            return this;
        }

        public User build() {
            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setConfirmedPassword(confirmedPassword);
            return user;
        }
    }

}
