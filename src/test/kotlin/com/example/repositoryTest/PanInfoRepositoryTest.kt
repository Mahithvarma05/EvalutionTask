package com.example.repositoryTest


import com.example.db.PanInfoTable
import com.example.model.*
import com.example.repository.PanInfoRepositoryImpl
import com.example.utils.H2Database
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.After
import org.junit.Before
import java.sql.Connection
import kotlin.test.Test
import kotlin.test.assertEquals

class PanInfoRepositoryTest {

    @Before
    fun setup() {
        H2Database.init()
        TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_REPEATABLE_READ

        transaction {
            SchemaUtils.create(PanInfoTable)
        }
    }

    @After
    fun tearDown() {
        transaction {
            SchemaUtils.drop(PanInfoTable)
        }
    }

    @Test
    fun testInsertPanInfo():Unit{

        runBlocking {

            val repo = PanInfoRepositoryImpl()
            val model = ApiRequest("success","200", Data(ResultData("Valid",
                PanData("mahith","Email@mail.com","123","male","panNum","","","mahith","2001-04-05","xxx12",
                    Address("street1","city1","state1","1","l1","l2"),true
                )
            )
            ))
            val result = repo.insertPanInfo(model)
            assertEquals(result.name,"mahith")

        }
    }

}