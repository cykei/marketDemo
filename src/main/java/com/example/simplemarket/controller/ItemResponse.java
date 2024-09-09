package com.example.simplemarket.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemResponse {
    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;
}
