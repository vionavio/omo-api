package com.viona.onlinemotorcycle.database

import com.mongodb.client.MongoClient
import org.litote.kmongo.KMongo
import org.springframework.stereotype.Component


@Component
class DatabaseComponent {
    private val databaseUrl = System.getenv("DATABASE_URL")
    val database: MongoClient = KMongo.createClient("mongodb+srv://vionavio:666198@cluster0.fybrt.mongodb.net/?retryWrites=true&w=majority")
    //val database: MongoClient = KMongo.createClient(databaseUrl)
}