package com.example.ateliereducatif.adapter;

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
import com.example.ateliereducatif.model.Recitation;
import com.example.ateliereducatif.model.Youtube;
import java.util.ArrayList;
import com.example.ateliereducatif.R;
import com.squareup.picasso.Picasso;

public class RecitationAdapter extends ArrayAdapter<Youtube> {

  ArrayList<Youtube> youtubeArrayList;
  Context context;

  public RecitationAdapter(@NonNull Context context, ArrayList<Youtube> youtubeArrayList) {
    super(context, 0, youtubeArrayList);
    this.context = context;
    this.youtubeArrayList = youtubeArrayList;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

    if (convertView == null) {
      LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
      convertView = layoutInflater.inflate(R.layout.card_item, null, true);
    }
    Youtube youtubeModel = getItem(position);
    ImageView youtubeImage = convertView.findViewById(R.id.idYoutube);
    TextView youtubeNom = convertView.findViewById(R.id.idTitre);
    youtubeNom.setText(youtubeModel.getTitle());
    Picasso.with(context).load(youtubeModel.getThumbnail_url()).into(youtubeImage);
    return convertView;
  }


}
