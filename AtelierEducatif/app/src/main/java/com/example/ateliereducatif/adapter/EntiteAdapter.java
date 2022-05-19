package com.example.ateliereducatif.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ateliereducatif.model.Entite;

import java.util.ArrayList;
import com.example.ateliereducatif.R;
import com.squareup.picasso.Picasso;

public class EntiteAdapter extends ArrayAdapter<Entite> {

  ArrayList<Entite> entiteArrayList;
  Context context;

  public EntiteAdapter(@NonNull Context context, ArrayList<Entite> entiteArrayList) {
    super(context, 0, entiteArrayList);
    this.context = context;
    this.entiteArrayList = entiteArrayList;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

    if (convertView==null){
      LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
      convertView = layoutInflater.inflate(R.layout.card_animaux_item, null, true);
    }
    Entite entiteModel = getItem(position);
    ImageView animauxImage = (ImageView) convertView.findViewById(R.id.idAnimauxImage);
    TextView animauxNom = (TextView) convertView.findViewById(R.id.idAnimalNom);
    animauxNom.setText(entiteModel.getNom());
    Picasso.with(context).load(entiteModel.getImage()).into(animauxImage);
    return convertView;
  }
}
