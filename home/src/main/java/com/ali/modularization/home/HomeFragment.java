package com.ali.modularization.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * Created by mumu on 2019/5/16.
 */

@Route(path = "/home/homefragment")
public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.home_fragment_home, container, false);
        TextView textView = inflate.findViewById(R.id.home_fragment_tv);
        textView.setText(getArguments().getString("key"));
        return inflate;
    }


}
