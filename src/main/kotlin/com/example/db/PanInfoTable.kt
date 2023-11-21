package com.example.db

import com.example.utils.appConstants.ConstantValues
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object PanInfoTable: UUIDTable("pan_info") {
    val userInfo=uuid("user_info_id").nullable()
    val attempts=integer("attempts").nullable()
    val docFileId=uuid("doc_file_id").nullable()
    val isManuallyVerified=bool("is_manually_verified").nullable()
    val createdAt=varchar("created_at",ConstantValues.VAR_LENGTH).nullable()
    val updatedAt=varchar("updated_at",ConstantValues.VAR_LENGTH).nullable()
    val panNumber=varchar("pan_number",ConstantValues.VAR_LENGTH)
    val panName=varchar("pan_name",ConstantValues.VAR_LENGTH)
    val dataOfBirth=varchar("data_of_birth",ConstantValues.VAR_LENGTH)
    val status = varchar("status",ConstantValues.VAR_LENGTH)
    val updatedBy = varchar("updated_by",ConstantValues.VAR_LENGTH).nullable()
}



