package com.yanghaoyi.createfile.presenter.constants;

import android.os.Environment;

import java.io.File;

/**
 * @author : YangHaoYi on  2021/4/1018:48.
 * Email  :  yang.haoyi@qq.com
 * Description : 常量类
 * Change : YangHaoYi on  2021/4/1018:48.
 * Version : V 1.0
 */
public class FileConstants {

    /** SD卡目录 **/
    public static final String STORAGE_PATH = Environment.getExternalStorageDirectory().getAbsolutePath();
    /** FOTA文件夹 **/
    public static final String FOTA_DIR = "FotaDownload";
    /** 带文件分隔符的FOTA文件夹 **/
    public static String DOWNLOAD_PATH_TEMP = File.separator + FOTA_DIR;
    /** 根目录 **/
    public static String ROOT_PATH = STORAGE_PATH;
    /** 测试文件目录 **/
    public static String TEST_FILE = File.separator +"test"+File.separator +"test.txt";
    /** 下载文件存放地址 **/
    public static String DOWNLOAD_PATH = ROOT_PATH + DOWNLOAD_PATH_TEMP;

}
