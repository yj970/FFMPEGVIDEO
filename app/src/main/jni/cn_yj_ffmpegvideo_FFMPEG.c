#include <stdio.h>
#include "cn_yj_ffmpegvideo_FFMPEG.h"
#include "ffmpeg.h"

JNIEXPORT jint JNICALL Java_cn_yj_ffmpegvideo_FFMPEG_run(JNIEnv *env, jclass obj, jobjectArray commands){
    int argc = (*env)->GetArrayLength(env, commands);
    char *argv[argc];

    int i;
    for (i = 0; i < argc; i++) {
        jstring js = (jstring) (*env)->GetObjectArrayElement(env, commands, i);
        argv[i] = (char*) (*env)->GetStringUTFChars(env, js, 0);
    }
    return run(argc, argv);
}

