package br.harlan.satisfactionsurvey;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.parse.CountCallback;
import com.parse.Parse;
import com.parse.ParseCloud;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import br.harlan.satisfactionsurvey.view.HomeActivity;
import br.harlan.satisfactionsurvey.view.SearchActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //startActivity(new Intent(this, SearchActivity.class ));
        Parse.initialize(this);
        ParseObject parseObject = new ParseObject("Teste");
        parseObject.put("nome", "cleiton");
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("Teste");
        parseQuery.countInBackground(new CountCallback() {
            @Override
            public void done(int count, ParseException e) {
                queryDone(count, e);
            }
        });
        parseObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                toException(e);
            }
        });
        ParseInstallation.getCurrentInstallation().saveInBackground();
        startActivity(new Intent(this, HomeActivity.class ));
    }

    private void queryDone(int count, ParseException e) {
        if (e == null)
            Toast.makeText(this, "Registros: " + count, Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Query failed: " + e.getCode() + " - " + e.getMessage(), Toast.LENGTH_LONG).show();
    }

    private void toException(ParseException e) {
        if(e == null){
            Toast.makeText(this, "Parse ok", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(this, "Parse failed", Toast.LENGTH_LONG).show();
    }
}