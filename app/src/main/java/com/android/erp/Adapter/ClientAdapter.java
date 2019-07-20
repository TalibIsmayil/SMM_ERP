package com.android.erp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.erp.HomeActivity;
import com.android.erp.Network.Response.ClientResponse;
import com.android.erp.R;

import java.util.List;

public class ClientAdapter extends RecyclerView.Adapter<ClientAdapter.ClientHolder> {

    private Context context;
    private List<ClientResponse> list;

    public ClientAdapter(Context context, List<ClientResponse> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ClientHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_clients,viewGroup,false);
        return new ClientHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientHolder clientHolder, int i) {
        Typeface avenir_book = Typeface.createFromAsset(context.getAssets(),"fonts/AvenirBook.ttf");
        clientHolder.textView.setText(list.get(i).getUsername());
        clientHolder.textView.setTypeface(avenir_book);
        clientHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeActivity.class);
                intent.putExtra("userId",list.get(i).getUserId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ClientHolder extends RecyclerView.ViewHolder{

        private TextView textView;

        public ClientHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.client_title);
        }
    }
}