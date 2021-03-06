package com.fhzn.db1.main.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ColorUtils;
import com.fhzn.common.base.activity.MvvmBaseActivity;
import com.fhzn.common.adapter.ScreenAutoAdapter;
import com.fhzn.common.constant.Constant;
import com.fhzn.common.router.RouterActivityPath;
import com.fhzn.common.router.RouterFragmentPath;
import com.fhzn.common.storage.MmkvHelper;
import com.fhzn.common.base.viewmodel.IMvvmBaseViewModel;
import com.fhzn.db1.main.R;
import com.fhzn.db1.main.adapter.MainPageAdapter;
import com.fhzn.db1.main.databinding.MainActivityMainBinding;
import com.gyf.immersionbar.ImmersionBar;

import java.util.ArrayList;
import java.util.List;

import me.majiajie.pagerbottomtabstrip.NavigationController;

import static com.fhzn.common.constant.Constant.FLAG_FIRST;

/**
 * app 主页面
 *
 * @author jerry
 */

@Route(path = RouterActivityPath.Main.PAGER_MAIN)
public class MainActivity extends MvvmBaseActivity<MainActivityMainBinding, IMvvmBaseViewModel> {

    private List<Fragment> fragments;

    private MainPageAdapter adapter;

    private NavigationController mNavigationController;

    @Override
    protected IMvvmBaseViewModel getViewModel() {
        return null;
    }


    public static void start(Context context) {
        MmkvHelper.getInstance().getMmkv().encode(FLAG_FIRST, false);
        context.startActivity(new Intent(context, MainActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ScreenAutoAdapter.match(this, Constant.DEFAULT_SIZE);
        super.onCreate(savedInstanceState);
        ImmersionBar.with(this)
                .statusBarColor(R.color.main_color_bar)
                .navigationBarColor(R.color.main_color_bar)
                .fitsSystemWindows(true)
                .autoDarkModeEnable(true)
                .init();
        initView();
        initFragment();

    }

    private void initView() {
        mNavigationController = viewDataBinding.bottomView.material()
                .addItem(R.drawable.main_home,
                        "首页",
                        ColorUtils.getColor(R.color.main_bottom_check_color))
                .addItem(R.drawable.main_user,
                        "我的",
                        ColorUtils.getColor(R.color.main_bottom_check_color))
                .setDefaultColor(
                        ColorUtils.getColor(R.color.main_bottom_default_color))
                .build();
        mNavigationController.setHasMessage(0, false);
        mNavigationController.setMessageNumber(1, 6);
        adapter = new MainPageAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT);
        viewDataBinding.cvContentView.setOffscreenPageLimit(1);
        viewDataBinding.cvContentView.setAdapter(adapter);
        mNavigationController.setupWithViewPager(viewDataBinding.cvContentView);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        //通过ARouter 获取其他组件提供的fragment
        Fragment homeFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.Home.PAGER_HOME_SAMPLE).navigation();
        Fragment userFragment = (Fragment) ARouter.getInstance().build(RouterFragmentPath.User.PAGER_USER).navigation();
        fragments.add(homeFragment);
        fragments.add(userFragment);
        adapter.setData(fragments);
    }

    @Override
    protected int getBindingVariable() {
        return 0;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.main_activity_main;
    }

    @Override
    protected void onRetryBtnClick() {

    }
}
