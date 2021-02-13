package com.example.state.demo;

public class AppContext {

    public static final UserState STATE_LOGIN = new LoginState();
    public static final UserState STATE_UN_LOGIN = new UnLoginState();

    private UserState currentState = STATE_UN_LOGIN;

    {
        STATE_LOGIN.setContext(this);
        STATE_UN_LOGIN.setContext(this);
    }

    public void setState(UserState state) {
        this.currentState = state;
    }

    public UserState getState() {
        return this.currentState;
    }

    public void favorite() {
        this.currentState.favorite();
    }

    public void comment(String comment) {
        this.currentState.comment(comment);
    }
}
