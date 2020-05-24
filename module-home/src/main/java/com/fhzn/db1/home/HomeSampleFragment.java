package com.fhzn.db1.home;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.fhzn.common.fragment.MvvmBaseFragment;
import com.fhzn.common.net.EasyHttp;
import com.fhzn.common.net.callback.SimpleCallBack;
import com.fhzn.common.net.exception.ApiException;
import com.fhzn.common.router.RouterActivityPath;
import com.fhzn.common.router.RouterFragmentPath;
import com.fhzn.common.viewmodel.IMvvmBaseViewModel;
import com.fhzn.db1.home.databinding.HomeFragmentSampleBinding;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * reated by zhaozq on 2020/5/22.
 */
@Route(path = RouterFragmentPath.Home.PAGER_HOME_SAMPLE)
public class HomeSampleFragment extends MvvmBaseFragment<HomeFragmentSampleBinding, IMvvmBaseViewModel> {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewDataBinding.tvGetHomeTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoading();
                HashMap<String, String> map = new HashMap<>();
                map.put("issueId", "99");
                map.put("content", "test 99");
                Disposable disposable = EasyHttp.post("https://ap2.fuxiang.site/issueComment/add")
                        .formatRequest(map)
                        .cacheKey(getClass().getSimpleName())
                        .execute(new SimpleCallBack<String>() {
                            @Override
                            public void onError(ApiException e) {
                                LogUtils.e(e.getMessage());
                                showFailure(e.getMessage());
                            }

                            @Override
                            public void onSuccess(String s) {
                                LogUtils.e(s);
                                viewDataBinding.tvShow.setText(s);
                                showContent();
                            }
                        });
            }
        });
        viewDataBinding.tvLoginTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(RouterActivityPath.User.PAGER_LOGIN).navigation();
            }
        });
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
    protected IMvvmBaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected void onRetryBtnClick() {

    }
}
