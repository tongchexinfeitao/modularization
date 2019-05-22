package com.ali.modularization.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;


@Route(path = "/home/HomeActivity")
public class HomeActivity extends AppCompatActivity {


    TextView homeTv;
    @Autowired(name = "name")
    String myName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_home);
        ARouter.getInstance().inject(this);
        homeTv = findViewById(R.id.home_tv);
        homeTv.setText(myName);
    }
}
