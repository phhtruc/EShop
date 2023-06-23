/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author t
 */
//giỏ hàng
public class Cart {
//    danh sách các sản phẩm có trong giỏ hàng
    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }
    
//    get item để trả về toàn bộ các giỏ hàng
    public List<Item> getItems() {
        return items;
    }
    
//    tìm và trả về các item có trong giỏ hàng khi biết id của nó
    private Item getItemById(int id){
        for (Item i : items) {
            if(i.getProduct().getId() == id){
                return i;
            }
        }
        return null;
    }
    
//    trả về số lượng của 1 sản phẩm để check xem còn hàng hay không
    public int getQuantityById(int id){
        return getItemById(id).getQuantity();
    }
    
//    thêm sản phẩm vào giỏ hàng
    public void addItem(Item t){
        //kiểm tra sản phẩm tồn tại trong giỏ hàng chưa, có thì cộng thêm số lượng sp
        if(getItemById(t.getProduct().getId()) != null){
            //trả về sp có trong giỏ hàng
            Item m = getItemById(t.getProduct().getId());
            //tăng số lượng(số lươnjg cũ + có t vừa mới thêm
            m.setQuantity(m.getQuantity() + t.getQuantity());
        }else
            //ngược lại thì thêm vào giỏ hàng
            items.add(t);
    }
    
    // xóa sản phẩm
    public void removeItem(int id){
        if(getItemById(id) != null){
            items.remove(getItemById(id));
        }
    }
    
    // tính tổng tiền
    public double getTotalMoney(){
        double t = 0;
        for (Item item : items) {
            t += (item.getQuantity()*item.getPrice());
        }
        return t;
    }
    
    // trả về 1 sản phẩm 
    private Product getProductById(int id, List<Product> list){
        for (Product p : list) {
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
    
    //trả về danh sách chứa các items đọc từ cookie ra  
    public Cart(String txt, List<Product> list) {
        items = new ArrayList<>();
        try {
            if (txt != null && txt.length() != 0) {
                //tách ra từng sản phẩm trong txt cookie
                String[] s = txt.split("/");
                for (String i : s) {
                    //tách ra từng id và số lượng trong từng sản phẩm(1:2)
                    String[] n = i.split(":");
                    int id = Integer.parseInt(n[0]);
                    int quantity = Integer.parseInt(n[1]);
                    Product p = getProductById(id, list);
                    Item t = new Item(p, quantity, p.getPrice()*2);
                    addItem(t);
                }
            }
        } catch (NumberFormatException e) {

        }
    }
    
}
