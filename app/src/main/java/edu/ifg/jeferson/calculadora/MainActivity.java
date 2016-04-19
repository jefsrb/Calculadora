package edu.ifg.jeferson.calculadora;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {


    private EditText valor1;
    private EditText valor2;
    private TextView saida;

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.layout.activity_main);

        valor1 = (EditText) findViewById(R.id.v1);
        valor2 = (EditText) findViewById(R.id.v2);

        saida = (TextView) findViewById(R.id.out);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void somar(View V) {

        double x = Double.parseDouble(valor1.getText().toString());
        double y = Double.parseDouble(valor2.getText().toString());
        saida.setText(String.valueOf(x + y));
    }

    public void subtrair(View V) {

        double x = Double.parseDouble(valor1.getText().toString());
        double y = Double.parseDouble(valor2.getText().toString());
        saida.setText(String.valueOf(x - y));
    }

    public void multiplicar(View V) {

        double x = Double.parseDouble(valor1.getText().toString());
        double y = Double.parseDouble(valor2.getText().toString());
        saida.setText(String.valueOf(x * y));
    }

    public void dividir(View V) {

        double x = Double.parseDouble(valor1.getText().toString());
        double y = Double.parseDouble(valor2.getText().toString());
        saida.setText(String.valueOf(x / y));
    }

    @Override
    public void onStart() {
        super.onStart();

        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://edu.ifg.jeferson.calculadora/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();


        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://edu.ifg.jeferson.calculadora/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
