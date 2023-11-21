package com.example.utils

import com.example.db.PanInfoTable
import com.example.utils.appConstants.ConstantValues
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

object H2Database {
    fun init(){
        Database.connect(hikari())
        transaction {
            SchemaUtils.create(PanInfoTable)
        }
    }
    private fun hikari(): HikariDataSource {
        val config= HikariConfig()
        config.jdbcUrl = "jdbc:postgresql://localhost:5432/MyDataTest"
        config.driverClassName = "org.postgresql.Driver"
        config.username = "postgres"
        config.password = "root"
        config.maximumPoolSize = ConstantValues.MAXIMUM_POOL_SIZE
        config.isAutoCommit =  false
        config.transactionIsolation= "TRANSACTION_REPEATABLE_READ"
        config.validate()
        return HikariDataSource(config)

    }
}