package nazianoorani.myandroidlib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by nazianoorani on 26/04/16.
 */
public class MainActivityLib extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lib);
        TextView tv = (TextView) findViewById(R.id.textView);
        if( getIntent().hasExtra("joke"))
        {
            tv.setText(getIntent().getStringExtra("joke"));
        }
    }
}
