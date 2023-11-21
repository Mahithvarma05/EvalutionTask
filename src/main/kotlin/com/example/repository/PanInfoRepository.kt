package com.example.repository

import com.example.model.ApiRequest
import com.example.model.Respond

interface PanInfoRepository {
    suspend fun insertPanInfo(apiRequest: ApiRequest):Respond
}