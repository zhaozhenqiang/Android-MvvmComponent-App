package com.fhzn.db1.user.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.fhzn.db1.user.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-28
 */
public class RecyclerAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public RecyclerAdapter() {
        super(R.layout.user_item_view_layout);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, @Nullable String s) {
          baseViewHolder.setText(R.id.tv_item,s);
    }
}
