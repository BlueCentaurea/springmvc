package com.aaron.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.aaron.springmvc.pojo.Item;
import com.aaron.springmvc.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping("itemList")
	public ModelAndView queryItemList() {
		List<Item> list = this.itemService.queryItemList();
		// 创建ModelAndView，用来存放数据和视图
		ModelAndView modelAndView = new ModelAndView();
		// 设置数据到模型中
		modelAndView.addObject("itemList", list);
		// 设置视图jsp，需要设置视图的物理地址
		modelAndView.setViewName("itemList");

		return modelAndView;
	}

	@RequestMapping("itemEdit")
	public ModelAndView queryItemById(HttpServletRequest request) {
		// 获取商品数据
		String id = request.getParameter("id");
		Item item = this.itemService.queryItemById(Integer.valueOf(id));

		ModelAndView modelAndView = new ModelAndView();
		// 把商品数据放到模型中
		modelAndView.addObject("item", item);
		// 设置逻辑视图
		modelAndView.setViewName("editItem");

		return modelAndView;
	}

	@RequestMapping("updateItem")
	public String updateItem(Item item) {
		this.itemService.updateItemById(item);
		return "itemList";
	}

	@RequestMapping("queryItem")
	public ModelAndView queryItemByItem(HttpServletRequest request, Item item ) {
		List<Item> items = this.itemService.queryItemByItem(item);

		ModelAndView modelAndView = new ModelAndView();
		// 把商品数据放到模型中
		modelAndView.addObject("itemList", items);
		// 设置逻辑视图
		modelAndView.setViewName("itemList");

		return modelAndView;
	}
}
