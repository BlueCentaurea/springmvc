package com.aaron.springmvc.service;

import java.util.List;
import com.aaron.springmvc.pojo.Item;


public interface ItemService {
	/**
	 * 查询商品列表
	 * @return
	 */
	List<Item> queryItemList();
	
	/**
	 * 根据id查询商品
	 * @param id
	 * @return
	 */
	Item queryItemById(Integer id);
	
	/**
	 * 更新商品
	 * @param item
	 */
	void updateItemById(Item item);
	
	List<Item> queryItemByItem(Item item);
}
