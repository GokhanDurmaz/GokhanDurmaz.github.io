package com.demo.ans.github.network;

/**
 * Created by gokhan on 11/6/21.
 *
 * @author gokhan
 * @since 2021/11/06
 */

public interface ResponseReturnHandler {

    /**
     * Returns a response object
     * @param obj obj
     */
    void onDone(Object obj);

    /**
     * Returns fail code if the response cannot be provided
     * @param failCode failCode
     */
    void onFailure(int failCode);
}
