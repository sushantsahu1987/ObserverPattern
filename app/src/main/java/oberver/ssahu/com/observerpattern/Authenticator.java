package oberver.ssahu.com.observerpattern;

import java.util.Observable;

public class Authenticator extends Observable {

    private String userName;

    public void setUserName(String name) {
        userName = name;
        setChanged();
        notifyObservers(userName);
    }

    public String getUserName() {
        return userName;
    }

}