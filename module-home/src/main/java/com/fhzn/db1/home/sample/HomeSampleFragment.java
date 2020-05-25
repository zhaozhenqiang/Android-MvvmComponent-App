package com.fhzn.db1.home.sample;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.fhzn.common.contract.BaseCustomViewModel;
import com.fhzn.common.fragment.MvvmBaseFragment;
import com.fhzn.common.net.EasyHttp;
import com.fhzn.common.net.callback.SimpleCallBack;
import com.fhzn.common.net.exception.ApiException;
import com.fhzn.common.router.RouterActivityPath;
import com.fhzn.common.router.RouterFragmentPath;
import com.fhzn.common.viewmodel.IMvvmBaseViewModel;
import com.fhzn.db1.home.R;
import com.fhzn.db1.home.daily.adapter.ProviderDailyAdapter;
import com.fhzn.db1.home.databinding.HomeFragmentSampleBinding;
import com.fhzn.db1.home.sample.adapter.SampleAdapter;
import com.fhzn.db1.home.sample.bean.SampleBean;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * reated by zhaozq on 2020/5/22.
 */
@Route(path = RouterFragmentPath.Home.PAGER_HOME_SAMPLE)
public class HomeSampleFragment extends MvvmBaseFragment<HomeFragmentSampleBinding, SampleViewModel> implements ISampleView {
    SampleAdapter mAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewDataBinding.tvAddHomeTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDate();
            }
        });
        viewDataBinding.tvGetHomeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAllData();
            }
        });
        viewDataBinding.tvLoginTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(RouterActivityPath.User.PAGER_LOGIN).navigation();
            }
        });
        viewDataBinding.rvSampleContent
                .setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new SampleAdapter(R.layout.home_item_sample_title);
        viewDataBinding.rvSampleContent.setAdapter(mAdapter);
        viewDataBinding.sflSample
                .setRefreshHeader(new ClassicsHeader(getContext()));
        viewDataBinding.sflSample.setEnableLoadMore(true);
        viewDataBinding.sflSample
                .setRefreshFooter(new ClassicsFooter(getContext()));
        viewDataBinding.sflSample.setOnRefreshListener(refreshLayout -> {
            viewModel.tryToRefresh();
        });
        viewDataBinding.sflSample.setOnLoadMoreListener(refreshLayout -> {
            viewModel.loadMore();
        });
        setLoadSir(viewDataBinding.sflSample);
        showLoading();
        viewModel.initModel();
    }

    private void getAllData() {
        showLoading();
        viewModel.loadMore();
    }

    private void addDate() {
        // TODO: 2020/5/25 显示对话框的加载中
        //showLoading();
        viewModel.addData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_fragment_sample;
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    protected SampleViewModel getViewModel() {
        return ViewModelProviders.of(this).get(SampleViewModel.class);
    }

    @Override
    protected void onRetryBtnClick() {

    }

    @Override
    public void onDataLoadFinish(ArrayList<SampleBean> beans, boolean isFirstPage) {
        if (isFirstPage) {
            mAdapter.setNewData(beans);
            showContent();
            viewDataBinding.sflSample.finishRefresh(true);
        } else {
            mAdapter.addData(beans);
            showContent();
            viewDataBinding.sflSample.finishLoadMore(true);
        }
    }

    @Override
    public void onDataAddFinish(String message) {
        viewDataBinding.tvShow.setText(message);
    }

    @Override
    public void onLoadMoreFailure(String message) {
        viewDataBinding.sflSample.finishLoadMore(false);
    }

    @Override
    public void onLoadMoreEmpty() {
        viewDataBinding.sflSample.finishLoadMoreWithNoMoreData();
    }
}
