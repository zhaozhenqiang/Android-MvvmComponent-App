package com.fhzn.db1.main.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.LogUtils;
import com.fhzn.db1.main.R;
import com.fhzn.db1.main.bean.LoginResponse;
import com.fhzn.db1.main.databinding.MainActivityTestBinding;
import com.fhzn.common.activity.MvvmBaseActivity;
import com.fhzn.common.adapter.ScreenAutoAdapter;
import com.fhzn.common.net.EasyHttp;
import com.fhzn.common.net.callback.SimpleCallBack;
import com.fhzn.common.net.exception.ApiException;
import com.fhzn.common.router.RouterActivityPath;
import com.fhzn.common.storage.MmkvHelper;
import com.fhzn.common.utils.GsonUtils;
import com.fhzn.common.viewmodel.IMvvmBaseViewModel;
import com.gyf.immersionbar.ImmersionBar;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * app 主页面
 *
 * @author darryrzhoong
 */

@Route(path = RouterActivityPath.Main.PAGER_TEST)
public class TestActivity
        extends MvvmBaseActivity<MainActivityTestBinding, IMvvmBaseViewModel> {

    LoginResponse.ResultBean mUserInfo = new LoginResponse.ResultBean();

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
        viewDataBinding.tvGetUserTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disposable disposable = EasyHttp.post("https://ap2.fuxiang.site/user/getUserInfo")
                        .formatRequest(null)
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

        viewDataBinding.tvGetHomeTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> map = new HashMap<>();
                map.put("issueId", "99");
                map.put("content", "test 99");

                Disposable disposable = EasyHttp.post("https://ap2.fuxiang.site/issueComment/add")
                        //.upJson(GsonUtils.toJson(map))
                        .formatRequest(map)
                        /*.upJson(GsonUtils.toJson(map))
                        .headers("Authorization", "Bearer " + mUserInfo.getToken())*/
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
                HashMap<String, String> map = new HashMap<>();
                map.put("username", "wangdongfeng");
                map.put("password", "123456");
                Disposable disposable = EasyHttp.post("https://ap2.fuxiang.site/mpapp/login2")
                        .upJson(GsonUtils.toJson(map))
                        .cacheKey("https://ap2.fuxiang.site/mpapp/login2")
                        .execute(new SimpleCallBack<String>() {
                            @Override
                            public void onError(ApiException e) {
                                LogUtils.e(e.getMessage());
                            }

                            @Override
                            public void onSuccess(String s) {
                                parseData(s);
                                LogUtils.e(s);
                            }
                        });
            }
        });
    }

    private void parseData(String s) {
        LoginResponse response = GsonUtils.fromLocalJson(s, LoginResponse.class);
        if (response != null) {
            mUserInfo = response.getResult();
            MmkvHelper.getInstance().getMmkv().encode("token", mUserInfo.getToken());
        }
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
