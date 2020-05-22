package com.fhzn.db1.home.discover;

import com.fhzn.common.activity.IBaseView;
import com.fhzn.common.contract.BaseCustomViewModel;

import java.util.ArrayList;


/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-15
 */
public interface IDisCoverView extends IBaseView
{
    
    /**
     * 数据加载完成
     *
     * @param viewModels data
     */
    void onDataLoadFinish(ArrayList<BaseCustomViewModel> viewModels,
                          boolean isEmpty);
    
}
