package com.ledesma.tp1loginsharedp.request;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.ledesma.tp1loginsharedp.model.Usuario;

public class ApiClient {

    private static SharedPreferences sp;

    private static SharedPreferences conectar(Context context) {
        if(sp==null){
            sp=context.getSharedPreferences("datos",0);

        }
        return sp;
    }
    public static void guardar(Context context, Usuario usuario){
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("dni", usuario.getDni());
        editor.putString("nombre",usuario.getNombre());
        editor.putString("apellido", usuario.getApellido());
        editor.putString("mail", usuario.getMail());
        editor.putString("password", usuario.getPassword());
        editor.commit();
    }
    public static Usuario leer(Context context){
        SharedPreferences sp = conectar(context);
        Long dni = sp.getLong("dni",-1);
        String nombre = sp.getString("nombre", "-1");
        String apellido = sp.getString("apellido","-1");
        String mail = sp.getString("mail","-1");
        String password = sp.getString("password","-1");
        Usuario usuario = new Usuario(dni, nombre, apellido, mail, password);
        return usuario;

    }
    public static Usuario login(Context context, String email, String pass){
        SharedPreferences sp = conectar(context);
        Usuario usuario = null;
        Long dni = sp.getLong("dni",-1);
        String nombre = sp.getString("nombre", "-1");
        String apellido = sp.getString("apellido","-1");
        String mail = sp.getString("mail","-1");
        String password = sp.getString("password","-1");
        if(mail.equals(email)&&password.equals(pass)){
            usuario = new Usuario(dni, nombre, apellido,mail, password);
        }else {
            Toast.makeText(context, "Usuario y/o Contraseña Incorrectos", Toast.LENGTH_SHORT).show();
        }
        return usuario;
    }
}
