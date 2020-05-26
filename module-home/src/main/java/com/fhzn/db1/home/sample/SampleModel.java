package com.fhzn.db1.home.sample;

import com.blankj.utilcode.util.LogUtils;
import com.fhzn.common.base.model.BasePagingModel;
import com.fhzn.common.http.EasyHttp;
import com.fhzn.common.http.callback.SimpleCallBack;
import com.fhzn.common.http.exception.ApiException;
import com.fhzn.common.utils.GsonUtils;
import com.fhzn.db1.home.sample.bean.SampleBean;
import com.fhzn.db1.home.sample.bean.SampleWrapper;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.disposables.Disposable;

/**
 * 应用模块: daily
 * <p>
 * 类描述: 数据处理层
 * <p>
 *
 * @author jerry
 * @since 2020-02-14
 */
public class SampleModel<T> extends BasePagingModel<T> {

    private Disposable mDisposableData;

    @Override
    protected void load() {
        mDisposableData = EasyHttp.post("https://ap2.fuxiang.site/issueComment/getAll")
                .formatRequest(null)
                .cacheKey(getClass().getSimpleName())
                .execute(new SimpleCallBack<String>() {
                    @Override
                    public void onError(ApiException e) {
                        LogUtils.e(e.getMessage());
                        loadFail(e.getMessage(), isRefresh);
                    }

                    @Override
                    public void onSuccess(String s) {
                        LogUtils.e(s);
                        parseJson(s);
                    }
                });
    }

    public Disposable addData(SimpleCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("issueId", "99");
        map.put("content", "test 99" + map.toString());
        return EasyHttp.post("https://ap2.fuxiang.site/issueComment/add")
                .formatRequest(map)
                .cacheKey(getClass().getSimpleName())
                .execute(callBack);
    }

    @Override
    public void cancel() {
        super.cancel();
        EasyHttp.cancelSubscription(mDisposableData);
    }

    public void loadMore(String nextPageUrl) {
        load();
    }

    public void refresh() {
        isRefresh = true;
        load();
    }

    public void loadMore() {
        isRefresh = false;
        loadMore(nextPageUrl);
/*        if (!TextUtils.isEmpty(nextPageUrl)) {
            loadMore(nextPageUrl);
        } else {
            loadSuccess(null, true, isRefresh);
        }*/
    }

    /**
     * 解析json 数据
     *
     * @param s json字符串
     */
    private void parseJson(String s) {
        SampleWrapper response = GsonUtils.fromLocalJson(s, SampleWrapper.class);
        if (response == null || response.getResult() == null || response.getResult().size() == 0) {
            loadSuccess(null, false, isRefresh);
        } else {
            ArrayList<SampleBean> mList = response.getResult();
            loadSuccess((T) mList, false, isRefresh);
        }
    }
}
