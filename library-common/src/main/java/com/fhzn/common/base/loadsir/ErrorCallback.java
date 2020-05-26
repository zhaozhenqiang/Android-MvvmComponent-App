package com.fhzn.common.base.loadsir;

import com.fhzn.common.R;
import com.kingja.loadsir.callback.Callback;

/**
 * 应用模块:
 * <p>
 * 类描述: 错误页面
 * <p>
 *
 * @author jerry
 * @since 2020-01-27
 */
public class ErrorCallback extends Callback
{
    @Override
    protected int onCreateView()
    {
        return R.layout.base_layout_error;
    }
}
