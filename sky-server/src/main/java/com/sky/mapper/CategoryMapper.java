package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CategoryMapper {
    /**
     * mapper层本函数使用动态sql语句查询数据
     *
 * @param categoryPageQueryDTO
     * @return com.github.pagehelper.Page<com.sky.entity.Category>
     * @author TZzzQAQ
     * @create 2023/12/8
     **/
    Page<Category> getAllCategory(CategoryPageQueryDTO categoryPageQueryDTO);
}
