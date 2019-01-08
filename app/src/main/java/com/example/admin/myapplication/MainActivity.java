package com.example.admin.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button bt;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.bt);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取系统时间戳
                long time = System.currentTimeMillis();
                tv1.setText("系统时间戳:"+time);
                Log.e("TAG1",time+"");

                //获取当前时间
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss SSS");
                Date curDate = new Date(System.currentTimeMillis());
                String currentTime = simpleDateFormat.format(curDate);
                tv2.setText("当前时间："+currentTime);

                //时间戳转换成字符串
                Date date = new Date(time);
                SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss SSS");
                String strData = format.format(date);
                Log.e("TAG2",strData+"");
                Log.e("时间戳转换成字符串:",strData);
                tv3.setText("时间戳转换成字符串:"+strData);

                //字符串转时间戳
               // SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
                Date date1 = new Date();
                try {
                    date1 = simpleDateFormat.parse(strData);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                long timestamp = date1.getTime();
                Log.e("TAG3",timestamp+"");
                tv4.setText("字符串转时间戳:"+timestamp);

                //时间戳再找字符串
                Date d = new Date(timestamp);
                SimpleDateFormat s = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss SSS");
                Log.e("zifucuan:",s.format(d));
            }
        });


    }
}
