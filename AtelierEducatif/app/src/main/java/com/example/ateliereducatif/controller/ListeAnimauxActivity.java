package com.example.ateliereducatif.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ateliereducatif.R;
import com.example.ateliereducatif.adapter.EntiteAdapter;
import com.example.ateliereducatif.model.Entite;
import com.example.ateliereducatif.model.Terre;
import com.example.ateliereducatif.model.reponse.EntiteRep;
import com.example.ateliereducatif.model.reponse.TerreRep;
import com.example.ateliereducatif.service.EntiteService;
import com.example.ateliereducatif.service.TerreService;
import com.example.ateliereducatif.utils.RetrofitClient;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListeAnimauxActivity extends BaseActivity {

    GridView entiteGV;
    EntiteService entiteService;
    List<Entite> listeEntite;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_animaux);

        TextView myTitleText = (TextView) findViewById(R.id.action_bar_title);
        myTitleText.setText("Animaux");

        Bundle extras= getIntent().getExtras();
        String click= extras.getString("click");
        entiteGV = findViewById(R.id.idListeAnimaux);
        if(click.compareTo("animaux")==0){
          getAnimaux();
          entiteGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int i, long id) {
              playAudio(listeEntite.get(i).getCri(), listeEntite.get(i).getNom());
            }
          });
        }
        if(click.compareTo("fruitEtLegume")==0){
          getFruitEtLegume();
        }
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
      Toast.makeText(this, "Cri "+nom.substring(0, 1).toLowerCase()+nom.substring(1), Toast.LENGTH_SHORT).show();
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
            EntiteAdapter adapter = new EntiteAdapter(ListeAnimauxActivity.this, (ArrayList<Entite>) listeEntite);
            entiteGV.setAdapter(adapter);
          }
          else {
            try {
              JSONObject jObjError = new JSONObject(response.errorBody().string());
              //                    System.out.println(jObjError);
                Toast.makeText(ListeAnimauxActivity.this, jObjError.getString("message"), Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        }

        @Override
        public void onFailure(Call<EntiteRep> call, Throwable t) {
          System.out.println("erreur" + t);
          Toast.makeText(ListeAnimauxActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
      });
    }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.search, menu);
      MenuItem menuItem = menu.findItem(R.id.recherche);

      SearchView searchV = (SearchView) menuItem.getActionView();
      searchV.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String s) {
          return false;
        }

        @Override
        public boolean onQueryTextChange(String s) {
          return true;
        }
      });

      return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
      int id = item.getItemId();

      if(id == R.id.recherche) {
        return true;
      }

      return super.onOptionsItemSelected(item);
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
            EntiteAdapter adapter = new EntiteAdapter(ListeAnimauxActivity.this, (ArrayList<Entite>) listeEntite);
            entiteGV.setAdapter(adapter);
          }
          else {
            try {
              JSONObject jObjError = new JSONObject(response.errorBody().string());
              //                    System.out.println(jObjError);
              Toast.makeText(ListeAnimauxActivity.this, jObjError.getString("message"), Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        }

        @Override
        public void onFailure(Call<EntiteRep> call, Throwable t) {
          System.out.println("erreur" + t);
          Toast.makeText(ListeAnimauxActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
      });
    }
}
