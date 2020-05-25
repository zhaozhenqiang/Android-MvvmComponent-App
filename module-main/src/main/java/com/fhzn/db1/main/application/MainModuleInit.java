package com.fhzn.db1.main.application;

import com.blankj.utilcode.util.Utils;
import com.fhzn.common.IModuleInit;
import com.fhzn.common.adapter.ScreenAutoAdapter;
import com.fhzn.common.base.BaseApplication;
import com.fhzn.common.loadsir.EmptyCallback;
import com.fhzn.common.loadsir.ErrorCallback;
import com.fhzn.common.loadsir.LoadingCallback;
import com.fhzn.common.loadsir.TimeoutCallback;
import com.fhzn.common.net.EasyHttp;
import com.fhzn.common.net.cache.converter.GsonDiskConverter;
import com.fhzn.common.net.cache.model.CacheMode;
import com.kingja.loadsir.core.LoadSir;
import com.orhanobut.logger.Logger;

/**
 * 应用模块: main
 * <p>
 * 类描述: main组件的业务初始化
 * <p>
 *
 * @author darryrzhoong
 * @since 2020-02-26
 */
public class MainModuleInit implements IModuleInit {
    @Override
    public boolean onInitAhead(BaseApplication application) {
        ScreenAutoAdapter.setup(application);
        EasyHttp.init(application);
        if (application.issDebug()) {
            EasyHttp.getInstance().debug("easyhttp", true);
        }
        EasyHttp.getInstance()
                .setBaseUrl("https://ap2.fuxiang.site")
                .setReadTimeOut(15 * 1000)
                .setWriteTimeOut(15 * 1000)
                .setConnectTimeout(15 * 1000)
                .setRetryCount(3)
                .setCacheDiskConverter(new GsonDiskConverter())
                .setCacheMode(CacheMode.FIRSTREMOTE);
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new TimeoutCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();
        Utils.init(application);
        Logger.i("main组件初始化完成 -- onInitAhead");
        return false;
    }

    @Override
    public boolean onInitLow(BaseApplication application) {
        return false;
    }
}
