package com.qg.taxi.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author <a href="http://minsming.com">小铭</a>
 * Date: 2018/4/23
 * No struggle, talent how to match the willfulness.
 * Description:
 */
@Data
@ConfigurationProperties("storage")
public class StorageProperties {
    /**
     * Folder location for storing files
     */
    private String location = "resources";
}
