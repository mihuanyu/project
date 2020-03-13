package com.umeng.project_test.model;

import com.umeng.project_test.bean.ItemData;
import com.umeng.project_test.interfaces.ApiService;
import com.umeng.project_test.presenter.NetPresenter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetModel {
    public void getData(final NetPresenter netPresenter) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<ItemData> observable = apiService.initData();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ItemData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ItemData itemData) {
                        netPresenter.onSusses(itemData);
                    }

                    @Override
                    public void onError(Throwable e) {
                        netPresenter.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

