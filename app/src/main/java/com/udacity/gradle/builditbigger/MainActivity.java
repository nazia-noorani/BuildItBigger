package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements AsyncTaskListener {

    private boolean mTestingAsync = false;
    private EndpointsAsyncTask mEndpointsAsyncTask;
    private MainFragment mainFragment;
    public String mResult;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        progressDialog = new ProgressDialog(MainActivity.this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setTestingAsync(boolean connectedTesting){
        this.mTestingAsync = connectedTesting;
    }

    public boolean getConnectedTestingAsync(){
        return this.mTestingAsync;
    }


    public void tellJoke(View view){
        progressDialog.setMessage("Loading..");
        progressDialog.show();
//        if(mEndpointsAsyncTask == null){
            mEndpointsAsyncTask =  new EndpointsAsyncTask(this);
            mEndpointsAsyncTask.execute();
//        }

//        Toast.makeText(this,MyClass.getJokes(), Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(this, MainActivityLib.class);
//        intent.putExtra("joke",MyClass.getJokes());
//        startActivity(intent);

    }


    @Override
    public void onTaskFinished(String result) {
        progressDialog.dismiss();
        if(!mTestingAsync){
            mainFragment.setJoke(result);
            mainFragment.printJoke();
        }else{
            mResult = result;
        }

    }

    @Override
    public void onError(String error) {
        progressDialog.dismiss();
        Toast.makeText(this,error, Toast.LENGTH_LONG).show();
    }
}
