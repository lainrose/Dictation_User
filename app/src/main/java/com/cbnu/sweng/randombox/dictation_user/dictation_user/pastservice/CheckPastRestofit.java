package com.cbnu.sweng.randombox.dictation_user.dictation_user.pastservice;

import com.cbnu.sweng.randombox.dictation_user.dictation_user.pastmodel.PastInfoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by SAMSUNG on 2017-08-14.
 */

public interface CheckPastRestofit {

    @GET("/students/{id}/{grade}")
    Call<List<PastInfoModel>> checkresult(@Query("grade") String grade);


}
