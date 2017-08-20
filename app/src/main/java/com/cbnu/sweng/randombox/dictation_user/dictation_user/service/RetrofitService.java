package com.cbnu.sweng.randombox.dictation_user.dictation_user.service;

import com.cbnu.sweng.randombox.dictation_user.dictation_user.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by user on 2017-08-14.
 */

public interface RetrofitService {

    //로그인
    @POST("auth/login")
    Call<List<Student>> login(@Field("name") String name,
                              @Field("school") String school,
                              @Field("student_id") int student_id,
                              @Field("type") String type);

    //학생 수정
    @GET("students/:id")
    Call<List<Student>> modifyStudent(@Query("school") String school,
                                      @Query("class") String _class,
                                      @Query("name") String name);

    //학생 요청
    @GET("students/:id")
    Call<List<Student>> getStudent(@Query("school") String school,
                                   @Query("class") String _class,
                                   @Query("name") String name);

    //학생 추가
    @POST("students")
    Call<List<Student>> addStudent(@Field("name") String name,
                                   @Field("school") String school,
                                   @Field("student_id") int student_id,
                                   @Field("type") String type);

    //문제 전체 정보
    @GET("quizzes")
    Call<List<Student>> getAllQuize();

    //문제 한 개 정보
    @GET("quizzes/:id")
    Call<List<Student>> getQuize();

    //학교 전체 정보
    @GET("schools")
    Call<List<Student>> getAllSchool();

    //학교 한 개 정보
    @GET("schools/:id")
    Call<List<Student>> getSchool();

}
