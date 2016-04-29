package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;
import android.widget.Toast;

import com.example.nazianoorani.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by nazianoorani on 26/04/16.
 */
class EndpointsAsyncTask extends AsyncTask<String, Void, String> {
    private static MyApi myApiService = null;
//    private Context context;
    AsyncTaskListener listener;


    public EndpointsAsyncTask(AsyncTaskListener listener){
        this.listener = listener;
    }
    @Override
    protected String doInBackground(String... params) {
        if(myApiService == null) {  // Only do this once
//            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(), null)
//                    // options for running against local devappserver
//                    // - 10.0.2.2 is localhost's IP address in Android emulator
//                    // - turn off compression when running against local devappserver
//                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override
//                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://backend-1293.appspot.com/_ah/api/");
            // end options for devappserver

            myApiService = builder.build();
        }

//        context = params[0].first;
//        String name = params[0].second;

        try {

            return myApiService.getJoke().execute().getData();
//            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {

            listener.onError(e.getMessage());
            Log.e("error",e.getMessage());
            return e.getMessage();

        }
    }



    @Override
    protected void onPostExecute(String result) {

        listener.onTaskFinished(result);
//        activity.setResult(result);
//        Toast.makeText(activity, result, Toast.LENGTH_LONG).show();
    }
}