package com.example.repository

import com.example.db.PanInfoTable
import com.example.exceptions.CommonException
import com.example.model.ApiRequest
import com.example.model.Respond
import com.example.utils.appConstants.InfoMessages
import io.ktor.http.HttpStatusCode
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDateTime

class PanInfoRepositoryImpl:PanInfoRepository {
    override suspend fun insertPanInfo(apiRequest: ApiRequest):Respond {
     return  try {
            transaction {
                PanInfoTable.insert{
                    it[panName] = apiRequest.result.data.panData.name
                    it[panNumber] = apiRequest.result.data.panData.pan
                    it[dataOfBirth] = apiRequest.result.data.panData.dateOfBirth
                    it[status] = apiRequest.status
                    it[createdAt] = LocalDateTime.now().toString()
                    it[updatedAt] = LocalDateTime.now().toString()
                }
                Respond(InfoMessages.SUCCESS_INFO_ID,InfoMessages.SUCCESS_INFO_MSG, apiRequest.result.data.panData.name,apiRequest.result.data.panData.dateOfBirth)

            }

        }catch (e: Exception) {
            throw CommonException(InfoMessages.INSERT_FAILED, HttpStatusCode.InternalServerError)
        }

    }
}