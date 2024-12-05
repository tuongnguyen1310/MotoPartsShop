package MotoPartsShop.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MotoPartsShop.DAO.CartDao;
import MotoPartsShop.DTO.CartDto;

@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	private CartDao cartDao = new CartDao();

	@Override
	public HashMap<Integer, CartDto> AddCart(int id, HashMap<Integer, CartDto> cart) {
		// TODO Auto-generated method stub
		return cartDao.AddCart(id, cart);
	}

	@Override
	public HashMap<Integer, CartDto> EditCart(int id, int quanty, HashMap<Integer, CartDto> cart) {
		// TODO Auto-generated method stub
		return cartDao.EditCart(id, quanty, cart);
	}

	@Override
	public HashMap<Integer, CartDto> DeleteCart(int id, HashMap<Integer, CartDto> cart) {
		// TODO Auto-generated method stub
		return cartDao.DeleteCart(id, cart);
	}

	@Override
	public int totalQuanty(HashMap<Integer, CartDto> cart) {
		// TODO Auto-generated method stub
		return cartDao.totalQuanty(cart);
	}

	@Override
	public double totalPrice(HashMap<Integer, CartDto> cart) {
		// TODO Auto-generated method stub
		return cartDao.totalPrice(cart);
	}
	
}
