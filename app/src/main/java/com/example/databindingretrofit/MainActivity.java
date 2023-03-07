package com.example.databindingretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.databindingretrofit.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    RecyclerView recyclerView;
    List<UserDetails> list;

    UserDetailsAdapter userDetailsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle_view);
        getuserdata();

    }

    private void getuserdata() {

        (Api_interface.getClient().getUsersList()).enqueue(new Callback<List<UserDetails>>() {
            @Override
            public void onResponse(Call<List<UserDetails>> call, Response<List<UserDetails>> response) {
                Log.d("responseGet",response.isSuccessful() + response.toString());
                if(response.isSuccessful()){
                    if (response.body() != null){
                        list = response.body();
                        setData();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<UserDetails>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void setData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        userDetailsAdapter = new UserDetailsAdapter((List<UserDetails>) list,(Context) MainActivity.this);
        userDetailsAdapter.setList(list);
        recyclerView.setAdapter(userDetailsAdapter);

    }


}