package com.fhzn.common.base.loadsir;

import com.fhzn.common.R;
import com.kingja.loadsir.callback.Callback;

/**
 * 应用模块: loadSir
 * <p>
 * 类描述: 空页面
 * <p>
 *
 * @author jerry
 * @since 2020-01-27
 */
public class EmptyCallback extends Callback
{
    @Override
    protected int onCreateView()
    {
        return R.layout.base_layout_empty;
    }
}
