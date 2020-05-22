package com.fhzn.db1.home.discover;

import java.util.ArrayList;

import com.fhzn.common.model.BaseModel;
import com.fhzn.common.model.IModelListener;
import com.fhzn.common.viewmodel.MvmBaseViewModel;
import com.fhzn.common.contract.BaseCustomViewModel;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-15
 */
public class DisCoverViewModel
    extends MvmBaseViewModel<IDisCoverView, DisCoverModel>
    implements IModelListener<ArrayList<BaseCustomViewModel>>
{
    
    @Override
    public void onLoadFinish(BaseModel model,
                             ArrayList<BaseCustomViewModel> data)
    {
        if (getPageView() != null)
        {
            if (data != null && data.size() > 0)
            {
                getPageView().onDataLoadFinish(data, false);
            }
            else
            {
                getPageView().showEmpty();
            }
        }
    }
    
    @Override
    public void onLoadFail(BaseModel model, String prompt)
    {
        if (getPageView() != null)
        {
            getPageView().showFailure(prompt);
        }
    }
    
    public void tryToRefresh()
    {
        model.load();
    }
    
    @Override
    protected void initModel()
    {
        model = new DisCoverModel();
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
