package com.maya.testfrost.services;

import com.google.gson.JsonObject;
import com.maya.testfrost.constants.Constants;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Gokul Kalagara (Mr.Psycho) on 11/02/19.
 */

public interface IVideoService
{
    @GET(Constants.URL_VIDEO)
    public Observable<JsonObject> getVideo();
}

