package com.umeng.project_test.interfaces;

import com.umeng.project_test.bean.ItemData;

public interface NetCallBack {
    void onSusses(ItemData data);
    void onFail(String str);
}
