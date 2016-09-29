package lv.javaguru.junit.workshop.section6;

public class UserAccount {

    private User user;
    private UserAccountState state;


    public UserAccount(User user, UserAccountState state) {
        this.user = user;
        this.state = state;
    }

    public boolean isActive() {
        return state == UserAccountState.ACTIVE;
    }

    public boolean isRevoked() {
        return state == UserAccountState.REVOKED;
    }

}
