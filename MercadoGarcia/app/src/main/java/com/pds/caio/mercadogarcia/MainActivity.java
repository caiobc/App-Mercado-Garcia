package com.pds.caio.mercadogarcia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private Button srch;
    public static String code;
    public static TextView result;
    public static TextView nome_produto;
    /*public static TextView preco1;
    public static TextView preco2;
    public static TextView preco3;
    public static TextView preco4;*/
    LoginButton login_button;
    CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callbackManager = CallbackManager.Factory.create();
        login_button = (LoginButton)findViewById(R.id.login_button);
        FacebookSdk.sdkInitialize(getApplicationContext());
        loginWithFB();

        result = (TextView)findViewById(R.id.result);
        btn = (Button)findViewById(R.id.scan_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScanActivity.class);
                startActivity(intent);
            }
        });

        srch = (Button)findViewById(R.id.search_button);
        srch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProductActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginWithFB(){
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException error) {
            }
        });
    }


    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        callbackManager.onActivityResult(requestCode, resultCode, intent);
    }
}
