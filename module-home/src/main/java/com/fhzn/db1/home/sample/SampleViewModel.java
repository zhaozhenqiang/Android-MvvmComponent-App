package com.fhzn.db1.home.sample;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.fhzn.common.contract.BaseCustomViewModel;
import com.fhzn.common.model.BasePagingModel;
import com.fhzn.common.model.IPagingModelListener;
import com.fhzn.common.net.callback.SimpleCallBack;
import com.fhzn.common.net.exception.ApiException;
import com.fhzn.common.utils.GsonUtils;
import com.fhzn.common.viewmodel.MvmBaseViewModel;
import com.fhzn.db1.home.daily.DailyModel;
import com.fhzn.db1.home.daily.IDailyView;
import com.fhzn.db1.home.sample.bean.AddResponse;
import com.fhzn.db1.home.sample.bean.SampleBean;
import com.fhzn.db1.home.sample.bean.SampleWrapper;

import java.util.ArrayList;

/**
 * 应用模块: sample
 * <p>
 * 类描述:  model 与 ui 控制层
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-14
 */
public class SampleViewModel extends MvmBaseViewModel<ISampleView, SampleModel>
        implements IPagingModelListener<ArrayList<SampleBean>> {

    @Override
    public void onLoadFinish(BasePagingModel model,
                             ArrayList<SampleBean> data, boolean isEmpty,
                             boolean isFirstPage) {
        if (getPageView() != null) {
            if (isEmpty) {
                if (isFirstPage) {
                    getPageView().showEmpty();
                } else {
                    getPageView().onLoadMoreEmpty();
                }
            } else {
                getPageView().onDataLoadFinish(data, isFirstPage);
            }
        }
    }

    @Override
    public void onLoadFail(BasePagingModel model, String prompt,
                           boolean isRefresh) {
        if (getPageView() != null) {
            if (isRefresh) {
                getPageView().showFailure(prompt);
            } else {
                getPageView().onLoadMoreFailure(prompt);
            }
        }
    }

    public void tryToRefresh() {
        model.refresh();
    }

    public void loadMore() {
        model.loadMore();
    }

    public void addData() {
        model.addData(new SimpleCallBack<String>() {
            @Override
            public void onError(ApiException e) {
                LogUtils.e(e.getMessage());
                ToastUtils.showShort(e.getMessage());
            }

            @Override
            public void onSuccess(String s) {
                LogUtils.e(s);
                parseAdd(s);
            }
        });
    }

    private void parseAdd(String s) {
        AddResponse response = GsonUtils.fromLocalJson(s, AddResponse.class);
        if (response == null || response.getResult() == null) {
            ToastUtils.showShort("sever err ,data is null");
        } else {
            getPageView().onDataAddFinish(response.getMessage() + response.getResult().getId());
        }
    }

    @Override
    protected void initModel() {
        model = new SampleModel();
        model.register(this);
        model.getCacheDataAndLoad();
    }

    @Override
    public void detachUi() {
        super.detachUi();
        if (model != null) {
            model.unRegister(this);
        }
    }
}
