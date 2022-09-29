package com.example.android.shopping.presentation

import androidx.lifecycle.ViewModel
import com.example.android.shopping.data.ShopListRepositoryImpl
import com.example.android.shopping.domain.DeleteShopItemUseCase
import com.example.android.shopping.domain.EditShopItemUseCase
import com.example.android.shopping.domain.GetShopListUseCase
import com.example.android.shopping.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }

}
