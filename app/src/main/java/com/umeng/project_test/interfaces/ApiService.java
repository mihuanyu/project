package com.umeng.project_test.interfaces;

import com.umeng.project_test.bean.ItemData;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String BaseUrl="https://cdwan.cn/";

    @GET("api/topic/list")
    Observable<ItemData> initData();
}
