package com.aaron.springmvc.service;

import java.util.List;
import com.aaron.springmvc.pojo.Item;


public interface ItemService {
	/**
	 * 查询商品列表
	 * @return
	 */
	List<Item> queryItemList();
}
