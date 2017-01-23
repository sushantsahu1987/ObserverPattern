package oberver.ssahu.com.observerpattern;

import java.util.Observer;

/**
 * Created by sushantsahu on 23/01/17.
 */

public class Authenticator2 {

    private String name;
    private DelegatedObservable delegatedObservable = new DelegatedObservable();

    public void setName(String name) {
        this.name = name;
        delegatedObservable.setChanged();
        delegatedObservable.notifyObservers(this.name);
    }


    public DelegatedObservable getObserver() {
        return delegatedObservable;
    }


    public String getUserName() {
        return name;
    }

    public String getName() {
        return name;
    }
}
