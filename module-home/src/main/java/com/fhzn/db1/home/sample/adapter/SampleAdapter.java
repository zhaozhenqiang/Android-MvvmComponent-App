package com.fhzn.db1.home.sample.adapter;

import androidx.databinding.DataBindingUtil;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.fhzn.db1.home.databinding.HomeItemSampleTitleBinding;
import com.fhzn.db1.home.sample.bean.SampleBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * reated by zhaozq on 2020/5/25.
 */
public class SampleAdapter extends BaseQuickAdapter<SampleBean, BaseViewHolder> {

    public SampleAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void onItemViewHolderCreated(@NotNull BaseViewHolder viewHolder,
                                           int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder,
                           @Nullable SampleBean bean) {
        if (bean == null) {
            return;
        }
        HomeItemSampleTitleBinding binding =
                baseViewHolder.getBinding();
        if (binding != null) {
            binding.setViewModel(bean);
            binding.executePendingBindings();
        }
    }
}
