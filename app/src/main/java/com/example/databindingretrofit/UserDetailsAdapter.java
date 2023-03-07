package com.example.databindingretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databindingretrofit.databinding.ItemLayoutBinding;

import java.util.List;

public class UserDetailsAdapter extends RecyclerView.Adapter<UserDetailsAdapter.UserViewHolder> {

    Context context;
    List<UserDetails> list;

    public UserDetailsAdapter(List<UserDetails> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLayoutBinding itemLayoutBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_layout, parent, false);
        return new UserViewHolder(itemLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserDetailsAdapter.UserViewHolder holder, int position) {

        UserDetails userDetails = list.get(position);
        holder.itemLayoutBinding.setModel(userDetails);
    }


    public void setList(List<UserDetails> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    public  UserDetails getList(int position){
        return list.get(position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        ItemLayoutBinding itemLayoutBinding;
        public UserViewHolder(@NonNull ItemLayoutBinding itemLayoutBinding) {
            super(itemLayoutBinding.getRoot());
            this.itemLayoutBinding = itemLayoutBinding;
        }
    }
}
