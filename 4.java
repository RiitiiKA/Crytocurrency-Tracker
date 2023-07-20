package com.spiraldev.Cryptotracker.data.repository.favorites
import androidx.lifecycle.LiveData
import com.spiraldev.Cryptotracker.data.local.database.CoinsListEntity
import javax.inject.Inject
import com.spiraldev.Cryptotracker.api.Result
import com.spiraldev.Cryptotracker.util.Constants
class FavoritesRepository @Inject constructor(private val favoritesDataSource:
FavoritesDataSource) {
 val favoriteCoins: LiveData<List<CoinsListEntity>> =
favoritesDataSource.favoriteCoins
 suspend fun favoriteSymbols(): List<String> = favoritesDataSource.favouriteSymbols()
 // update favourites in local database
 suspend fun updateFavouriteStatus(symbol: String): Result<CoinsListEntity> {
 val result = favoritesDataSource.updateFavouriteStatus(symbol)
 return result?.let {
 Result.Success(it)
 } ?: Result.Error(Constants.GENERIC_ERROR)
 }
}