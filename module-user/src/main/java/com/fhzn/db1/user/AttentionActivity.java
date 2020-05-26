package com.fhzn.db1.user;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fhzn.common.base.activity.MvvmBaseActivity;
import com.fhzn.common.router.RouterActivityPath;
import com.fhzn.common.base.viewmodel.IMvvmBaseViewModel;
import com.fhzn.db1.user.databinding.UserActivityLoginBinding;

/**
 * 应用模块:
 * <p>
 * 类描述: 关注页面
 * <p>
 *
 * @author jerry
 * @since 2020-02-29
 */
@Route(path = RouterActivityPath.User.PAGER_ATTENTION)
public class AttentionActivity extends MvvmBaseActivity<UserActivityLoginBinding, IMvvmBaseViewModel> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected IMvvmBaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected int getBindingVariable() {
        return 0;
    }

    @Override
    protected void onRetryBtnClick() {

    }
    @Override
    protected int getLayoutId() {
        return R.layout.user_activity_attention;
    }

}
