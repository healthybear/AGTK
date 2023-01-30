package com.healthybear.module_base.util

import android.content.Context
import android.os.Build
import java.io.File

/**
 * @author: 郭健鸿
 * @Date: 2023-01-12 01:51
 * @Description:
 */
class FilePathUtil {
    private val TAG = FilePathUtil::class.java.simpleName;

    companion object {
        const val SIGN_LOG = "log";
        const val SIGN_UPLOAD = "upload";
        const val PIC_DIR = "pic";
    }

    /**
     * 获得应用内置存储目录，随应用卸载而删除
     */
    fun getFilesDir(context: Context): File {
        return context.applicationContext.filesDir;
    }

    /**
     * 获得应用外置存储目录，随应用卸载而删除
     */
    fun getExternalFilesDir(context: Context): File? {
        return context.applicationContext.getExternalFilesDir("");
    }

    /**
     * 获得应用外置存储目录，随应用卸载而删除
     */
    fun getExternalCacheDir(context: Context): File? {
        return context.applicationContext.externalCacheDir;
    }

    /**
     * 日志保存目录
     */
    fun getLogDirPath(context: Context): String {
        var file = File(getExternalFilesDir(context), SIGN_LOG)
        return file.absolutePath
    }

    /**
     * 日志上传目录
     */
    fun getUploadLogCacheDirPath(context: Context): String {
        var file = File(getExternalFilesDir(context), SIGN_UPLOAD)
        return file.absolutePath
    }

    /**
     * 相片临时保存目录
     */
    fun getPictureDirPath(context: Context): String {
        var file = File(getExternalFilesDir(context), PIC_DIR)
        return file.absolutePath
    }
}