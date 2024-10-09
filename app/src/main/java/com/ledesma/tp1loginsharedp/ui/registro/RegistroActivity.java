package com.ledesma.tp1loginsharedp.ui.registro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ledesma.tp1loginsharedp.R;
import com.ledesma.tp1loginsharedp.databinding.ActivityRegistroBinding;
import com.ledesma.tp1loginsharedp.model.Usuario;

public class RegistroActivity extends AppCompatActivity {
    private ActivityRegistroBinding binding;
    private RegistroActivityViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())
                .create(RegistroActivityViewModel.class);
        setContentView(binding.getRoot());

        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = binding.etNombre.getText().toString();
                String apellido = binding.etApellido.getText().toString();
                String dni = binding.etDni.getText().toString();
                String mail = binding.etEmail.getText().toString();
                String pass = binding.etPass.getText().toString();
                viewModel.guardar(nombre, apellido, dni, mail, pass);
            }
        });

        viewModel.getMUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                binding.etNombre.setText(usuario.getNombre());
                binding.etApellido.setText(usuario.getApellido());
                binding.etDni.setText(String.valueOf(usuario.getDni()));
                binding.etEmail.setText(usuario.getMail());
                binding.etPass.setText(usuario.getPassword());

            }
        });
        viewModel.cargar(getIntent());
    }
}