package MotoPartsShop.Controller.user;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import MotoPartsShop.DTO.CartDto;
import MotoPartsShop.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {
	@Autowired
	private CartServiceImpl cartServiceImpl = new CartServiceImpl();
	
	@RequestMapping(value = "AddCart/{id}")
	public String AddCart(HttpSession session, @PathVariable int id){
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = cartServiceImpl.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		return "redirect:/chi-tiet-san-pham/" + id;
	}
}
