package com.yanghaoyi.createfile.presenter.util;

import android.util.Log;

/**
 * @author : YangHaoYi on  2021/4/1019:10.
 * Email  :  yang.haoyi@qq.com
 * Description : 日志输出工具类
 * Change : YangHaoYi on  2021/4/1019:10.
 * Version : V 1.0
 */
public class FileLogUtil {

    private static final String TAG = "FileTest";

    public static void logMessage(String message){
        Log.d(TAG, message);
    }

}
