package com.ledesma.tp1loginsharedp.ui.registro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ledesma.tp1loginsharedp.model.Usuario;
import com.ledesma.tp1loginsharedp.request.ApiClient;
import com.ledesma.tp1loginsharedp.ui.login.MainActivity;

public class RegistroActivityViewModel extends AndroidViewModel {
    Context context;
    MutableLiveData<Usuario> mUsuario;
    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);
        context = getApplication().getApplicationContext();
    }
    public LiveData<Usuario> getMUsuario(){
        if(mUsuario == null){
            mUsuario = new MutableLiveData<>();
        }
        return mUsuario;
    }

    public void cargar(){
        Usuario usuario = ApiClient.leer(context);
        if(!usuario.getNombre().equals("-1")){
            mUsuario.setValue(ApiClient.leer(context));
        }

    }
    public void guardar(String nombre, String apellido, String dni, String mail, String pass){
        if(!nombre.isEmpty()&&!apellido.isEmpty()&&!dni.isEmpty()&&!mail.isEmpty()&&!pass.isEmpty()){

            ApiClient.guardar(context, new Usuario(Long.parseLong(dni),nombre,apellido,mail,pass));
            Intent intent = new Intent(context, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }else {
            Toast.makeText(context, "No debe haber campos vacios", Toast.LENGTH_SHORT).show();
        }

    }

}
