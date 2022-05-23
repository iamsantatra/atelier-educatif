package com.example.ateliereducatif.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ateliereducatif.R;
import com.example.ateliereducatif.controller.ConnexionActivity;
import com.example.ateliereducatif.controller.MenuActivity;
import com.example.ateliereducatif.model.Utilisateur;
import com.example.ateliereducatif.model.reponse.UtilisateurRep;
import com.example.ateliereducatif.service.UtilisateurService;
import com.example.ateliereducatif.utils.RetrofitClient;

import org.json.JSONObject;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConnexionFragment} factory method to
 * create an instance of this fragment.
 */
public class ConnexionFragment extends Fragment {

  Button boutonConnexion;
  EditText editNomUtilisateur, editMotDePasse;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_connexion, container, true);

    editNomUtilisateur = rootView.findViewById(R.id.editNomUtilisateur);
    editMotDePasse = rootView.findViewById(R.id.editMotDePasse);
    boutonConnexion = rootView.findViewById(R.id.boutonConnexion);

    return rootView;
  }

  private View.OnClickListener boutonConnListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      connexion(editNomUtilisateur.getText().toString(),
        editMotDePasse.getText().toString());
    }
  };

  public void connexion(String nom, String mdp) {
    if(TextUtils.isEmpty(nom)) {
      Toast.makeText(getActivity(), "Veuillez remplir le nom d'utilisateur", Toast.LENGTH_SHORT).show();
      return;
    }

    if(TextUtils.isEmpty(mdp)) {
      Toast.makeText(getActivity(), "Veuillez remplir le mot de passe", Toast.LENGTH_SHORT).show();
      return;
    }

    HashMap<String, String> map = new HashMap<>();
    map.put("nomUtilisateur", nom);
    map.put("motDePasse", mdp);

    //Init service
    Retrofit retrofitClient = RetrofitClient.getInstance();
    UtilisateurService uService = retrofitClient.create(UtilisateurService.class);

    Call<UtilisateurRep> call = uService.connexion(map);
    call.enqueue(new Callback<UtilisateurRep>() {
      @Override
      public void onResponse(Call<UtilisateurRep> call, Response<UtilisateurRep> response) {
        if(response.isSuccessful()) {
          UtilisateurRep resultat = response.body();
          Utilisateur user = response.body().getUtilisateur();

          Intent intent = new Intent(getActivity(), MenuActivity.class);

          startActivity(intent);
        }
        else {
          try {
            JSONObject jObjError = new JSONObject(response.errorBody().string());
            //                    System.out.println(jObjError);
            Toast.makeText(getActivity(), jObjError.getString("message"), Toast.LENGTH_SHORT).show();
          } catch (Exception e) {
          }
        }
      }

      @Override
      public void onFailure(Call<UtilisateurRep> call, Throwable t) {
        System.out.println("erreur" + t);
        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
  }
}
