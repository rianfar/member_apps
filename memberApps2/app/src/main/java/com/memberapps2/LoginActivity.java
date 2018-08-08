package com.memberapps2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import adapter.UserAdapter;
import connection.LoginAPI;
import connection.ServerConnection;
import connection.Service;
import helper.RetroClient;
import model.MainApplication;
import model.User;
import model.UserList;
import model.UserLogin;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
     private Boolean status;
    private ProgressDialog pDialog;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    EditText txtusername,txtpassword;
    LoginAPI api;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
         txtusername = (EditText)findViewById(R.id.txtusername);
         txtpassword = (EditText)findViewById(R.id.txtpassword);

        Button btnLogin = (Button)findViewById(R.id.btnlogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        new Service().execute();
        pDialog = new ProgressDialog(LoginActivity.this);
        pDialog.setMessage("Loading Data.. Please wait...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        String email    = txtusername.getText().toString();
        String password = txtpassword.getText().toString();



         login("wkkssks0g88sss004wko08ok44kkw80osss40gkc","rienditya@gmail.com","password");


    }

//    @POST
//    Call<TestEntity> testOperation(@Body TestRequestBean requestBean);
//    response , request

    private void login(String key, String email, String password){

        final UserLogin userLogin = new UserLogin();
        userLogin.setKey(key);
        userLogin.setEmail(email);
        userLogin.setPassword(password);
        RetroClient.getClient().create(LoginAPI.class).responseUser(userLogin).enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                if(response.isSuccessful()){
                    pDialog.dismiss();
                    UserList list = response.body();
                    list.data.getUser_id();
                    if(list.status == true) {

                        Intent inten = new Intent(LoginActivity.this, Home.class);
                        startActivity(inten);
                    }
//                    Log.i("YISC", "post submitted to API." + userList.g());

                }
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {

            }
        });
//        TestRequestBean testRequestBean = new TestRequestBean();
//        testRequestBean.setPages(2);
//        testRequestBean.setUserId(2);
//        retrofit.create(ITestRetrofit.class).testOperation(testRequestBean).enqueue(new Callback<TestEntity>() {
//            @Override
//            public void onResponse(Call<TestEntity> call, Response<TestEntity> response) {
//                // response
//            }
//
//            @Override
//            public void onFailure(Call<TestEntity> call, Throwable t) {
//
//            }
//        });
    }



//    private void login(String key,String email, String password) {
//        final UserLogin login = new UserLogin(key,password, password);
//        Call<UserLogin> call1 = api.loginUser(login);
//        call1.enqueue(new Callback<UserLogin>() {
//            @Override
//            public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
//                UserLogin loginResponse = response.body();
//
//                Log.e("keshav", "loginResponse 1 --> " + loginResponse);
//                if (loginResponse != null) {
////                    Log.e("keshav", "getEmail       -->  " + loginResponse.getEmail());
////                    Log.e("keshav", "getMessage    -->  " + loginResponse.getMessage());
////                    Log.e("keshav", "getStatus       -->  " + loginResponse.getStatus());
////                    Log.e("keshav", "getuserID  -->  " + loginResponse.getUser_id());
////
////                    Boolean responseCode = loginResponse.getStatus();
////                    Log.e("keshav", "getResponseCode  -->  " + loginResponse.getStatus());
////                    Log.e("keshav", "getResponseMessage  -->  " + loginResponse.getMessage());
////                    if (responseCode==true) {
////                        pDialog.dismiss();
////                        Intent intent = new Intent(LoginActivity.this, Home.class);
////                    startActivity(intent);
////                    } else {
////                        pDialog.dismiss();
////                        Toast.makeText(LoginActivity.this, "WRONG PASSWORD", Toast.LENGTH_SHORT).show();
////                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<UserLogin> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "onFailure called ", Toast.LENGTH_SHORT).show();
//                call.cancel();
//            }
//        });
//    }


}

//    private void login(String key, String email, String password) {
//        UserLogin userLogin = new UserLogin(key,email, password);
//        MainApplication.retroClient.loginUser(userLogin, new Callback<UserLogin>() {
//            @Override
//            public void onResponse(Call<UserLogin> call, Response<UserLogin> response) {
//                pDialog.dismiss();
//                UserLogin responseUser = response.body();
//
//                if (response.isSuccessful() && responseUser != null) {
//                    Toast.makeText(LoginActivity.this,
//                            String.format("YISC",
//                                    responseUser.getMessage(),
//                                    responseUser.getStatus(),
//                                    responseUser.getKey(),
//                                    responseUser.getEmail(),
//                                    responseUser.getPassword(),
//                                    responseUser.getUser_id()),
//                            Toast.LENGTH_LONG)
//                            .show();
//                    Intent intent = new Intent(LoginActivity.this, Home.class);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(LoginActivity.this,
//                            String.format("Response YISC", String.valueOf(response.code()))
//                            , Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<UserLogin> call, Throwable t) {
//                pDialog.dismiss();
//                Toast.makeText(LoginActivity.this,
//                        "Error is " + t.getMessage()
//                        , Toast.LENGTH_LONG).show();
//            }
//        });
//    }

