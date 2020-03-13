package com.umeng.project_test.presenter;

import com.umeng.project_test.bean.ItemData;
import com.umeng.project_test.interfaces.NetCallBack;
import com.umeng.project_test.model.NetModel;
import com.umeng.project_test.view.NetView;

public class NetPresenter implements NetCallBack {
    private NetModel netmodel;
    private NetView netview;

    public NetPresenter(NetView netview) {
        this.netview = netview;
        netmodel = new NetModel();
    }
    public void getData(){
        netmodel.getData(this);
    }


    @Override
    public void onSusses(ItemData data) {
        netview.setData(data);
    }

    @Override
    public void onFail(String str) {
        netview.showToast(str);
    }
}
