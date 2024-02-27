package com.example.partyfinder.network

import com.example.partyfinder.model.CommunitiesList
import com.example.partyfinder.model.CommunityPost
import com.example.partyfinder.model.FirebaseResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface CommunitiesApi {

    @GET("communities.json")
    suspend fun fetchCommunityData():Response<CommunitiesList>

    @POST("communities/data/Albion/communityPosts.json")
    suspend fun postCommunityUserPost(@Body userPost: CommunityPost): Response<FirebaseResponse>

    @PUT("communities/data/Albion/communityPosts/{CommunityPostID}.json")
    suspend fun updateCommunityPost(@Path("CommunityPostID") communityPostId:String,@Body communityPost:CommunityPost):Response<ResponseBody>
}
