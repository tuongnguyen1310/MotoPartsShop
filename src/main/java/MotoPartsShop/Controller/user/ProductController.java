package MotoPartsShop.Controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import MotoPartsShop.DTO.PaginatesDto;
import MotoPartsShop.Service.User.PaginateServiceImpl;
import MotoPartsShop.Service.User.ProductServiceImpl;

@Controller
public class ProductController extends BaseController {

	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	@Autowired PaginateServiceImpl paginateServiceImpl;

	@RequestMapping(value = { "/chi-tiet-san-pham/{id}" })
	public ModelAndView Index(@PathVariable int id) {
		_mvShare.setViewName("user/products/product");
		_mvShare.addObject("product", productServiceImpl.getAllProductsByID(id));
		_mvShare.addObject("categories", _homeService.getDataCategorys());
		_mvShare.addObject("productByIDCategory", productServiceImpl.getAllProductsByIDCategory(productServiceImpl.getAllProductsByID(id).getId_category()));
		return _mvShare;
	}
	
	@RequestMapping(value = "/all-san-pham")
	public ModelAndView SanPham() {
		_mvShare.setViewName("user/products/allproduct");
		_mvShare.addObject("product", productServiceImpl.getProducts());
		int totalData = productServiceImpl.getProducts().size();
		PaginatesDto paginateInfo = paginateServiceImpl.getInfoPaginates(totalData, 9, 1); 
		_mvShare.addObject("paginateInfo", paginateInfo);
		return _mvShare;
	}
	
	@RequestMapping(value = "/all-san-pham/{currentPage}")
	public ModelAndView Product(@PathVariable String currentPage) {
		_mvShare.setViewName("user/products/allproduct");
		_mvShare.addObject("product", productServiceImpl.getProducts());
		int totalData = productServiceImpl.getProducts().size();
		PaginatesDto paginateInfo = paginateServiceImpl.getInfoPaginates(totalData, 9, Integer.parseInt(currentPage)); 
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("currentPage", currentPage);
		_mvShare.addObject("productsPaginate", productServiceImpl.getDataProductsPaginate( paginateInfo.getStart(), 9));
		return _mvShare;
	}

}
