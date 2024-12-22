package MotoPartsShop.Controller.user;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;

import MotoPartsShop.DTO.CartDto;
import MotoPartsShop.Entity.Bills;
import MotoPartsShop.Entity.Users;
import MotoPartsShop.Service.User.BillsServiceImpl;
import MotoPartsShop.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {
	@Autowired
	private CartServiceImpl cartServiceImpl = new CartServiceImpl();
	
	@Autowired
	private BillsServiceImpl billsServiceImpl = new BillsServiceImpl();
	
	@RequestMapping(value = "/gio-hang")
	public ModelAndView Index() {
		_mvShare.addObject("slides", _homeService.getDataSlides());
		_mvShare.addObject("categories", _homeService.getDataCategorys());
		_mvShare.addObject("products", _homeService.getDataProducts());
		_mvShare.addObject("new_products", _homeService.getDataNewProducts());
		_mvShare.addObject("highlight_products", _homeService.getDataHighLightProducts());
		_mvShare.setViewName("user/cart/list_cart");
		return _mvShare;
	}
	
	@RequestMapping(value = "/AddCart/{id}")
	public String AddCart(HttpServletRequest request , HttpSession session, @PathVariable int id){
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = cartServiceImpl.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("totalQuantyCart", cartServiceImpl.totalQuanty(cart));
		session.setAttribute("totalPriceCart", cartServiceImpl.totalPrice(cart));
//		return "redirect:/chi-tiet-san-pham/" + id;
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/EditCart/{id}/{quanty}")
	public String EditCart(HttpServletRequest request , HttpSession session, @PathVariable int id, @PathVariable int quanty){
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = cartServiceImpl.EditCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("totalQuantyCart", cartServiceImpl.totalQuanty(cart));
		session.setAttribute("totalPriceCart", cartServiceImpl.totalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request , HttpSession session, @PathVariable int id){
		HashMap<Integer, CartDto> cart = (HashMap<Integer, CartDto>)session.getAttribute("Cart");
		if(cart == null) {
			cart = new HashMap<Integer, CartDto>();
		}
		cart = cartServiceImpl.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("totalQuantyCart", cartServiceImpl.totalQuanty(cart));
		session.setAttribute("totalPriceCart", cartServiceImpl.totalPrice(cart));
//		return "redirect:/chi-tiet-san-pham/" + id;
		return "redirect:" + request.getHeader("Referer");
	}
	
	@RequestMapping(value = "/Checkout", method = RequestMethod.GET)
	public ModelAndView CheckOut(HttpServletRequest request , HttpSession session){
		_mvShare.setViewName("user/bills/checkout");
		Bills bill = new Bills();
		Users loginInfo = (Users)session.getAttribute("LoginInfo");
		if(loginInfo != null) {
			bill.setAddress(loginInfo.getAddress());
			bill.setDisplay_name(loginInfo.getDisplay_name());
			bill.setUser(loginInfo.getUser());
		}
		_mvShare.addObject("categories", _homeService.getDataCategorys());
		_mvShare.addObject("bills", bill);
		return _mvShare;
	}
	
	@RequestMapping(value = "/Checkout", method = RequestMethod.POST)
	public String CheckOutBill(HttpServletRequest request , HttpSession session, @ModelAttribute("bills") Bills bills){
		bills.setTotal(cartServiceImpl.totalPrice((HashMap<Integer, CartDto>)session.getAttribute("Cart")));
	    bills.setQuanty(cartServiceImpl.totalQuanty((HashMap<Integer, CartDto>)session.getAttribute("Cart")));
		
		if(billsServiceImpl.Addbills(bills) > 0) {
			HashMap<Integer, CartDto> carts = (HashMap<Integer, CartDto>)session.getAttribute("Cart");
			billsServiceImpl.AddBillsDetail(carts);
		}
		session.removeAttribute("Cart");
		session.removeAttribute("totalQuantyCart");
		session.removeAttribute("totalPriceCart");
		return "redirect:gio-hang";
	}

}
