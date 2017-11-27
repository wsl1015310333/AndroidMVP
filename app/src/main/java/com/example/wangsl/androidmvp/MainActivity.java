package com.example.wangsl.androidmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginView,View.OnClickListener {
    private ProgressBar progressBar;
    EditText editTextLogin;
    EditText editTextpassword;
    Button buttonLogin;
    private LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextLogin=(EditText)findViewById(R.id.account);
        editTextpassword=(EditText)findViewById(R.id.password);
        buttonLogin=(Button)findViewById(R.id.login);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        presenter = new LoginPresenterImpl(this);
    }
    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        editTextLogin.setError(getString(R.string.username_error));
    }

    @Override
    public void setPasswordError() {
        editTextpassword.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
// TODO       startActivity(new Intent(this, MainActivity.class));
        Toast.makeText(this,"login success",Toast.LENGTH_SHORT).show();
//        finish();
    }

    @Override
    public void onClick(View v) {
        presenter.validateCredentials(editTextLogin.getText().toString(), editTextpassword.getText().toString());
    }
}
