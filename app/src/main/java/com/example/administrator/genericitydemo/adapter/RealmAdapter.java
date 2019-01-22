package com.example.administrator.genericitydemo.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.genericitydemo.R;
import com.example.administrator.genericitydemo.bean.User;

/**
 * Created by jian.shui on 2019/1/22
 */
public class RealmAdapter extends BaseQuickAdapter<User,BaseViewHolder> {
    public RealmAdapter() {
        super(R.layout.item_realm, null);
    }

    @Override
    protected void convert(BaseViewHolder holder, User item) {
        TextView tv_id=holder.getView(R.id.tv_id);
        TextView tv_username=holder.getView(R.id.tv_user_name);
        TextView tv_dogs=holder.getView(R.id.tv_dogs);
        tv_id.setText(item.getId());
        tv_username.setText(item.getUsername());
        tv_dogs.setText(item.getDogs().get(0).getNick()+","+item.getDogs().get(1).getNick());
    }
}
