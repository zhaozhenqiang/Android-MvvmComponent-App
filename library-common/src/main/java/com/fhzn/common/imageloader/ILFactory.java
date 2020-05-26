package com.fhzn.common.imageloader;

/**
 * Function:
 * Author Name: zhaozq
 * Date: 2020/5/15
 * Copyright © 2020-2025 复泓智能, All Rights Reserved.
 */
public class ILFactory {

    private static ILoader loader;


    public static ILoader getLoader() {
        if (loader == null) {
            synchronized (ILFactory.class) {
                if (loader == null) {
                    loader = new GlideLoader();
                }
            }
        }
        return loader;
    }


}
