package cn.zy.ssm.mapper;

import cn.zy.ssm.beans.Items;
import cn.zy.ssm.beans.ItemsCustom;
import cn.zy.ssm.beans.ItemsQueryVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsMapperCustom {

    // 商品查询列表
    List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;

    // 保存
    void saveItems(Items items) throws Exception;

}