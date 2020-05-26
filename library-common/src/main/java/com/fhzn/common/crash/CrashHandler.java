package com.fhzn.common.crash;

import android.content.Context;

import com.blankj.utilcode.util.LogUtils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread.UncaughtExceptionHandler;


public class CrashHandler implements UncaughtExceptionHandler {

    private static CrashHandler sInstance;

    // 系统默认的异常处理（默认情况下，系统会终止当前的异常程序）
    private UncaughtExceptionHandler mDefaultCrashHandler;

    private Context mContext;// applicationContext;

    private CrashHandlerListener mCrashHandlerListener;

    // 构造方法私有，防止外部构造多个实例，即采用单例模式
    private CrashHandler(Context context) {
        mContext = context;
    }

    public static CrashHandler getInstance(Context context) {
        if (sInstance == null) {
            synchronized (CrashHandler.class) {
                if (sInstance == null) {
                    sInstance = new CrashHandler(context);
                }
            }
        }
        return sInstance;
    }

    // 这里主要完成初始化工作
    public CrashHandler init() {
        // 获取系统默认的异常处理器
        mDefaultCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
        // 将当前实例设为系统默认的异常处理器
        Thread.setDefaultUncaughtExceptionHandler(this);
        return sInstance;
    }

    /**
     * 这个是最关键的函数，当程序中有未被捕获的异常，系统将会自动调用#uncaughtException方法
     * thread为出现未捕获异常的线程，ex为未捕获的异常，有了这个ex，我们就可以得到异常信息。
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        // 导出异常信息到SD卡中
        LogUtils.i("CRASH MESSAGE" + ex.getMessage());
        LogUtils.e(ex, "CRASH DETAIL");
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            LogUtils.e("CRASH DETAIL" + sw.toString());
            sw.close();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 这里可以通过网络上传异常信息到服务器，便于开发人员分析日志从而解决bug
        // 打印出当前调用栈信息
        ex.printStackTrace();

        // 如果系统提供了默认的异常处理器，则交给系统去结束我们的程序，否则就由我们自己结束自己
        if (mDefaultCrashHandler != null) {
            mDefaultCrashHandler.uncaughtException(thread, ex);
        }
    }

    private void crashError2RestartApp() {
        if (mCrashHandlerListener == null) {
            LogUtils.e("AppRestart ==> CrashHandler ==> crashError2RestartApp mCrashHandlerListener is null");
            return;
        }
        mCrashHandlerListener.crashError2RestartApp();
    }

    public void setCrashHandlerListener(CrashHandlerListener listener) {
        this.mCrashHandlerListener = listener;
    }

    public interface CrashHandlerListener {
        /**
         * 重启APP
         */
        void crashError2RestartApp();
    }

}
