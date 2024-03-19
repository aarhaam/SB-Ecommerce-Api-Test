package com.mahardika.ecommerce.api.controller;

import static org.springframework.http.ResponseEntity.ok;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import java.util.*;

import com.mahardika.ecommerce.api.CartApi;
import com.mahardika.ecommerce.api.model.Cart;
import com.mahardika.ecommerce.api.model.Item;

import jakarta.validation.Valid;

public class CartController implements CartApi {

  private static final Logger log = LoggerFactory.getLogger(CartController.class);

  @Override
  public ResponseEntity<List<Item>> addCartItemsByCustomerId(String customerId, @Valid Item item){
    log.info("Request from customer Id");
    return ok(Collections.EMPTY_LIST);
  }

  @Override
  public ResponseEntity<List<Cart>> getCartByCustomerId(String customerId){
    throw new RuntimeException("Manual exception thrown");
  }

}
