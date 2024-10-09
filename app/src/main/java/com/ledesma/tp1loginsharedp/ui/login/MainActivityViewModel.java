package com.ledesma.tp1loginsharedp.ui.login;

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
import com.ledesma.tp1loginsharedp.ui.registro.RegistroActivity;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Usuario> mUsuario;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = getApplication().getApplicationContext();
    }

    public LiveData<Usuario> getmUsuario() {
        if(mUsuario == null){
            mUsuario = new MutableLiveData<>();
        }
        return mUsuario;
    }
    public void loguear(String user, String pass){
        Usuario usuario = ApiClient.login(getApplication(), user, pass);
        if(usuario!=null){
            mUsuario.setValue(usuario);
        }
    }

    public void registrarse(){
        Intent intent = new Intent(context, RegistroActivity.class);
        intent.putExtra("usuario", false);
        intent.addFlags(-1);
        context.startActivity(intent);
    }


}
