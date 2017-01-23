package oberver.ssahu.com.observerpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements Observer {

    private Authenticator authenticator;
    private Authenticator2 authenticator2;
    private TextView tvChangeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvChangeValue = (TextView) findViewById(R.id.tv_change_value);

        authenticator = new Authenticator();
        authenticator.setUserName("Sushant");
        authenticator.addObserver(this);

        authenticator2 = new Authenticator2();
        authenticator2.setName("abc");

        tvChangeValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authenticator.setUserName("XYZ " + new Random().nextInt(10));
                authenticator2.setName("abc " + new Random().nextInt(10));
            }
        });


        DelegatedObserver delegatedObserver = new DelegatedObserver() {

            @Override
            public void update(Observable o, Object arg) {
                Toast.makeText(getApplicationContext(),
                        "" + authenticator2.getUserName() + " ",
                        Toast.LENGTH_SHORT).show();
            }
        };

        authenticator2.getObserver().addObserver(delegatedObserver);


    }

    @Override
    public void update(Observable o, Object arg) {
        Toast.makeText(this, "" + authenticator.getUserName() + " ", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        authenticator.deleteObservers();
        authenticator2.getObserver().deleteObservers();

    }
}
