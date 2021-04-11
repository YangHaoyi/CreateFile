package com.yanghaoyi.createfile.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yanghaoyi.createfile.R;
import com.yanghaoyi.createfile.presenter.FilePresenter;

/**
 * @author : YangHaoYi on  2021/4/1111:54.
 * Email  :  yang.haoyi@qq.com
 * Description : 文件操作测试页
 * Change : YangHaoYi on  2021/4/1111:54.
 * Version : V 1.0
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /** 通过FileOutput保存按钮 **/
    private TextView tvSaveByFileOutput;
    /** 通过AccessFile保存按钮 **/
    private TextView tvSaveByAccessFile;
    /** 通过FileOutputStream保存按钮 **/
    private TextView tvSaveByFileOutputStream;
    /** 创建文件夹按钮 **/
    private TextView tvCreateDir;
    /** 文件逻辑控制中心 **/
    private FilePresenter filePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /** 初始化 **/
    private void init(){
        initView();
        initData();
        initEvent();
    }

    /** 视图初始化 **/
    private void initView(){
        tvCreateDir = findViewById(R.id.tvCreateDir);
        tvSaveByFileOutputStream = findViewById(R.id.tvSaveByFileOutputStream);
        tvSaveByFileOutput = findViewById(R.id.tvSaveByFileOutput);
        tvSaveByAccessFile = findViewById(R.id.tvSaveByAccessFile);
    }

    /** 初始化数据 **/
    private void initData(){

    }

    /** 初始化事件 **/
    private void initEvent(){
        filePresenter = new FilePresenter(this);
        tvCreateDir.setOnClickListener(this);
        tvSaveByFileOutputStream.setOnClickListener(this);
        tvSaveByFileOutput.setOnClickListener(this);
        tvSaveByAccessFile.setOnClickListener(this);
    }

    /** 点击事件 **/
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvCreateDir:
                filePresenter.makeDirs();
                break;
            case R.id.tvSaveByFileOutputStream:
                filePresenter.writeFileByFileOutputStream();
                break;
            case R.id.tvSaveByFileOutput:
                filePresenter.writeFileByFileOutput();
                break;
            case R.id.tvSaveByAccessFile:
                filePresenter.writeFileByAccessFile();
                break;
            default:
                break;
        }
    }
}