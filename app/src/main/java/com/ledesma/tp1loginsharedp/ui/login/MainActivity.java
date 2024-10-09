package com.ledesma.tp1loginsharedp.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.ledesma.tp1loginsharedp.R;
import com.ledesma.tp1loginsharedp.databinding.ActivityMainBinding;
import com.ledesma.tp1loginsharedp.ui.registro.RegistroActivity;
import com.ledesma.tp1loginsharedp.ui.registro.RegistroActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
                .create(MainActivityViewModel.class);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = binding.etMail.getText().toString();
                String contra = binding.etPassword.getText().toString();
                viewModel.loguear(mail, contra);
            }
        });
        binding.btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
               startActivity(intent);
            }
        });


    }
}