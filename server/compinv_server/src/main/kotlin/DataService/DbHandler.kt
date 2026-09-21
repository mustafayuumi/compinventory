package com.mustafayuumi.DataService

import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

object DatabaseFactory {
    // lazy sayesinde sadece ilk ihtiyaç duyulduğunda bir kez çalışır ve saklanır

        val dbName = System.getenv("DB_NAME") ?: ""
        val dbUser = System.getenv("DB_USERNAME") ?: ""
        val dbPassword = System.getenv("DB_PASSWORD") ?: ""

        val mysql: Database by lazy {
            Database.connect(
                url = "jdbc:mysql://localhost:3306/$dbName",
                driver = "com.mysql.cj.jdbc.Driver",
                user = dbUser,
                password = dbPassword
            )
        }



    fun testConnection(): Boolean {
        return try {
            transaction(mysql) {
                true
            }
        } catch (e: Exception) {
            return false
        }
    }
}