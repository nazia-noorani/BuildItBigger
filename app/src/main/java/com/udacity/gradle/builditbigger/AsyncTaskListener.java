package com.udacity.gradle.builditbigger;

/**
 * Created by nazianoorani on 28/04/16.
 */
public interface AsyncTaskListener {
    void onTaskFinished(String result);
    void onError(String error);
}
