package com.kongtech.example.service

import com.kongtech.example.model.entity.Item
import com.kongtech.example.model.request.ItemCreateRequest
import com.kongtech.example.model.response.ItemResponse
import com.kongtech.example.repository.ItemRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ItemServiceImpl(
    private val itemRepository: ItemRepository
) : ItemService {
    override fun getItems(): MutableList<ItemResponse> {
        val items = itemRepository.findAll()
        val responses: MutableList<ItemResponse> = mutableListOf()
        for (item in items) {
            responses.add(
                ItemResponse.of(item.id!!, item.name, item.price, item.stockQuantity)
            )
        }
        return responses
    }

    @Transactional
    override fun addItem(itemCreateRequest: ItemCreateRequest) {
        val item = Item.of(itemCreateRequest.name, itemCreateRequest.price, itemCreateRequest.stockQuantity)
        itemRepository.save(item)
    }
}