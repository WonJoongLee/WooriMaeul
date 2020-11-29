package com.example.woorimaeul;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.woorimaeul.upload.ViewBoard;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<BoardList> arrayList;
    private Context context;
    private String title, content, userName;

    public CustomAdapter(ArrayList<BoardList> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_bord, parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.tv_title.setText(arrayList.get(position).getTitle());
        holder.tv_username.setText(arrayList.get(position).getName());

        //content = arrayList.get(position).getArticle();
        //title = arrayList.get(position).getTitle();
        //userName = arrayList.get(position).getName();


    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        TextView tv_username;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_title=itemView.findViewById(R.id.board_title);
            this.tv_username = itemView.findViewById(R.id.username);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();

                    BoardList item = arrayList.get(pos);

                    title = item.getTitle();
                    content = item.getArticle();
                    userName = item.getName();

                    Intent intent = new Intent(v.getContext(), ViewBoard.class);
                    intent.putExtra("title", title);
                    intent.putExtra("content", content);
                    intent.putExtra("writer", userName);
                    context.startActivity(intent);
                }
            });
        }
    }
}
