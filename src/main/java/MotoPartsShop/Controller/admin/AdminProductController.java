package MotoPartsShop.Controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import MotoPartsShop.DTO.PaginatesDto;
import MotoPartsShop.Service.User.PaginateServiceImpl;
import MotoPartsShop.Service.User.ProductServiceImpl;

@Controller
public class AdminProductController extends BaseAdminController{
	
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	@Autowired
	private PaginateServiceImpl paginateServiceImpl;
	
	@RequestMapping(value = "/admin/all-san-pham")
	public ModelAndView SanPham() {
		_mvShare.setViewName("admin/products/allproduct");
		_mvShare.addObject("product", productServiceImpl.getProducts());
		int totalData = productServiceImpl.getProducts().size();
		PaginatesDto paginateInfo = paginateServiceImpl.getInfoPaginates(totalData, 9, 1); 
		_mvShare.addObject("paginateInfo", paginateInfo);
		return _mvShare;
	}
	
	@RequestMapping(value = "/admin/all-san-pham/{currentPage}")
	public ModelAndView Product(@PathVariable String currentPage) {
		_mvShare.setViewName("admin/products/allproduct");
		_mvShare.addObject("product", productServiceImpl.getProducts());
		int totalData = productServiceImpl.getProducts().size();
		PaginatesDto paginateInfo = paginateServiceImpl.getInfoPaginates(totalData, 9, Integer.parseInt(currentPage)); 
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("currentPage", currentPage);
		_mvShare.addObject("productsPaginate", productServiceImpl.getDataProductsPaginate( paginateInfo.getStart(), 9));
		return _mvShare;
	}
}
