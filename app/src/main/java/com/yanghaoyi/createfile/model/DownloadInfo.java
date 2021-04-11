package com.yanghaoyi.createfile.model;

import java.io.File;
import java.io.Serializable;

/**
 * @author : YangHaoYi on  2021/4/1019:04.
 * Email  :  yang.haoyi@qq.com
 * Description : 下载信息数据Bean
 * Change : YangHaoYi on  2021/4/1019:04.
 * Version : V 1.0
 */
public class DownloadInfo implements Serializable {
    private String url;
    private File file;
    //下载文件的类型
    private int type;
    // 广播接受者的各种行为
    private String action;

    public DownloadInfo(String url, File file, int type, String action) {
        this.url = url;
        this.file = file;
        this.type = type;
        this.action = action;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DownloadInfo{" +
                "url='" + url + '\'' +
                ", file=" + file +
                ", type=" + type +
                ", action='" + action + '\'' +
                '}';
    }

    public String getUniqueId() {
        return url + file.getAbsolutePath();
    }
}
