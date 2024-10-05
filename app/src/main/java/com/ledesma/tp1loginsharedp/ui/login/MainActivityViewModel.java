package com.ledesma.tp1loginsharedp.ui.login;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ledesma.tp1loginsharedp.model.Usuario;
import com.ledesma.tp1loginsharedp.request.ApiClient;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<String> mMail;
    private MutableLiveData<String> mPassword;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context = getApplication().getApplicationContext();
    }

    public LiveData<String> getMMail(){
        if(mMail==null){
            mMail = new MutableLiveData<>();
        }
        return mMail;
    }
    public LiveData<String> getMPasssword(){
        if(mPassword==null){
            mPassword = new MutableLiveData<>();
        }
        return mPassword;
    }

    public void loguearse(String email, String pass){
        ApiClient api = new ApiClient();
        if(email.isEmpty()||pass.isEmpty()){
            Toast.makeText(context, "Introduzca un correo y una contraseña", Toast.LENGTH_SHORT).show();
        }else {
            Usuario usuario = new Usuario();
        }
    }


}
