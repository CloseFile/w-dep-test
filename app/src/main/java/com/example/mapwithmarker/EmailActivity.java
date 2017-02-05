package com.example.mapwithmarker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.util.Patterns;


public class EmailActivity extends AppCompatActivity {

//    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";

    TextInputLayout emailLayout, titleLayout, textLayout;
    EditText editEmail, editTitle, editText;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateText() && validateEmail()) {
                    Snackbar.make(view, "Сообщение отправленно",
                            Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }
        });

        editEmail = (EditText) findViewById(R.id.edit_email);
        editTitle = (EditText) findViewById(R.id.edit_title);
        editText = (EditText) findViewById(R.id.edit_text);

        emailLayout = (TextInputLayout) findViewById(R.id.layoutEmail);
        titleLayout = (TextInputLayout) findViewById(R.id.layoutTitle);
        textLayout = (TextInputLayout) findViewById(R.id.layoutText);
    }

    private boolean validateEmail() {
        String email = editEmail.getText().toString().trim();
        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailLayout.setErrorEnabled(false);
            return true;
        } else {
            emailLayout.setError(getString(R.string.msg_err_email));
            requestFocus(editEmail);
        }
        return false;
    }

    private boolean validateText() {
        String name = editText.getText().toString().trim();
        if (name.isEmpty()) {
            textLayout.setError(getString(R.string.msg_err_name));
            requestFocus(editText);
            return false;
        } else {
            textLayout.setErrorEnabled(false);
        }
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.on_email:
                Intent intent = new Intent(this, EmailActivity.class);
                startActivity(intent);
                return true;
            case R.id.on_address:

                intent = new Intent(this, AddressActivity.class);
                startActivity(intent);
                return true;
            default:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
//               return super.onOptionsItemSelected(item);
        }
    }
}







