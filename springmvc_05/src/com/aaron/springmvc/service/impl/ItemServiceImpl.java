package com.aaron.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaron.springmvc.dao.ItemMapper;
import com.aaron.springmvc.pojo.Item;
import com.aaron.springmvc.pojo.ItemExample;
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

	@Override
	public Item queryItemById(Integer id) {
		return this.itemMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateItemById(Item item) {
		this.itemMapper.updateByPrimaryKey(item);
	}

	@Override
	public List<Item> queryItemByItem(Item item) {
		ItemExample itemExample = new ItemExample();
		
		ItemExample.Criteria criteria1 = itemExample.createCriteria();
		ItemExample.Criteria criteria2 = itemExample.createCriteria();
		
		// name模糊查询
		if (item.getName() != null)
		{
			criteria1.andNameLike(item.getName());
			itemExample.or(criteria1);
		}
		// id
		if (item.getId() != null) {
			criteria2.andIdEqualTo(item.getId());
			itemExample.or(criteria2);
		}
		
		return this.itemMapper.selectByExample(itemExample);
	}
}
