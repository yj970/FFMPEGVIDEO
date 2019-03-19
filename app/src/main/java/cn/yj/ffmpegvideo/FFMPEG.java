package cn.yj.ffmpegvideo;

/**
 * Created by yangjie on 2019/3/19.
 */

public class FFMPEG {
    static{
        System.loadLibrary("ffmpeg");
        System.loadLibrary("ffmpeginvoke");
    }
    public static native int run(String[] commands);
}
