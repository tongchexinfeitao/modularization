package com.ali.commonlib.export;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * Created by mumu on 2019/5/11.
 * 只需要集成Iprovider就行
 */

public interface IHomeExportService extends IProvider{
    void sayHello(String message);

    String getMessage();
}
