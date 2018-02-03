package com.aaron.springmvc.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aaron.springmvc.dao.ItemMapper;
import com.aaron.springmvc.pojo.Item;
import com.aaron.springmvc.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public List<Item> queryItemList() {
		List<Item> list = this.itemMapper.selectByExample(null);
		return list;
	}
}
