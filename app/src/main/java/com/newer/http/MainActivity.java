package com.newer.http;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.textView);

        try {
            InputStream in = openFileInput("abc");

            int size = in.available();
            byte[] buf =new byte[size];

            in.read(buf);
            String text =new String(buf);
            in.close();



            textView.setText(text);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        new Thread(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        String path ="https://www.baidu.com";
//
//                        //构造URL
//                        try {
//                            URL url= new URL(path);
//
//                            //获得http连接
//                            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
//                            //http GET操作
//                            conn.setRequestMethod("GET");
//
//                            int code = conn.getResponseCode();
//                            if(code==HttpURLConnection.HTTP_OK){
//                                //响应成功
//                                InputStream in= conn.getInputStream();
//                                BufferedReader reader =new BufferedReader(new InputStreamReader(in));
//
//                                char[] buf = new char[4096];
//                                StringBuffer buffer =new StringBuffer();
//
//                                int size;
//                                while(-1!=(size =reader.read(buf))){
//                                    buffer.append(buf,0,size);
//                                }
//
//                                reader.close();
//                                String text = buffer.toString();
//                                Log.d("ok"+Thread.currentThread().getName(), text);
//
//                                //存储数据（内部存储）
//                                //  在根目录 data/data/com.newer.http/file/abc
//                              OutputStream out= openFileOutput("abc",MODE_PRIVATE);
//                                Writer writer =new OutputStreamWriter(out);
//                                writer.write(text);
//                                writer.close();
//                                Log.d("save" + Thread.currentThread().getName(), text);
//
//                            }
//
//
//                        } catch (MalformedURLException e) {
//                            e.printStackTrace();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                },
//                "foo"
//        ).start();

    }
}
