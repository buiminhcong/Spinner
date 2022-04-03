package com.bmcong2k.spinner_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourViewHoler> {

    private List<Tour> tourList;
    private Context context;
    public interface OnMyItemClickLister{
        void doSomething(int position);
    }
    private OnMyItemClickLister onMyItemClickLister;

    public void setOnMyItemClickLister(OnMyItemClickLister onMyItemClickLister) {
        this.onMyItemClickLister = onMyItemClickLister;
    }

    public TourAdapter(List<Tour> tourList, Context context) {
        this.tourList = tourList;
        this.context = context;
    }

    @NonNull
    @Override
    public TourViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        return new TourViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHoler holder, int position) {
        Tour t = tourList.get(position);
        holder.imageView.setImageResource(t.getImg());
        holder.txtTen.setText(t.getTen());
        holder.txtSogio.setText(t.getSogio());

        // Them
        holder.btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tourList.remove(position);
                notifyDataSetChanged();
            }
        });

        // Sua
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMyItemClickLister.doSomething(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return tourList.size();
    }

    class TourViewHoler extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView txtTen;
        private TextView txtSogio;
        private CardView cardView;
        private Button btnXoa;

        public TourViewHoler(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.item_img);
            txtTen = itemView.findViewById(R.id.item_ten);
            txtSogio = itemView.findViewById(R.id.item_sogio);
            cardView = itemView.findViewById(R.id.cardview);
            btnXoa = itemView.findViewById(R.id.btnXoa);



        }
    }

    public void addTour(Tour t){
        tourList.add(t);
        notifyDataSetChanged();
    }

}
