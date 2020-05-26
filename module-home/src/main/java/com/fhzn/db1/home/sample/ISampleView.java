package com.fhzn.db1.home.sample;

import com.fhzn.common.base.activity.IBasePagingView;
import com.fhzn.db1.home.sample.bean.SampleBean;

import java.util.ArrayList;


/**
 * 应用模块: sample
 * <p>
 * 类描述: UI 更新
 * <p>
 *
 * @author jerry
 * @since 2020-02-14
 */
public interface ISampleView extends IBasePagingView {

    /**
     * 数据加载完成
     *
     */
    void onDataLoadFinish(ArrayList<SampleBean> beans, boolean isFirstPage);

    void onDataAddFinish(String message);
}
