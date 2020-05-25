package com.fhzn.db1.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.LogUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.fhzn.common.activity.MvvmBaseActivity;
import com.fhzn.common.fragment.MvvmBaseFragment;
import com.fhzn.common.fragment.MvvmLazyFragment;
import com.fhzn.common.net.EasyHttp;
import com.fhzn.common.net.callback.SimpleCallBack;
import com.fhzn.common.net.exception.ApiException;
import com.fhzn.common.router.RouterFragmentPath;
import com.fhzn.common.viewmodel.IMvvmBaseViewModel;
import com.fhzn.db1.user.adapter.RecyclerAdapter;
import com.fhzn.db1.user.databinding.UserFragmentLayoutBinding;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.scwang.smart.refresh.header.ClassicsHeader;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-28
 */
@Route(path = RouterFragmentPath.User.PAGER_USER)
public class UserFragment extends MvvmBaseFragment<UserFragmentLayoutBinding, IMvvmBaseViewModel> {

    private RecyclerAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.user_fragment_layout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        List<String> items = new ArrayList<>();
        items.add("我的关注");
        items.add("我的收藏");
        items.add("用户协议");
        items.add("版权声明");
        items.add("关于复泓");
        adapter.setNewData(items);
    }

    private void start(Context context) {
        startActivity(new Intent(context, LoginActivity.class));
    }

    private void initView() {
        Glide.with(getContext()).load(getContext().getDrawable(R.drawable.avatar))
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(viewDataBinding.ivAvatar);
        viewDataBinding.rvTables.setHasFixedSize(true);
        viewDataBinding.rvTables
                .setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecyclerAdapter();
        //adapter.setFooterView(getFooterView());
        viewDataBinding.rvTables.setAdapter(adapter);
        viewDataBinding.ivMore.setOnClickListener(v -> {
            start(getContext());
        });
        viewDataBinding.tvLike.setOnClickListener(v -> {
            getNetData("error");
        });
        viewDataBinding.tvReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNetData(null);
            }
        });
        viewDataBinding.refreshLayout
                .setRefreshHeader(new ClassicsHeader(this.getContext()));
        viewDataBinding.refreshLayout.finishRefresh(true);
        setLoadSir(viewDataBinding.refreshLayout);
    }

    private void getNetData(String tag) {
        showLoading();
        if (tag == null) {
            tag = "https://ap2.fuxiang.site/user/getUserInfo";
        } else {
            tag = "https://ap2.fuxiang.site/user/getUserInfo22";
        }
        Disposable disposable = EasyHttp.post(tag)
                .formatRequest(null)
                .cacheKey(getClass().getSimpleName())
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        LogUtils.e(e.getMessage());
                        //setLoadSir(viewDataBinding.getRoot());
                        showFailure(e.getMessage());
                    }

                    @Override
                    public void onSuccess(String s) {
                        viewDataBinding.tvTip.setText(s);
                        showContent();
                        LogUtils.e(s);
                    }
                });
    }

    private View getFooterView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.user_item_footer_view, viewDataBinding.rvTables, false);
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    protected IMvvmBaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected void onRetryBtnClick() {

    }
}
