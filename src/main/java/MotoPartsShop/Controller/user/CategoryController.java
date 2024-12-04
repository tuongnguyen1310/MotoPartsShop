package MotoPartsShop.Controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import MotoPartsShop.DTO.PaginatesDto;
import MotoPartsShop.Service.User.CategoryServiceImpl;
import MotoPartsShop.Service.User.PaginateServiceImpl;


@Controller
public class CategoryController extends BaseController{
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@Autowired
	private PaginateServiceImpl paginateServiceImpl;

	private int totalProductsPage = 9;
	
	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView Product(@PathVariable String id) {
		_mvShare.setViewName("user/products/category");
		_mvShare.addObject("allProductsByIDCategory", categoryServiceImpl.getAllProductsByIDCategory(Integer.parseInt(id)));
		
		int totalData = categoryServiceImpl.getAllProductsByIDCategory(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = paginateServiceImpl.getInfoPaginates(totalData, totalProductsPage, 1); 
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categoryServiceImpl.getDataProductsPaginate(Integer.parseInt(id), paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
	
	@RequestMapping(value = "/san-pham/{id}/{currentPage}")
	public ModelAndView Product(@PathVariable String id,@PathVariable String currentPage) {
		_mvShare.setViewName("user/products/category");
		
		int totalData = categoryServiceImpl.getAllProductsByIDCategory(Integer.parseInt(id)).size();
		PaginatesDto paginateInfo = paginateServiceImpl.getInfoPaginates(totalData, totalProductsPage,Integer.parseInt(currentPage)); 
		_mvShare.addObject("currentPage", currentPage);
		_mvShare.addObject("idCategory", id);
		_mvShare.addObject("paginateInfo", paginateInfo);
		_mvShare.addObject("productsPaginate", categoryServiceImpl.getDataProductsPaginate(Integer.parseInt(id), paginateInfo.getStart(), totalProductsPage));
		return _mvShare;
	}
	
}
