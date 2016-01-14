package cn.zy.mybatis.mapper;

import java.util.List;

import cn.zy.mybatis.beans.Items;
import cn.zy.mybatis.beans.ItemsCustom;
import cn.zy.mybatis.beans.ItemsQueryVo;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsMapperCustom {

    // 商品查询列表
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;

    // 保存
    void saveItems(Items items) throws Exception;

}