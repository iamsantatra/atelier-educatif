package com.example.ateliereducatif.fragment;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ateliereducatif.R;
import com.example.ateliereducatif.adapter.EntiteAdapter;
import com.example.ateliereducatif.controller.ListeAnimauxActivity;
import com.example.ateliereducatif.model.Entite;
import com.example.ateliereducatif.model.reponse.EntiteRep;
import com.example.ateliereducatif.service.EntiteService;
import com.example.ateliereducatif.utils.RetrofitClient;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EntiteFragment} factory method to
 * create an instance of this fragment.
 */
public class EntiteFragment extends Fragment {

  GridView entiteGV;
  EntiteService entiteService;
  List<Entite> listeEntite;
  MediaPlayer mediaPlayer;
  EntiteAdapter adapter;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_entite, container, true);

    TextView myTitleText = (TextView) rootView.findViewById(R.id.action_bar_title);

    Bundle extras= getActivity().getIntent().getExtras();
    String click= extras.getString("click");
    entiteGV = rootView.findViewById(R.id.idListeAnimaux);
    if(click.compareTo("animaux")==0){
      myTitleText.setText("Animaux");
      getAnimaux();
      entiteGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View v, int i, long id) {
          playAudio(listeEntite.get(i).getCri(), listeEntite.get(i).getNom());
        }
      });
    }
    if(click.compareTo("fruitEtLegume")==0){
      myTitleText.setText("Fruit et légume");
      getFruitEtLegume();
    }
    return rootView;
  }

  public void getFruitEtLegume() {
    Retrofit retrofitClient = RetrofitClient.getInstance();
    entiteService = retrofitClient.create(EntiteService.class);
    ArrayList<Entite> entiteModelArrayList = new ArrayList<Entite>();

    Call<EntiteRep> call = entiteService.liste_fruitsEtLegumes();
    call.enqueue(new Callback<EntiteRep>() {
      @Override
      public void onResponse(Call<EntiteRep> call, Response<EntiteRep> response) {
        if(response.isSuccessful()) {
          listeEntite = response.body().getData();
          adapter = new EntiteAdapter(getActivity(), (ArrayList<Entite>) listeEntite);
          entiteGV.setAdapter(adapter);
        }
        else {
          try {
            JSONObject jObjError = new JSONObject(response.errorBody().string());
            //                    System.out.println(jObjError);
            Toast.makeText(getActivity(), jObjError.getString("message"), Toast.LENGTH_SHORT).show();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }

      @Override
      public void onFailure(Call<EntiteRep> call, Throwable t) {
        System.out.println("erreur" + t);
        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
  }

  public void getAnimaux() {
    Retrofit retrofitClient = RetrofitClient.getInstance();
    entiteService = retrofitClient.create(EntiteService.class);
    ArrayList<Entite> entiteModelArrayList = new ArrayList<Entite>();

    Call<EntiteRep> call = entiteService.liste_animaux();
    call.enqueue(new Callback<EntiteRep>() {
      @Override
      public void onResponse(Call<EntiteRep> call, Response<EntiteRep> response) {
        if(response.isSuccessful()) {
          listeEntite = response.body().getData();
          adapter = new EntiteAdapter(getActivity(), (ArrayList<Entite>) listeEntite);
          entiteGV.setAdapter(adapter);
        }
        else {
          try {
            JSONObject jObjError = new JSONObject(response.errorBody().string());
            //                    System.out.println(jObjError);
            Toast.makeText(getActivity(), jObjError.getString("message"), Toast.LENGTH_SHORT).show();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }

      @Override
      public void onFailure(Call<EntiteRep> call, Throwable t) {
        System.out.println("erreur" + t);
        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
  }

  private void playAudio(String audioUrl, String nom) {
    // initializing media player
    mediaPlayer = new MediaPlayer();

    // below line is use to set the audio
    // stream type for our media player.
    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

    // below line is use to set our
    // url to our media player.
    try {
      mediaPlayer.setDataSource(audioUrl);
      // below line is use to prepare
      // and start our media player.
      mediaPlayer.prepare();
      mediaPlayer.start();

    } catch (Exception e) {
      e.printStackTrace();
    }
    // below line is use to display a toast message.
    Toast.makeText(getActivity(), "Cri "+nom.substring(0, 1).toLowerCase()+nom.substring(1), Toast.LENGTH_SHORT).show();
  }
}
