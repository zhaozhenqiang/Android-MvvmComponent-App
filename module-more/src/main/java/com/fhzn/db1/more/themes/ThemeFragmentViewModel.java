package com.fhzn.db1.more.themes;

import com.fhzn.common.model.BaseModel;
import com.fhzn.common.model.IModelListener;
import com.fhzn.common.viewmodel.MvmBaseViewModel;
import com.fhzn.db1.more.themes.bean.Tabs;

import java.util.ArrayList;


/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-22
 */
public class ThemeFragmentViewModel
    extends MvmBaseViewModel<IThemeView, ThemeModel>
    implements IModelListener<ArrayList<Tabs>>
{
    
    @Override
    protected void initModel()
    {
        model = new ThemeModel();
        model.register(this);
        model.getCacheDataAndLoad();
    }

    @Override
    public void detachUi() {
        super.detachUi();
        if (model != null){
            model.unRegister(this);
        }
    }

    @Override
    public void onLoadFinish(BaseModel model, ArrayList<Tabs> data)
    {
        if (getPageView() != null)
        {
            if (data != null)
            {
                getPageView().onDataLoaded(data);
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
}
