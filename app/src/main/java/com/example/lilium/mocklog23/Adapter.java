package com.example.lilium.mocklog23;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//public class Adapter extends RecyclerView.Adapter<Adapter.Usviewholder>{
public class Adapter extends RecyclerView.Adapter<Adapter.Usviewholder>{
    public Adapter(List<Member> names) {
        this.names = names;
    }


    List<Member> names;


    @Override
    public Usviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowrecycler,parent,false);
        Usviewholder holder = new Usviewholder(v);
        return  holder;
    }

    @Override
    public void onBindViewHolder(Usviewholder holder, int position) {
        Member name = names.get(position);
        holder.tvname.setText(name.getName());
        holder.tvpass.setText(name.getPassword());
    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    public static class Usviewholder extends RecyclerView.ViewHolder{

        TextView tvname,tvpass;


        public Usviewholder( View itemView) {
            super(itemView);
            tvname = itemView.findViewById(R.id.textview_name);
            tvpass = itemView.findViewById(R.id.textview_pass);

        }
    }
}
