package MotoPartsShop.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import MotoPartsShop.DTO.CartDto;
import MotoPartsShop.Entity.Bills;

@Service
public interface IBillsService {
	public int Addbills(Bills bill);
	public void AddBillsDetail(HashMap<Integer, CartDto> carts);
}
