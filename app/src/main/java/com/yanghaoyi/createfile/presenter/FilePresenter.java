package com.yanghaoyi.createfile.presenter;

import android.content.Context;
import android.os.Environment;

import com.yanghaoyi.createfile.model.DownloadInfo;
import com.yanghaoyi.createfile.presenter.constants.FileConstants;
import com.yanghaoyi.createfile.presenter.util.FileLogUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import static com.yanghaoyi.createfile.presenter.constants.FileConstants.TEST_FILE;

/**
 * @author : YangHaoYi on  2021/4/1018:41.
 * Email  :  yang.haoyi@qq.com
 * Description : 文件下载逻辑控制中心
 * Change : YangHaoYi on  2021/4/1018:41.
 * Version : V 1.0
 */
public class FilePresenter {

    /**  上下文 **/
    private Context context;

    /** 构造函数 **/
    public FilePresenter(Context context) {
        this.context = context;
    }

    /** 创建文件夹 **/
    public void makeDirs(){
//        File file = info.getFile();
//        File parentFile = file.getParentFile();
//        if(!parentFile.exists()){
//            boolean makeDirs = parentFile.mkdirs();
//        }
        FileLogUtil.logMessage("File url is: "+FileConstants.DOWNLOAD_PATH);
        File downloadDir = new File(FileConstants.DOWNLOAD_PATH);
        if (!downloadDir.exists()) {
            downloadDir.mkdirs();
        }
    }

    /**
     * 通过FileOutputStream方式写文件
     * 操作
     * 1.父目录未创建：
     * java.io.FileNotFoundException:open failed: ENOENT (No such file or directory)
     * 2.文件未创建：
     * Success 可以自动生成文件
     * 原因：
     * 1.无法自动创建文件父目录
     * 2.FileOutputStream可以自动创建文件
     *
     * **/
    public void writeFileByFileOutputStream(){
        try {
            // 判断当前的手机是否有sd卡
            String state = Environment.getExternalStorageState();
            if(!Environment.MEDIA_MOUNTED.equals(state)) {
                FileLogUtil.logMessage("未挂载sd卡");
                return;
            }
            File sdCardFile = Environment.getExternalStorageDirectory();
            File file = new File(sdCardFile, TEST_FILE);
            FileOutputStream fos = new FileOutputStream(file);
            String test = "FileOutputStream 写文件";
            fos.write(test.getBytes());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过openFileOutput方式写文件
     * 文件存储路径为data/data/com.yanghaoyi.createfile/file/test.txt
     * 文件不存在可以默认生成
     * openFileOutput中param_1不能有文件分隔符 "/"
     *
     * **/
    public void writeFileByFileOutput(){
        try {
            FileOutputStream fos = context.openFileOutput("test.txt", Context.MODE_PRIVATE);
            fos.write("私有模式".getBytes());
            fos.close();
        } catch (Exception e) {
            FileLogUtil.logMessage("writeFileByFileOutput Error "+ e);
            e.printStackTrace();
        }
    }

    /**
     * 通过RandomAccessFile方式写文件
     * **/
    public void writeFileByAccessFile(){
        writeByReadAndWrite();
    }

    /**
     * 通过只读形式打开文件，执行写操作
     * Exception信息：
     * 1.父目录或文件未创建：java.io.FileNotFoundException:open failed: ENOENT (No such file or directory)
     * 2.创建文件：java.io.IOException: write failed: EBADF (Bad file descriptor)
     * 原因：
     * 1.只读方式无法自动创建文件
     * 2.只读方式无法执行写操作
     *
     * **/
    private void writeByReadOnly(){
        try {
            RandomAccessFile accessFile = RAFTestFactory.getRAFWithModelR();
            String test = "只读方式";
            accessFile.write(test.getBytes());
            accessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过只读形式打开文件，执行写操作
     * 操作：
     * 1.父目录未创建：
     * java.io.FileNotFoundException:open failed: ENOENT (No such file or directory)
     * 2.文件未创建：
     * Write success
     * 原因：
     * 1.无法自动创建文件父目录
     * 2.RAFWithModelRW可以自动创建文件
     *
     * **/
    private void writeByReadAndWrite(){
        try {
            RandomAccessFile accessFile = RAFTestFactory.getRAFWithModelRW();
            String test = "读写方式";
            accessFile.write(test.getBytes());
            accessFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改文件权限
     * 需要root
     *
     * **/
    private void changePermission(File file){
        try {
            String command = "chmod 700 " + file.getAbsolutePath();
            Runtime runtime = Runtime.getRuntime();
            java.lang.Process proc = runtime.exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
