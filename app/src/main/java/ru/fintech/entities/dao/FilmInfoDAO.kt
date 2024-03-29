package ru.fintech.entities.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FilmInfoDAO {
    @Query("SELECT * FROM FilmInfo ORDER BY id DESC")
    suspend fun getFavourites(): List<FilmInfo>

    @Query("SELECT * FROM FilmInfo WHERE id = :kinopoiskId")
    suspend fun checkId(kinopoiskId: Int): FilmInfo?

    @Insert
    suspend fun insertFavourite(filmInfo: FilmInfo)

    @Query("DELETE FROM FilmInfo WHERE id = :kinopoiskId")
    suspend fun deleteFavourite(kinopoiskId: Int)
}