package com.example.simplemarket.controller;

import com.example.simplemarket.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/post")
    public ItemResponse createMemo(@RequestBody ItemRequest request) {
        return itemService.createItem(request);
    }

    @GetMapping("/post")
    public List<ItemResponse> getMemos() {
        return itemService.getItems();
    }

    @PutMapping("/post/{id}")
    public ItemResponse updateMemo(@PathVariable Long id, @RequestBody ItemRequest requestDto) {
        return itemService.updateItem(id, requestDto);
    }

    @DeleteMapping("/post/{id}")
    public Response deleteMemo(@PathVariable Long id) {
        return itemService.deleteItem(id);
    }
}
