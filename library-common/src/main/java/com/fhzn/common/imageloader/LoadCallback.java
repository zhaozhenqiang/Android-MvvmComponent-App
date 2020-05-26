package com.fhzn.common.imageloader;

import android.graphics.drawable.Drawable;

/**
 * Function:
 * Author Name: zhaozq
 * Date: 2020/5/15
 * Copyright © 2020-2025 复泓智能, All Rights Reserved.
 */
public abstract class LoadCallback {
    void onLoadFailed() {}

    public abstract void onLoadReady(Drawable drawable);

    void onLoadCanceled() {}
}
