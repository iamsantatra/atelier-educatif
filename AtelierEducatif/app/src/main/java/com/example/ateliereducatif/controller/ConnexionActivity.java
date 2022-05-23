package com.example.ateliereducatif.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ateliereducatif.R;
import com.example.ateliereducatif.model.Utilisateur;
import com.example.ateliereducatif.model.reponse.UtilisateurRep;
import com.example.ateliereducatif.utils.RetrofitClient;
import com.example.ateliereducatif.service.UtilisateurService;

import org.json.JSONObject;

import java.util.HashMap;
import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ConnexionActivity extends AppCompatActivity {

    Button boutonConnexion;
    EditText editNomUtilisateur, editMotDePasse;

    CompositeDisposable compositeDisposable = new CompositeDisposable();
    UtilisateurService uService;

    // SharedPreferences sharedpreferences;

    // creating constant keys for shared preferences.
    public static final String SHARED_PREFS = "shared_prefs";



    @Override
    protected void onStop() {
        compositeDisposable.clear();
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        System.out.println(sharedpreferences.getString("NOM_KEY", null));
//        if(sharedpreferences.contains("NOM_KEY")) {
//          Intent intent = new Intent(ConnexionActivity.this, MenuActivity.class);
//          startActivity(intent);
//          finish();
//        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setCustomView(R.layout.actionbar);
        TextView myTitleText = (TextView) findViewById(R.id.action_bar_title);
        myTitleText.setText("KILONGA");
//        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"green\">"+ getString(R.string.app_name)+ "</font>"));

        //Init service
        Retrofit retrofitClient = RetrofitClient.getInstance();
        uService = retrofitClient.create(UtilisateurService.class);


        //Init view
        editNomUtilisateur = (EditText) findViewById(R.id.editNomUtilisateur);
        editMotDePasse = (EditText) findViewById(R.id.editMotDePasse);

        editNomUtilisateur.setText("leo2018");
        editMotDePasse.setText("12345678");

        boutonConnexion = (Button) findViewById(R.id.boutonConnexion);
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

        Call<UtilisateurRep> call = uService.connexion(map);
        call.enqueue(new Callback<UtilisateurRep>() {
            @Override
            public void onResponse(Call<UtilisateurRep> call, Response<UtilisateurRep> response) {
                if(response.isSuccessful()) {
                    UtilisateurRep resultat = response.body();
                    Utilisateur user = response.body().getUtilisateur();
//                    sharedpreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedpreferences.edit();
//                    editor.putString("NOM_KEY", user.getNom());
//                    editor.putString("NOM_UTILISATEUR_KEY", user.getNomUtilisateur());
//                    editor.putString("TOKEN_KEY", resultat.getToken());

                    Intent intent = new Intent(ConnexionActivity.this, MenuActivity.class).putExtra("name", "connexion");

                    startActivity(intent);
                    finish();
                }
                else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        //                    System.out.println(jObjError);
                        Toast.makeText(ConnexionActivity.this, jObjError.getString("message"), Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                    }
                }
            }

            @Override
            public void onFailure(Call<UtilisateurRep> call, Throwable t) {
                System.out.println("erreur" + t);
                Toast.makeText(ConnexionActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
