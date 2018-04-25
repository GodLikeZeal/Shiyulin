package com.zeal.shiyulin.utils;

import com.aliyun.oss.ClientConfiguration;

/**
 * Created by zeal on 2017/10/31.
 */
public class AliyunOSSClientConfiguration {

    private static final ClientConfiguration conf = new ClientConfiguration();

    private AliyunOSSClientConfiguration() {
        // Set the maximum number of allowed open HTTP connections
        conf.setMaxConnections(100);
        // Set the amount of time to wait (in milliseconds) when initially establishing
        // a connection before giving up and timing out
        conf.setConnectionTimeout(5000);
        // Set the maximum number of retry attempts for failed retryable requests
        conf.setMaxErrorRetry(3);
        // Set the amount of time to wait (in milliseconds) for data to betransfered over
        // an established connection before the connection times out and is closed
        conf.setSocketTimeout(2000);
    }

    public static ClientConfiguration getAliyunOSSClientConfiguration(){
        return conf;
    }
}
