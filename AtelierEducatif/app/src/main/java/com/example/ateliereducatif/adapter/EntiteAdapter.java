package com.example.ateliereducatif.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.ateliereducatif.model.Entite;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.example.ateliereducatif.R;
import com.squareup.picasso.Picasso;

public class EntiteAdapter extends ArrayAdapter<Entite> implements Filterable {

  ArrayList<Entite> entiteArrayList;
  ArrayList<Entite> entiteArrayListFiltered;
  Context context;

  public EntiteAdapter(@NonNull Context context, ArrayList<Entite> entiteArrayList) {
    super(context, 0, entiteArrayList);
    this.context = context;
    this.entiteArrayList = entiteArrayList;
    this.entiteArrayListFiltered = entiteArrayList;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    if (convertView == null){
      LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
      convertView = layoutInflater.inflate(R.layout.card_animaux_item, null, true);
    }
    ImageView animauxImage = (ImageView) convertView.findViewById(R.id.idAnimauxImage);
    TextView animauxNom = (TextView) convertView.findViewById(R.id.idAnimalNom);
    animauxNom.setText(entiteArrayListFiltered.get(position).getNom());
    Picasso.with(context).load(entiteArrayListFiltered.get(position).getImage()).into(animauxImage);
    return convertView;
  }

  @Override
  public Filter getFilter() {
    Filter filter = new Filter() {
      @Override
      protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults filterResults = new FilterResults();
        if(constraint == null || constraint.length() == 0) {
          filterResults.count = entiteArrayList.size();
          filterResults.values = entiteArrayList;
        } else {
          String recherche = constraint.toString().toLowerCase();
          ArrayList<Entite> resultData = new ArrayList<>();

          for(Entite entite : entiteArrayList) {
            if(entite.getNom().toLowerCase().contains(recherche)) {
              resultData.add(entite);
            }

            filterResults.count = resultData.size();
            filterResults.values = resultData;
          }
        }
        return filterResults;
      }

      @Override
      protected void publishResults(CharSequence constraint, FilterResults results) {
        entiteArrayListFiltered = (ArrayList<Entite>) results.values;
        notifyDataSetChanged();
      }
    };
    return filter;
  }

  @Override
  public int getCount() {
    return entiteArrayListFiltered.size();
  }

  @Override
  public Entite getItem(int position) {
    return null;
  }

  @Override
  public long getItemId(int position) {
    return position;
  }
}

