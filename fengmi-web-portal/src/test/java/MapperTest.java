import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ldb.FengmiWebPortalApplication;
import com.ldb.mapper.*;
import com.ldb.pojo.Category;
import com.ldb.pojo.MyPage;
import com.ldb.pojo.Product;
import com.ldb.pojo.ShoppingCart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author LiuDongBin
 * @Date 2023/11/09 16:24
 **/
@SpringBootTest(classes = FengmiWebPortalApplication.class)
public class MapperTest {
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Autowired
    private UserAddrMapper userAddrMapper;
    @Test
    public void categoryTest() {
        List<Category> categories = categoryMapper.selectAllCategory();
        System.out.println(categories);
    }
    @Test
    public void productTest(){
        System.out.println(productMapper.selectIntroduct(10));
    }
    @Test
    public void productTest2(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("category_id", 22);
        System.out.println(productMapper.selectList(queryWrapper));
    }
    @Test
    public void productTest3(){
        int pageNum = 1;
        int pageSize = 5;
        Page page = new Page(pageNum, pageSize);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("sold_num");
        queryWrapper.eq("category_id", 46);
        List<Product> products = productMapper.selectByCategoryId(46, 0, 5);
        productMapper.selectPage(page,queryWrapper);
        System.out.println(page.getRecords());
        page.setRecords(products);
        System.out.println(page);
    }
    @Test
    public void productTest4(){
        List<Product> products = productMapper.selectByCategoryId(46, 0, 5);
        System.out.println(products);
        productMapper.selectCount(null);
    }
    @Test
    public void usersTest1(){
        System.out.println(usersMapper.selectById(2));
    }
    @Test
    public void shoppingCartTest(){
        List<ShoppingCart> shoppingCarts = shoppingCartMapper.selectShoppingCartByUserId(2);
        for (ShoppingCart shoppingCart : shoppingCarts) {
            System.out.println(shoppingCart);

        }
    }
    @Test
    public void userAddrTest(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",2);
        queryWrapper.eq("common_addr",1);
        List list = userAddrMapper.selectList(queryWrapper);
        System.out.println(list);
    }
    @Test
    public void userAddrTest2(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id",2);
        queryWrapper.eq("common_addr",0);
        List list = userAddrMapper.selectList(queryWrapper);
        System.out.println(list);
    }
}
