package com.yanghaoyi.createfile.presenter;

import com.yanghaoyi.createfile.presenter.constants.FileConstants;
import com.yanghaoyi.createfile.presenter.util.FileLogUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

import static com.yanghaoyi.createfile.presenter.constants.FileConstants.TEST_FILE;

/**
 * @author : YangHaoYi on  2021/4/1111:54.
 * Email  :  yang.haoyi@qq.com
 * Description : RandomAccessFile文件操作工厂
 * Change : YangHaoYi on  2021/4/1111:54.
 * Version : V 1.0
 */
public class RAFTestFactory {
    private static final String url = FileConstants.ROOT_PATH+TEST_FILE;
    private static final String [] model = {"r","rw","rws","rwd"};

    public void makeParentDir(){
        File file = new File(url);
        File parentFile = file.getParentFile();
        if(!parentFile.exists()){
            boolean mkdirs = parentFile.mkdirs();
            FileLogUtil.logMessage("doDownload mkdirs:" + mkdirs);
        }
    }

    public static RandomAccessFile getRAFWithModelR() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(new File(url), model[0]);
        return raf;
    }

    public static RandomAccessFile getRAFWithModelRW() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(new File(url), model[1]);
        return raf;
    }

    public static RandomAccessFile getRAFWithModelRWS() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(new File(url), model[2]);
        return raf;
    }

    public static RandomAccessFile getRAFWithModelRWD() throws FileNotFoundException {
        RandomAccessFile raf = new RandomAccessFile(new File(url), model[3]);
        return raf;
    }
}
