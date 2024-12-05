package MotoPartsShop.Controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import MotoPartsShop.Service.User.ProductServiceImpl;

@Controller
public class ProductController extends BaseController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@RequestMapping(value = { "/chi-tiet-san-pham/{id}" })
	public ModelAndView Index(@PathVariable int id) {
		_mvShare.setViewName("user/products/product");
		_mvShare.addObject("product", productServiceImpl.getAllProductsByID(id));
		_mvShare.addObject("productByIDCategory", productServiceImpl.getAllProductsByIDCategory(productServiceImpl.getAllProductsByID(id).getId_category()));
		return _mvShare;
	}
}
