package com.example.corona.tracking.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.corona.tracking.database.Dataset

@Entity
internal data class DbDataset(@PrimaryKey val id: Long, val timestamp: Long) {
    fun toChatGroup(members: List<String>) = Dataset(id, timestamp)
}