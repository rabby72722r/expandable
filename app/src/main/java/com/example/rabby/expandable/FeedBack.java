package com.example.rabby.expandable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedBack extends AppCompatActivity implements View.OnClickListener {
    private Button sendbtn, clearbtn;
    private EditText nameet, massageet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        android.support.v7.app.ActionBar ab=getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        initView();
    }

    private void initView() {

        sendbtn = (Button) findViewById(R.id.send);
        clearbtn = (Button) findViewById(R.id.clear);

        nameet = (EditText) findViewById(R.id.et1);
        massageet = (EditText) findViewById(R.id.et2);

        sendbtn.setOnClickListener(this);
        clearbtn.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    /*
        ----- This method is called, when any menu option is clicked
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.homeBtnId) {

            // -- home button click from actionbar
            Intent home= new Intent(FeedBack.this,MainActivity.class);
            startActivity(home);

            Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.aboutUsId) {
            // --- about us button click from actionbar
            Intent about= new Intent(this,HelpActivity.class);
            startActivity(about);
            return true;
        }

        if (id == R.id.SettingsId) {
            // ---- log out button click from actionbar
            Intent settings= new Intent(this,SettingsActivity.class);
            startActivity(settings);

            return true;
        }

        if (id == R.id.FeedbackId) {
            // ---- log out button click from actionbar
            Intent feedback= new Intent(this,FeedBack.class);
            startActivity(feedback);

            return true;
        }

        if (id == R.id.exitId) {

            // ---- exit button click from actionbar
            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {

        String name = nameet.getText().toString();
        String massage = massageet.getText().toString();

        if (view.getId() == R.id.send) {
            try {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"sabrinahoque463@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from app");
                intent.putExtra(Intent.EXTRA_TEXT, "Name : " + name + "\n Message : " + massage);
                startActivity(Intent.createChooser(intent, "Feedback with"));

            } catch (Exception e) {

                Toast.makeText(this, "Exception : "+e, Toast.LENGTH_SHORT).show();

            }

        } else if (view.getId() == R.id.clear) {

            nameet.setText("");
            massageet.setText("");

        }

    }
}
