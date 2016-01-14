package cn.zy.mybatis.controller;

import cn.zy.mybatis.beans.Items;
import cn.zy.mybatis.beans.ItemsCustom;
import cn.zy.mybatis.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 商品的
 * Created by [Zy]
 * 2015/12/31 14:14
 */
@Controller
// 为了对URL进行分类管理，可以在这里定义根路径，最终访问URL是根路径+子路径
// 比如：商品列表：/items/queryItems.action
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    // 商品查询
    @RequestMapping("/queryItems")
    public ModelAndView queryItems(HttpServletRequest request) throws Exception {
        //测试forward后request是否可以共享

        System.out.println(request.getParameter("id"));

        // 调用service查找 数据库，查询商品列表
        List<ItemsCustom> itemsList = itemsService.findItemsList(null);

        // 返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        // 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
        modelAndView.addObject("itemsList", itemsList);

        // 指定视图
        // 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，修改为
        // modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
        // 上边的路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
        modelAndView.setViewName("items/items-list");

        return modelAndView;

    }

    @RequestMapping("/save")
    public void saveItems() throws Exception {
        Items items = new Items();
        items.setName("abc");
        items.setPrice(20.00f);
        items.setCreatetime(new Date());

        this.itemsService.saveItems(items);
//        return "";
    }


    // 商品信息修改页面显示
//    @RequestMapping("editItems")
    // 限制http请求方法，可以POST或GET
   /* @RequestMapping(value = "/editItems", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView editItems() throws Exception {

        // 调用service根据商品id查询商品信息
        ItemsCustom itemsCustom = itemsService.findItemsById(1);

        // 返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();

        // 将商品信息放到model
        modelAndView.addObject("items", itemsCustom);

        // 商品修改页面
        modelAndView.setViewName("items/edit-items");

        return modelAndView;
    }*/

    // 重载上面方法
    @RequestMapping(value = "/editItems", method = {RequestMethod.POST, RequestMethod.GET})
    // @RequestParam里边指定request传入参数名称和形参进行绑定。
    // 通过required属性指定参数是否必须要传入
    // 通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
    public String editItems(Model model, @RequestParam(value = "id", required = true) Integer id) throws Exception {

        // 调用service根据商品id查询商品信息
        ItemsCustom itemsCustom = itemsService.findItemsById(id);

        // 通过形参中的Model将Model数据传到页面
        // 相当于modelAndView.addObject方法
        model.addAttribute("items", itemsCustom);
        return "items/edit-items";
    }


    // 商品信息修改提交
//    @RequestMapping("/editItemsSubmit")
    @RequestMapping(value = "/editItemsSubmit", method = {RequestMethod.POST, RequestMethod.GET})
    public String editItemsSubmit(HttpServletRequest request, Integer id, ItemsCustom itemsCustom) throws Exception {

        // 调用service更新商品信息，页面需要将商品信息传到此方法
        itemsService.updateItems(id, itemsCustom);


        // 重定向
//        return "redirect:queryItems.action";
        // 页面转发
//        return "forward:queryItems.action";
        return "success";
    }

}
