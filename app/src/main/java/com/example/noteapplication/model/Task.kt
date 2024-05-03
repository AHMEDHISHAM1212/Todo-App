package com.example.noteapplication.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Task(
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    val id: Int?= null,
    @ColumnInfo
    val title: String?= null,
    @ColumnInfo
    val description: String? = null,
    @ColumnInfo
    val date: Long?= null,
    @ColumnInfo
    val isDone: Boolean= false
): Parcelable
