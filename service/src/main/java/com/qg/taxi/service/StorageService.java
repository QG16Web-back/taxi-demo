package com.qg.taxi.service;

import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.nio.file.Path;

/**
 * @author <a href="http://minsming.com">小铭</a>
 * Date: 2018/4/23
 * No struggle, talent how to match the willfulness.
 * Description:
 */
public interface StorageService {

    /**
     * init dir
     */
    void init();

    /**
     * store file
     *
     * @param filename filename
     * @param inputStream inputStream
     */
    void store(String filename, InputStream inputStream);

    /**
     * load file
     *
     * @param filename filename
     * @return Path Examples
     */
    Path load(String filename);

    /**
     * load file as resource
     *
     * @param filename filename
     * @return Resource Examples
     */
    Resource loadAsResource(String filename);

    /**
     * delete all files
     */
    void deleteAll();
}
