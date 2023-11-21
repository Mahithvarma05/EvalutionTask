package com.example.serviceTest

import com.example.db.PanInfoTable
import com.example.service.StorePanInfoData
import com.example.utils.H2Database
import com.example.utils.appConstants.InfoMessages
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.After
import org.junit.Before
import java.sql.Connection
import kotlin.test.Test

class StorePanInfoTest {
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
            val info = StorePanInfoData()
            val result = info.getDetails()
            assertEquals(result.infoId,InfoMessages.SUCCESS_INFO_ID)
        }
    }
}