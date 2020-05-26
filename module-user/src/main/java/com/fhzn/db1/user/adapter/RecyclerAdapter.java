package com.fhzn.db1.user.adapter;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.fhzn.common.router.RouterFragmentPath;
import com.fhzn.common.utils.ToastUtil;
import com.fhzn.db1.user.R;
import com.zhpan.idea.utils.ToastUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author jerry
 * @since 2020-02-28
 */
public class RecyclerAdapter extends BaseQuickAdapter<String, BaseViewHolder> implements View.OnClickListener {

    public RecyclerAdapter() {
        super(R.layout.user_item_view_layout);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder, @Nullable String s) {
        baseViewHolder.setText(R.id.tv_item, s);
        baseViewHolder.getView(R.id.tv_item).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == null) {
            return;
        }
        if (v instanceof TextView) {
            String tag = ((TextView) v).getText().toString();
            com.blankj.utilcode.util.ToastUtils.showShort(tag);
            switch (tag) {
                case "我的关注":
                case "我的收藏":
                    ARouter.getInstance().build(RouterFragmentPath.Home.PAGER_HOME_SAMPLE).navigation();
                    break;
                default:
                    ToastUtil t;
                    ToastUtils ts1;
                    com.blankj.utilcode.util.ToastUtils ts2;
            }
        }
    }
}
