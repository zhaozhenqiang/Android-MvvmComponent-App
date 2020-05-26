package com.fhzn.common.constant;

import com.fhzn.common.imageloader.ILoader;

/**
 * Function:
 * Author Name: zhaozq
 * Date: 2020/5/15
 * Copyright © 2020-2025 复泓智能, All Rights Reserved.
 */
public class Constant {
    // #log
    public static boolean LOG = true;
    public static String LOG_TAG = "FHZN";

    // #cache
    public static String CACHE_SP_NAME = "config";
    public static String CACHE_DISK_DIR = "cache";

    // #imageloader
    public static int IL_LOADING_RES = ILoader.Options.RES_NONE;
    public static int IL_ERROR_RES = ILoader.Options.RES_NONE;

    // #debug model
    public static boolean DEBUG = true;

    // #user first use
    public static String FLAG_FIRST = "FLAG_FIRST";
    public static String USER_TOKEN = "USER_TOKEN";

    // #default design size
    public static float DEFAULT_SIZE = 375.0f;
}
