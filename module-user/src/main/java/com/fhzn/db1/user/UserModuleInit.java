package com.fhzn.db1.user;

import com.fhzn.common.IModuleInit;
import com.fhzn.common.base.BaseApplication;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author jerry
 * @since 2020-02-29
 */
public class UserModuleInit implements IModuleInit {
    @Override
    public boolean onInitAhead(BaseApplication application) {
        return false;
    }

    @Override
    public boolean onInitLow(BaseApplication application) {
        return false;
    }
}
