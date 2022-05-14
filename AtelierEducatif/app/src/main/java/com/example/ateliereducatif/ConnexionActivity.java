package com.example.ateliereducatif;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ateliereducatif.retrofit.RetrofitClient;
import com.example.ateliereducatif.retrofit.UtilisateurService;

import java.util.HashMap;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ConnexionActivity extends AppCompatActivity {

    com.google.android.material.button.MaterialButton boutonConnexion;
    EditText editNomUtilisateur, editMotDePasse;

    CompositeDisposable compositeDisposable = new CompositeDisposable();
    UtilisateurService uService;

    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"green\">"+ getString(R.string.app_name)+ "</font>"));

        //Init service
        Retrofit retrofitClient = RetrofitClient.getInstance();
        uService = retrofitClient.create(UtilisateurService.class);

        //Init view
        editNomUtilisateur = (EditText) findViewById(R.id.editNomUtilisateur);
        editMotDePasse = (EditText) findViewById(R.id.editMotDePasse);

        boutonConnexion = (com.google.android.material.button.MaterialButton) findViewById(R.id.boutonConnexion);
        boutonConnexion.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                connexion(editNomUtilisateur.getText().toString(),
                        editMotDePasse.getText().toString());
            }
        });
    }

    public void connexion(String nom, String mdp) {
        if(TextUtils.isEmpty(nom)) {
            Toast.makeText(this, "Veuillez remplir le nom d'utilisateur", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(mdp)) {
            Toast.makeText(this, "Veuillez remplir le mot de passe", Toast.LENGTH_SHORT).show();
            return;
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("nomUtilisateur", nom);
        map.put("motDePasse", mdp);

        Call<Void> call = uService.connexion(map);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println(response);
                Toast.makeText(ConnexionActivity.this, response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println("erreur" + t);
                Toast.makeText(ConnexionActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}