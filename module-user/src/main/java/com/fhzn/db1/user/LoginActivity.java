package com.fhzn.db1.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.fhzn.common.contract.UserInfo;
import com.fhzn.common.net.EasyHttp;
import com.fhzn.common.net.callback.SimpleCallBack;
import com.fhzn.common.net.exception.ApiException;
import com.fhzn.common.storage.MmkvHelper;
import com.fhzn.common.utils.GsonUtils;
import com.fhzn.common.utils.ToastUtil;
import com.fhzn.db1.user.R;
import com.fhzn.common.router.RouterActivityPath;
import com.fhzn.common.services.ILoginService;
import com.fhzn.common.services.config.ServicesConfig;
import com.fhzn.db1.user.bean.LoginResponse;
import com.fhzn.db1.user.databinding.UserActivityLoginBinding;

import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * @author darryrzhoong
 */
@Route(path = RouterActivityPath.User.PAGER_LOGIN)
public class LoginActivity extends AppCompatActivity {

    private UserActivityLoginBinding binding;
    private AnimatorSet animatorSet;

    @Autowired(name = ServicesConfig.User.LONGING_SERVICE)
    ILoginService iLoginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        binding = DataBindingUtil.setContentView(this, R.layout.user_activity_login);
        initView();
        initData();
    }

    private void initData() {
        //模拟登录
        iLoginService.saveStatus(false);
    }

    private void initView() {
        binding.btLogin.setOnClickListener(new View.OnClickListener() {
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
                                ToastUtil.show(LoginActivity.this, e.getMessage());
                            }

                            @Override
                            public void onSuccess(String s) {
                                parseData(s);
                            }
                        });
            }
        });
    }

    private void parseData(String s) {
        LoginResponse response = GsonUtils.fromLocalJson(s, LoginResponse.class);
        if (response != null && response.getResult() != null) {
            LoginResponse.ResultBean user = response.getResult();
            ToastUtil.show(LoginActivity.this, "success");
            MmkvHelper.getInstance().getMmkv().encode("token", user.getToken());
            finish();
        } else {
            ToastUtil.show(LoginActivity.this, "serve error, for a moment try");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
