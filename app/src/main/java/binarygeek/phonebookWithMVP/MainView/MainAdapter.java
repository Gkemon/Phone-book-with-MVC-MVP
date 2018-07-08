package binarygeek.phonebookWithMVP.MainView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import binarygeek.phonebookWithMVP.BaseRecyclerClickListener;
import binarygeek.phonebookWithMVP.R;

/**
 * Created by uy on 7/6/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder>{
    public MainAdapter(List<String> items) {
        this.items = items;
    }

    private List<String> items;
    private BaseRecyclerClickListener baseRecyclerClickListener;




    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //get an error "java.lang.ClassCastException: android.widget.LinearLayout cannot be cast to android.widget.Button" in here when i used button instead of view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.items, parent, false);

        return new MainViewHolder(v);
    }

    public void setOnItemClickListener(BaseRecyclerClickListener recyclerItemClickListener) {
        this.baseRecyclerClickListener = recyclerItemClickListener;

    }

    @Override
    public void onBindViewHolder(@NonNull final MainViewHolder holder,  int position) {
        final String item = items.get(position);
        holder.divisionName.setText(item);

        holder.divisionName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("GK","CLICK");
                if (holder.getAdapterPosition() != RecyclerView.NO_POSITION) {
                    if (baseRecyclerClickListener != null) {
                        Log.d("GK","baseRecyclerClickListener != null");
                        baseRecyclerClickListener.onItemClick(holder.getAdapterPosition(), holder.itemView);
                    }
                    else Log.d("GK","baseRecyclerClickListener == null");
                }
                else Log.d("GK","NO POSITION");
            }


        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public String getItem(int position){
        return items.get(position);
    }
    public List<String> getItems(){
        return items;
    }

    static class MainViewHolder extends RecyclerView.ViewHolder {

        Button divisionName;

        MainViewHolder(View divisionName ) {
            super(divisionName);
            this.divisionName = divisionName.findViewById(R.id.item_button);

        }
    }
}
