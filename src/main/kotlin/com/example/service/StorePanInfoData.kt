package com.example.service

import com.example.client.getData
import com.example.exceptions.InvalidAgeException
import com.example.model.ErrorResponse
import com.example.model.PanData
import com.example.model.Respond
import com.example.repository.PanInfoRepository
import com.example.repository.PanInfoRepositoryImpl
import com.example.utils.appConstants.InfoMessages
import io.ktor.http.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class StorePanInfoData() {

    suspend  fun getDetails(): Respond {
        val result = getData()
        val repo:PanInfoRepository = PanInfoRepositoryImpl()

            return  if(isUserMinor(result.result.data.panData)){
                repo.insertPanInfo(result)

            } else{
                throw InvalidAgeException(HttpStatusCode.BadRequest,ErrorResponse(InfoMessages.MINOR_AGE_ERROR_INFO_ID,InfoMessages.MINOR_AGE_ERROR_INFO_MSG))
            }
        }



    private fun isUserMinor(panData: PanData):Boolean{

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val dob = LocalDate.parse(panData.dateOfBirth, formatter)
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        val age = currentYear - dob.year

        return age > 18
    }

}