package MotoPartsShop.DAO;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import MotoPartsShop.DTO.CartDto;
import MotoPartsShop.DTO.ProductsDto;
@Repository
public class CartDao {
	
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	@Autowired
	private ProductsDao productsDao = new ProductsDao();
	
	public HashMap<Integer, CartDto> AddCart(int id, HashMap<Integer, CartDto> cart) {
		CartDto itemCartDto = new CartDto();
		ProductsDto product = productsDao.findProductsByID(id);
		if(product != null && cart.containsKey(id) == true) {
			itemCartDto = cart.get(id);
			itemCartDto.setQuanty(itemCartDto.getQuanty() + 1);
			itemCartDto.setTotalPrice(itemCartDto.getQuanty() * itemCartDto.getProduct().getPrice());
		} else {
			itemCartDto.setProduct(product);
			itemCartDto.setQuanty(1);
			double totalPrice = product.getPrice();
			itemCartDto.setTotalPrice(totalPrice);
		}
		cart.put(id, itemCartDto);
		return cart;
	}
	
	public HashMap<Integer, CartDto> EditCart(int id, int quanty, HashMap<Integer, CartDto> cart) {
		if(cart == null) {
			return cart;
		}
		CartDto itemCartDto = new CartDto();
		if(cart.containsKey(id) == true) {
			itemCartDto = cart.get(id);
			itemCartDto.setQuanty(quanty);
			itemCartDto.setTotalPrice(quanty * itemCartDto.getProduct().getPrice());
		}
		cart.put(id, itemCartDto);
		return cart;
	}
	
	public HashMap<Integer, CartDto> DeleteCart(int id, HashMap<Integer, CartDto> cart) {
		if(cart == null) {
			return cart;
		}
		if(cart.containsKey(id) == true) {
			cart.remove(id);
		}
		return cart;
	}
	
	public int totalQuanty(HashMap<Integer, CartDto> cart) {
		int totalQuanty = 0;
		for(Entry<Integer, CartDto> itemCart : cart.entrySet()) {
			totalQuanty += itemCart.getValue().getQuanty();
		}
		
		return totalQuanty;
	}
	
	public double totalPrice(HashMap<Integer, CartDto> cart) {
		int totalPrice = 0;
		for(Entry<Integer, CartDto> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		
		return totalPrice;
	}
}
