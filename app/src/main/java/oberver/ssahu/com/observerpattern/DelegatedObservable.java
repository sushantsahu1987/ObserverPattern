package oberver.ssahu.com.observerpattern;

import android.util.Log;

import java.util.Observable;

/**
 * Created by sushantsahu on 23/01/17.
 */

public class DelegatedObservable extends Observable {

    @Override
    protected synchronized void setChanged() {
        Log.i("delegated-observable", "set changed");
        super.setChanged();
    }

    @Override
    protected synchronized void clearChanged() {
        Log.i("delegated-observable", "clear changed");
        super.clearChanged();
    }
}
