package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    /**
     * mapper层本函数使用动态sql查询数据，使用update动态查询，复用函数
     *
     * @param category
     * @return void
     * @author TZzzQAQ
     * @create 2023/12/8
     **/
    @AutoFill(OperationType.UPDATE)
    void update(Category category);

    /**
     * mapper层实现删除功能
     *
     * @param id
     * @return void
     * @author TZzzQAQ
     * @create 2023/12/8
     **/
    @Delete("delete from category where id = #{id};")
    void deleteCategoryById(Long id);

    /**
     * 插入菜品，未使用动态sql语句
     *
     * @param category
     * @return void
     * @author TZzzQAQ
     * @create 2023/12/8
     **/
    @Insert("insert into category (type, name, sort, status, create_time, update_time, create_user, update_user) " +
            "values (#{type},#{name},#{sort},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser});")
    @AutoFill(OperationType.INSERT)
    void insertCategory(Category category);


    List<Category> getCategoryByType(Integer type);
}
