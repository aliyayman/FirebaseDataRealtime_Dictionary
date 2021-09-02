package com.aliyayman.FirebaseSozluk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KelimelerAdapter extends RecyclerView.Adapter<KelimelerAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Kelimeler> kelimelerList;

    public KelimelerAdapter(Context mContext, List<Kelimeler> kelimelerList) {
        this.mContext = mContext;
        this.kelimelerList = kelimelerList;
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.kart_tasarim,parent,false);


        return new CardTasarimTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Kelimeler kelime=kelimelerList.get(position);
        holder.textViewIng.setText(kelime.getIngilizce());
        holder.textViewTur.setText(kelime.getTurkce());

        holder.kelime_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(mContext,"Seçilen kelime "+kelime.getIngilizce(),Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(mContext,DetayActivity.class);
                intent.putExtra("nesne",kelime);
                mContext.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return kelimelerList.size();
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder{
        private TextView textViewIng;
        private TextView textViewTur;
        private CardView kelime_card;

        public CardTasarimTutucu(@NonNull View itemView) {
            super(itemView);
            textViewIng=itemView.findViewById(R.id.textViewing);
            textViewTur=itemView.findViewById(R.id.textViewtur);
            kelime_card=itemView.findViewById(R.id.kelime_card);

        }

    }
}
