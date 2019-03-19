package cn.yj.ffmpegvideo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 此为耗时操作，因为是演示ffmpeg命令，简单为主，所以没放入子线程。
        // 仅为演示
        String base = Environment.getExternalStorageDirectory().getPath();
        Log.d("PATH", base);
        String[] commands = new String[9];
        commands[0] = "ffmpeg";
        commands[1] = "-i";
        commands[2] = base + "/1_2.mp4"; // 原视频路径
        commands[3] = "-i";
        commands[4] = base + "/3.mp3";// 原音频路径
        commands[5] = "-strict";
        commands[6] = "-2";
        commands[7] = "-y";
        commands[8] = base + "/myvideo.mp4"; // 合成后的输出路径
        int result = FFMPEG.run(commands);
        if(result == 0){
            Toast.makeText(MainActivity.this, "命令行执行完成", Toast.LENGTH_SHORT).show();
        }

    }
}
