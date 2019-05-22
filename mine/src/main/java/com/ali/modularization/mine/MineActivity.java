package com.ali.modularization.mine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ali.commonlib.export.IHomeExportService;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;


@Route(path = "/mine/MineActivity")
public class MineActivity extends AppCompatActivity {


    TextView mineTv;

    @Autowired(name = "/home/HomeService")
    public IHomeExportService mIHomeExportService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_activity_mine);
        //必须注入
        ARouter.getInstance().inject(this);
        mineTv = findViewById(R.id.mine_tv);
        mineTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                //1、组件间页面跳转
//                ARouter.getInstance().build("/home/HomeActivity").withString("name", "我是mine模块传递的name数据").navigation();
//
//                //2、通过IProvider接口进行组件间通信
//                mIHomeExportService.sayHello("你好呀");
//                Log.e("TAG", mIHomeExportService.getMessage());

                //3、获取组件的fragment，进行展示
                Fragment homeFragment = (Fragment) ARouter.getInstance().build("/home/homefragment").navigation();
                Bundle bundle = new Bundle();
                bundle.putString("key","传给fragment的value");
                homeFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().replace(R.id.home_fl,homeFragment).commit();
            }
        });
    }
}
