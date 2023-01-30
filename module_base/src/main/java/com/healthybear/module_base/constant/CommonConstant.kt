package com.healthybear.module_base.constant

/**
 * @author: 郭健鸿
 * @Date: 2023-01-12 01:42
 * @Description:通用常量
 */
class CommonConstant {

    /**
     * 日志文件格式
     */
    class Log {

        companion object {
            /**
             * 日志文件格式
             */
            const val LOG_NAME_FORMAT = "yyyyMMdd";

            /**
             * 日志缓存
             */
            const val BUFFER_SIZE = 40 * 1024;

            /**
             * 日志缓存天数
             */
            const val LOG_OVER_TIME = 30;
        }

    }
}