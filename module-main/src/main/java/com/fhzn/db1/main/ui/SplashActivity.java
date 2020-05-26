package com.fhzn.db1.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.fhzn.common.adapter.ScreenAutoAdapter;
import com.fhzn.common.router.RouterActivityPath;
import com.fhzn.common.storage.MmkvHelper;
import com.fhzn.db1.main.R;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;

/**
 * 应用模块: 主业务模块
 * <p>
 * 类描述: 欢迎页面
 * <p>
 *
 * @author jerry
 * @since 2020-02-26
 */
public class SplashActivity extends AppCompatActivity {

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenAutoAdapter.match(this, 375.0f);
        setContentView(R.layout.main_activity_splash);
        ImmersionBar.with(this)
                .titleBar(findViewById(R.id.top_view))
                .hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR)
                .init();
        mHandler.postDelayed(this::startToMain, 200);
    }

    private void startToMain() {
        if (MmkvHelper.getInstance().getMmkv().decodeBool("first", true)) {
            //startActivity(new Intent(this, GuideActivity.class));
            ARouter.getInstance().build(RouterActivityPath.Main.PAGER_MAIN).navigation();
        } else {
            ARouter.getInstance().build(RouterActivityPath.Main.PAGER_MAIN).navigation();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //activity销毁时移除所有消息,防止内存泄漏
        mHandler.removeCallbacksAndMessages(null);
    }
}
