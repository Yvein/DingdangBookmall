package book.bean;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象类
 */
public class Cart {
//    private Integer totalCount;
//    private BigDecimal totalPrice;
    /**
     * key:商品id
     * value：商品信息
     */
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();
//    private List<CartItem> items = new ArrayList<CartItem>();


    /**
     * 添加商品项
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        CartItem item = items.get(cartItem.getId());

        if(item==null) {
            //购物车中未添加过该商品
            items.put(cartItem.getId(), cartItem);
        }else {
            //购物车未添加过该商品
            item.setCount(item.getCount()+1);           //商品数量+1
            item.setTotalPrice(item.getTotalPrice().add(item.getPrice()));   //商品总价更新
        }
    }

    /**
     * 删除商品项
     * @param id
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clear(){
        items.clear();
    }

    /**
     * 修改商品数量
     * @param id
     * @param count
     */
    public void updateCount(Integer id, Integer count){
        CartItem cartItem = items.get(id);
        if(cartItem != null){
            if(count <= 0){
                deleteItem(id);
            }else {
                cartItem.setCount(count);
                cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(count)));
            }

        }
    }

//    /**
//     * 商品数量+1
//     */
//    public void plusCount(Integer id){
//        CartItem item = items.get(id);
//        Integer count = item.getCount() + 1;
//        if(count > 99){
//            count= 99;
//
//        }
//    }

//    /**
//     * 商品数量-1
//     */
//    public void minusCount(Integer id){
//
//    }

    public Cart() {
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;

        for (Map.Entry<Integer, CartItem> entry : items.entrySet()){
            totalCount += entry.getValue().getCount();
        }

        return totalCount;
    }
//
//    public void setTotalCount(Integer totalCount) {
//        this.totalCount = totalCount;
//    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);

        for (Map.Entry<Integer, CartItem> entry : items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }
//
//    public void setTotalPrice(BigDecimal totalPrice) {
//        this.totalPrice = totalPrice;
//    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

}
