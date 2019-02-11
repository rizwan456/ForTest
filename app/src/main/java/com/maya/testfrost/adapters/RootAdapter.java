package com.maya.testfrost.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.maya.testfrost.R;
import com.maya.testfrost.interfaces.adapters.IRootAdapter;
import com.maya.testfrost.models.Tree;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Gokul Kalagara (Mr.Psycho) on 11/02/19.
 */

public class RootAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{


    List<Tree> treeList;
    Context context;
    IRootAdapter iRootAdapter;
    RootAdapter rootAdapter;

    public RootAdapter(List<Tree> treeList, Context context, IRootAdapter iRootAdapter)
    {
        this.treeList = treeList;
        this.context = context;
        this.iRootAdapter = iRootAdapter;
    }

    public RootAdapter(List<Tree> treeList, Context context) {
        this.treeList = treeList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MenuViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.options_layout,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        if(holder instanceof MenuViewHolder)
        {
            MenuViewHolder menuViewHolder = (MenuViewHolder) holder;

            menuViewHolder.tvName.setText(treeList.get(position).name);

            menuViewHolder.itemView.setOnClickListener(v ->
            {
                if(treeList.get(position).list!=null)
                {
                    if(iRootAdapter!=null)
                    iRootAdapter.changeView(treeList.get(position),position);
                    else
                    {
                        if(treeList.get(position).list!=null)
                        {
                            treeList.get(position).isOpen = treeList.get(position).isOpen ? false : true;
                            menuViewHolder.recyclerView.setVisibility(treeList.get(position).isOpen?View.VISIBLE:View.GONE);
                        }
                    }
                }
                else
                {
                }
            });

            if(treeList.get(position).list==null)
            {
                menuViewHolder.recyclerView.setVisibility(View.GONE);
            }
            else
            {
                menuViewHolder.recyclerView.setVisibility(View.VISIBLE);
                menuViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
                menuViewHolder.recyclerView.setAdapter(rootAdapter = new RootAdapter(treeList.get(position).list,context));
            }

            menuViewHolder.imgHead.setBackgroundColor(Color.parseColor(treeList.get(position).list==null?"#FFFFFF":"#909090"));
            menuViewHolder.recyclerView.setVisibility(treeList.get(position).isOpen?View.VISIBLE:View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return treeList.size();
    }



    public class MenuViewHolder extends RecyclerView.ViewHolder
    {

        @BindView(R.id.imgHead)
        ImageView imgHead;

        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.recyclerView)
        RecyclerView recyclerView;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
