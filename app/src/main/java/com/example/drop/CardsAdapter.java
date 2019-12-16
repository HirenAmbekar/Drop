package com.example.drop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardsViewHolder> {

    private Context mCtx;
    private List<Cards> cardsList;
    ConstraintLayout constraintLayout;

    public CardsAdapter(Context mCtx, List<Cards> cardsList) {
        this.mCtx = mCtx;
        this.cardsList = cardsList;
    }

    @NonNull
    @Override
    public CardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mCtx);
        View view = layoutInflater.inflate(R.layout.cards, null);
        return new CardsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardsViewHolder holder, int position) {
        Cards cards = cardsList.get(position);

        constraintLayout.setMinWidth((mCtx.getResources().getDisplayMetrics().widthPixels)-2);

        holder.tankID.setText(cards.getTankID());
        holder.address.setText(cards.getAddress());
        holder.status.setText(cards.getStatus());
        holder.levelImage.setImageDrawable(mCtx.getResources().getDrawable(cards.getLevelImage(), null));
    }

    @Override
    public int getItemCount() {
        return cardsList.size();
    }

    class CardsViewHolder extends RecyclerView.ViewHolder {

        ImageView levelImage;
        TextView tankID, address,status;

        public CardsViewHolder(@NonNull View itemView) {
            super(itemView);

            levelImage = itemView.findViewById(R.id.levelImageView);
            tankID = itemView.findViewById(R.id.tankIDTextView);
            address = itemView.findViewById(R.id.addressTextView);
            status = itemView.findViewById(R.id.statusTextView);
            constraintLayout = itemView.findViewById(R.id.constrainedLayout1);
        }
    }
}
