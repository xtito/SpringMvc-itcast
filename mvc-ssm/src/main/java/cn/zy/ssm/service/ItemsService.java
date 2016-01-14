package cn.zy.ssm.service;

import cn.zy.ssm.beans.Items;
import cn.zy.ssm.beans.ItemsCustom;
import cn.zy.ssm.beans.ItemsQueryVo;

import java.util.List;

/**
 * 商品管理service
 */
public interface ItemsService {
	
	//商品查询列表
	List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	//根据id查询商品信息
	/**
	 * 
	 * <p>Title: findItemsById</p>
	 * <p>Description: </p>
	 * @param id 查询商品的id
	 * @throws Exception
	 */
	ItemsCustom findItemsById(Integer id) throws Exception;
	
	//修改商品信息
	/**
	 * 
	 * <p>Title: updateItems</p>
	 * <p>Description: </p>
	 * @param id 修改商品的id
	 * @param itemsCustom 修改的商品信息
	 * @throws Exception
	 */
	void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception;

	void saveItems(Items items) throws Exception;
	

}
