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

import com.example.ateliereducatif.model.Youtube;
import java.util.ArrayList;
import com.example.ateliereducatif.R;
import com.squareup.picasso.Picasso;

public class RecitationAdapter extends ArrayAdapter<Youtube> {

  public RecitationAdapter(@NonNull Context context, ArrayList<Youtube> youtubeArrayList) {
    super(context, 0, youtubeArrayList);
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    View listitemView = convertView;
    if (listitemView == null) {
      // Layout Inflater inflates each item to be displayed in GridView.
      listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
    }
    Youtube yModel = getItem(position);
    TextView courseTV = listitemView.findViewById(R.id.idTitre);
    ImageView courseIV = listitemView.findViewById(R.id.idYoutube);
    courseTV.setText(yModel.getThumbnail_url());
    Picasso.with(getContext()).load(yModel.getThumbnail_url()).into(courseIV);
    return listitemView;
  }
}
