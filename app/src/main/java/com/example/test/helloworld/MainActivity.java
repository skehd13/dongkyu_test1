package com.example.test.helloworld;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private Button displaybt, googlebt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("helloworld", "create Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        displaybt = (Button)findViewById(R.id.displaybt);
        googlebt = (Button)findViewById(R.id.googlebt);

        displaybt.setOnClickListener(onClickListener);
        googlebt.setOnClickListener(onClickListener);
        startService(new Intent(context, DongkService.class));
//        finish();

    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.displaybt:
                    context.sendBroadcast(new Intent("dongk.web.start"));
                    finish();
                    break;
                case R.id.googlebt:
                    context.sendBroadcast(new Intent("dongk.web.start.google"));
                    finish();
                    break;
            }
        }
    };
}
