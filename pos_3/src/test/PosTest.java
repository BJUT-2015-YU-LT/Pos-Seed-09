package test;

import domains.*;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/1/5.
 */
public class PosTest {

    @Test
    public void test1SingleItemForReq6() throws Exception {
        // given
        ShoppingChart shoppingChart = new ShoppingChart();
        shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00, 1, false, 0.9));

        ShoppingListChart shoppingListChart = new ShoppingListChart(shoppingChart);
        Pos pos = new Pos();
        String result = pos.getShoppingList(shoppingListChart);
        UsersManager usersManager = new UsersManager();
        String resultName = usersManager.getUserName();
        int resultIntegral = usersManager.getIntegral(usersManager.getUserName());
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
        String currentTime = simpleDateFormat.format(calendar.getTime());


        // then
        String expectedShoppingList = new String();
        expectedShoppingList =
                "***商店购物清单***\n"
                        + "会员编号：" + resultName + "    会员积分：" + resultIntegral + "\n"
                        + "----------------------\n"
                        + "打印时间：" + currentTime + "\n"
                        + "----------------------\n"
                        + "名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：2.70(元)\n"
                        + "----------------------\n"
                        + "总计：2.70(元)\n"
                        + "节省：0.30(元)\n"
                        + "**********************\n";
        assertThat(result, is(expectedShoppingList));
    }

    @Test
    public void test2SingleItemForReq6() throws Exception {
        // given
        ShoppingChart shoppingChart = new ShoppingChart();
        shoppingChart.add(new Item("ITEM000001", "雪碧", "瓶", 3.00, 0.8, false, 0.95));

        ShoppingListChart shoppingListChart = new ShoppingListChart(shoppingChart);
        Pos pos = new Pos();
        String result = pos.getShoppingList(shoppingListChart);
        UsersManager usersManager = new UsersManager();
        String resultName = usersManager.getUserName();
        int resultIntegral = usersManager.getIntegral(usersManager.getUserName());
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
        String currentTime = simpleDateFormat.format(calendar.getTime());


        // then
        String expectedShoppingList = new String();
        expectedShoppingList =
                "***商店购物清单***\n"
                        + "会员编号：" + resultName + "    会员积分：" + resultIntegral + "\n"
                        + "----------------------\n"
                        + "打印时间：" + currentTime + "\n"
                        + "----------------------\n"
                        + "名称：雪碧，数量：1瓶，单价：3.00(元)，小计：2.28(元)\n"
                        + "----------------------\n"
                        + "总计：2.28(元)\n"
                        + "节省：0.72(元)\n"
                        + "**********************\n";
        assertThat(result, is(expectedShoppingList));
    }

    @Test
    public void test3SingleItemForReq6() throws Exception {
        // given
        ShoppingChart shoppingChart = new ShoppingChart();
        shoppingChart.add(new Item("ITEM000003", "电池", "个", 1.00, 1, true, 1.0));

        ShoppingListChart shoppingListChart = new ShoppingListChart(shoppingChart);
        Pos pos = new Pos();
        String result = pos.getShoppingList(shoppingListChart);
        UsersManager usersManager = new UsersManager();
        String resultName = usersManager.getUserName();
        int resultIntegral = usersManager.getIntegral(usersManager.getUserName());
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
        String currentTime = simpleDateFormat.format(calendar.getTime());


        // then
        String expectedShoppingList = new String();
        expectedShoppingList =
                "***商店购物清单***\n"
                        + "会员编号：" + resultName + "    会员积分：" + resultIntegral + "\n"
                        + "----------------------\n"
                        + "打印时间：" + currentTime + "\n"
                        + "----------------------\n"
                        + "名称：电池，数量：1个，单价：1.00(元)，小计：1.00(元)\n"
                        + "----------------------\n"
                        + "总计：1.00(元)\n"
                        + "**********************\n";
        assertThat(result, is(expectedShoppingList));
    }

    @Test
    public void testGetCorrectShoppingListFor0to200MultiItem1ForReq6() throws Exception {
        // given
        ShoppingChart shoppingChart = new ShoppingChart();
        shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00, 1, false, 0.9));
        shoppingChart.add(new Item("ITEM000002", "电池", "个", 1.00, 1, true, 1));
        shoppingChart.add(new Item("ITEM000002", "电池", "个", 1.00, 1, true, 1));
        shoppingChart.add(new Item("ITEM000002", "电池", "个", 1.00, 1, true, 1));


        // when
        ShoppingListChart shoppingListChart = new ShoppingListChart(shoppingChart);
        Pos pos = new Pos();
        String result = pos.getShoppingList(shoppingListChart);
        UsersManager usersManager = new UsersManager();
        String resultName = usersManager.getUserName();
        int resultIntegral = usersManager.getIntegral(usersManager.getUserName());
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
        String currentTime = simpleDateFormat.format(calendar.getTime());


        // then
        String expectedShoppingList = new String();
        expectedShoppingList =
                "***商店购物清单***\n"
                        + "会员编号：" + resultName + "    会员积分：" + resultIntegral + "\n"
                        + "----------------------\n"
                        + "打印时间：" + currentTime + "\n"
                        + "----------------------\n"
                        + "名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：2.70(元)\n"
                        + "名称：电池，数量：3个，单价：1.00(元)，小计：2.00(元)\n"
                        + "----------------------\n"
                        + "挥泪赠送商品:\n"
                        + "名称：电池，数量：1个\n"
                        + "----------------------\n"
                        + "总计：4.70(元)\n"
                        + "节省：1.30(元)\n"
                        + "**********************\n";
        assertThat(result, is(expectedShoppingList));
    }
    @Test
    public void testnotVIP() throws Exception {
        // given
        ShoppingChart shoppingChart = new ShoppingChart();
        shoppingChart.add(new Item("ITEM000000", "可口可乐", "瓶", 3.00, 1, false, 0.9));

        ShoppingListChart shoppingListChart = new ShoppingListChart(shoppingChart);
        Pos pos = new Pos();
        String result = pos.getShoppingList(shoppingListChart);
        UsersManager usersManager = new UsersManager();
        String resultName = usersManager.getUserName();
        int resultIntegral = usersManager.getIntegral(usersManager.getUserName());
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日hh时mm分ss秒");
        String currentTime = simpleDateFormat.format(calendar.getTime());


        // then
        String expectedShoppingList = new String();
        expectedShoppingList =
                "***商店购物清单***\n"
                        + "打印时间：" + currentTime + "\n"
                        + "----------------------\n"
                        + "名称：可口可乐，数量：1瓶，单价：3.00(元)，小计：3.00(元)\n"
                        + "----------------------\n"
                        + "总计：3.00(元)\n"
                        + "**********************\n";
        assertThat(result, is(expectedShoppingList));
    }


}