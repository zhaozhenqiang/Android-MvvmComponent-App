package com.drz.main.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.drz.main.R;
import com.drz.main.adapter.MainPageAdapter;
import com.drz.main.databinding.MainActivityMainBinding;
import com.drz.main.databinding.MainActivityTestBinding;
import com.drz.main.utils.ColorUtils;
import com.fhzn.common.activity.MvvmBaseActivity;
import com.fhzn.common.adapter.ScreenAutoAdapter;
import com.fhzn.common.net.EasyHttp;
import com.fhzn.common.net.callback.SimpleCallBack;
import com.fhzn.common.net.exception.ApiException;
import com.fhzn.common.router.RouterActivityPath;
import com.fhzn.common.router.RouterFragmentPath;
import com.fhzn.common.storage.MmkvHelper;
import com.fhzn.common.viewmodel.IMvvmBaseViewModel;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;
import me.majiajie.pagerbottomtabstrip.NavigationController;

/**
 * app 主页面
 *
 * @author darryrzhoong
 */

@Route(path = RouterActivityPath.Main.PAGER_TEST)
public class TestActivity
        extends MvvmBaseActivity<MainActivityTestBinding, IMvvmBaseViewModel> {

    @Override
    protected IMvvmBaseViewModel getViewModel() {
        return null;
    }


    public static void start(Context context) {
        MmkvHelper.getInstance().getMmkv().encode("first", false);
        context.startActivity(new Intent(context, TestActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ScreenAutoAdapter.match(this, 375.0f);
        super.onCreate(savedInstanceState);
        ImmersionBar.with(this)
                .statusBarColor(R.color.main_color_bar)
                .navigationBarColor(R.color.main_color_bar)
                .fitsSystemWindows(true)
                .autoDarkModeEnable(true)
                .init();
        initView();
        viewDataBinding.tvOldTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disposable disposable = EasyHttp.post("https://ap2.fuxiang.site/issue/getMainPageData")
                        .cacheKey(getClass().getSimpleName())
                        .execute(new SimpleCallBack<String>() {
                            @Override
                            public void onError(ApiException e) {
                                LogUtils.e(e.getMessage());
                            }

                            @Override
                            public void onSuccess(String s) {
                                LogUtils.e(s);
                            }
                        });
            }
        });
        viewDataBinding.tvLoginTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disposable disposable = EasyHttp.post("https://ap2.fuxiang.site/mpapp/login2")
                        //.params("code", "591")
                        //.params("nickName", "first_try")
                        //.params("avatarUrl", "111111111111111")
                        .params("username", "wangdongfeng")
                        .params("password", "123456")
                        .removeAllHeaders()
                        .headers("Content-Type",  "application/json")
                        .cacheKey("https://ap2.fuxiang.site/mpapp/login2")
                        .execute(new SimpleCallBack<String>() {
                            @Override
                            public void onError(ApiException e) {
                                LogUtils.e(e.getMessage());
                            }

                            @Override
                            public void onSuccess(String s) {
                                LogUtils.e(s);
                            }
                        });
/*                Disposable disposable =
                        EasyHttp.post("https://ap2.fuxiang.site").addFileParams()
                                .cacheKey(getClass().getSimpleName())
                                .execute(new SimpleCallBack<String>() {
                                    @Override
                                    public void onError(ApiException e) {
                                        //loadFail(e.getMessage(), isRefresh);
                                        LogUtils.e(e.getMessage());
                                    }

                                    @Override
                                    public void onSuccess(String s) {
                                        // parseJson(s);
                                        LogUtils.e(s);
                                    }
                                });*/
            }
        });

    }

    private void initView() {
    }


    @Override
    protected int getBindingVariable() {
        return 0;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity_test;
    }

    @Override
    protected void onRetryBtnClick() {

    }
}
