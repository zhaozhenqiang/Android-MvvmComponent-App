package com.fhzn.db1.home.daily;

import com.fhzn.common.model.BasePagingModel;
import com.fhzn.common.model.IPagingModelListener;
import com.fhzn.common.viewmodel.MvmBaseViewModel;
import com.fhzn.common.contract.BaseCustomViewModel;

import java.util.ArrayList;

/**
 * 应用模块: daily
 * <p>
 * 类描述:  model 与 ui 控制层
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-14
 */
public class DailyViewModel extends MvmBaseViewModel<IDailyView, DailyModel>
    implements IPagingModelListener<ArrayList<BaseCustomViewModel>>
{
    
    @Override
    public void onLoadFinish(BasePagingModel model,
                             ArrayList<BaseCustomViewModel> data, boolean isEmpty,
                             boolean isFirstPage)
    {
        if (getPageView() != null)
        {
            if (isEmpty)
            {
                if (isFirstPage)
                {
                    getPageView().showEmpty();
                }
                else
                {
                    getPageView().onLoadMoreEmpty();
                }
            }
            else
            {
                getPageView().onDataLoadFinish(data, isFirstPage);
            }
        }
        
    }
    
    @Override
    public void onLoadFail(BasePagingModel model, String prompt,
        boolean isRefresh)
    {
        if (getPageView() != null)
        {
            if (isRefresh)
            {
                getPageView().showFailure(prompt);
            }
            else
            {
                getPageView().onLoadMoreFailure(prompt);
            }
        }
    }
    
    public void tryToRefresh()
    {
        model.refresh();
    }
    
    public void loadMore()
    {
        model.loadMore();
    }
    
    @Override
    protected void initModel()
    {
        model = new DailyModel();
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
