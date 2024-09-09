package com.example.simplemarket.service;

import com.example.simplemarket.controller.ItemRequest;
import com.example.simplemarket.controller.ItemResponse;
import com.example.simplemarket.controller.Response;
import com.example.simplemarket.entity.Item;
import com.example.simplemarket.entity.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public ItemResponse createItem(ItemRequest request) {
        Item item = new Item(request);
        Item savedItem = itemRepository.save(item);
        ItemResponse response = savedItem.toResponse();
        return response;
    }

    public List<ItemResponse> getItems() {
        return itemRepository.findAll().stream().map(Item::toResponse).toList();
    }

    @Transactional
    public ItemResponse updateItem(Long id, ItemRequest request) {
        // 해당 메모가 DB에 존재하는지 확인
        Item item = findItem(id);
        item.update(request);
        return item.toResponse();
    }

    @Transactional
    public Response deleteItem(Long id) {
        // 해당 메모가 DB에 존재하는지 확인
        Item item = findItem(id);
        itemRepository.delete(item);
        return new Response("삭제완료");
    }

    private Item findItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }
}