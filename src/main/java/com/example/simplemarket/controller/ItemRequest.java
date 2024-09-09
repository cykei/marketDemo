package com.example.simplemarket.controller;

import lombok.Getter;

@Getter
public class ItemRequest {
    private String username;
    private String title;
    private String content;
    private int price;
}
