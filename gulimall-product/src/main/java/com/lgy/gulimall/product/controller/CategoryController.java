package com.lgy.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lgy.gulimall.product.entity.CategoryEntity;
import com.lgy.gulimall.product.service.CategoryService;
import com.lgy.common.utils.PageUtils;
import com.lgy.common.utils.R;



/**
 * 商品三级分类
 *
 * @author LGY
 * @email dlutlgy@163com
 * @date 2022-04-25 15:02:59
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 查出所有分类以及子分类，以树形结构组装起来
     */
    @RequestMapping("/list/tree")
    //@RequiresPermissions("product:category:list")
    public R list(){
        List<CategoryEntity> list = categoryService.listWithTree();

        return R.ok().put("data", list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    //@RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("data", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		//categoryService.updateById(category);
        categoryService.updateCascade(category);
        return R.ok();
    }

    /**
     * 删除
     * @RequestBody：获取请求体，必须发送POST请求
     * SpringMVC 自动请求 JSON ，转为对应的对象
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds){

        //categoryService.removeByIds(Arrays.asList(catIds));
        //1. 检查当前菜单是否背别的地方引用，
		categoryService.removeMenusByIds(Arrays.asList(catIds));
        return R.ok();
    }

}
