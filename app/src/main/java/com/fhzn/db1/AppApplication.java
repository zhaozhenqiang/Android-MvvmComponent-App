package com.fhzn.db1;

import com.fhzn.common.base.BaseApplication;
import com.fhzn.common.config.ModuleLifecycleConfig;

/**
 * 应用模块: 宿主app
 * <p>
 * 类描述: 宿主app的 application ,在这里通过common组件中定义的组件生命周期配置类进行相应初始化(通过反射调用各个组件的初始化器)
 * <p>
 *
 * @author jerry
 * @since 2020-02-26
 */
public class AppApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        setsDebug(BuildConfig.DEBUG);
        // 初始化需要初始化的组件
        ModuleLifecycleConfig.getInstance().initModuleAhead(this);
    }
}
