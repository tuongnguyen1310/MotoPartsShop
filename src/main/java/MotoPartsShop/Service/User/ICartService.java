package MotoPartsShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import MotoPartsShop.DTO.CartDto;

@Service
public interface ICartService {
	public HashMap<Integer, CartDto> AddCart(int id, HashMap<Integer, CartDto> cart);
	public HashMap<Integer, CartDto> EditCart(int id, int quanty, HashMap<Integer, CartDto> cart);
	public HashMap<Integer, CartDto> DeleteCart(int id, HashMap<Integer, CartDto> cart);
	public int totalQuanty(HashMap<Integer, CartDto> cart);
	public double totalPrice(HashMap<Integer, CartDto> cart);
}
