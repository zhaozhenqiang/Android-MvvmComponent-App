package com.fhzn.db1.home;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.fhzn.db1.home.R;
import com.fhzn.db1.home.databinding.HomeFragmentSampleBinding;
import com.fhzn.common.fragment.MvvmBaseFragment;
import com.fhzn.common.router.RouterFragmentPath;
import com.fhzn.common.viewmodel.IMvvmBaseViewModel;

/**
 * reated by zhaozq on 2020/5/22.
 */
@Route(path = RouterFragmentPath.Home.PAGER_HOME_SAMPLE)
public class HomeSampleFragment  extends MvvmBaseFragment<HomeFragmentSampleBinding, IMvvmBaseViewModel> {
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
