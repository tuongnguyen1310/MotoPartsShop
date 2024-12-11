package MotoPartsShop.Controller.user;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{
	
	@RequestMapping(value = { "/", "/home" })
	public ModelAndView Index() {
		_mvShare.addObject("slides", _homeService.getDataSlides());
		_mvShare.addObject("categories", _homeService.getDataCategorys());
		_mvShare.addObject("products", _homeService.getDataProducts());
		_mvShare.addObject("new_products", _homeService.getDataNewProducts());
		_mvShare.addObject("highlight_products", _homeService.getDataHighLightProducts());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}

	
	@RequestMapping(value =  "/thanh-toan-thanh-cong" )
	public ModelAndView XacNhanThanhToan() {
		_mvShare.addObject("categories", _homeService.getDataCategorys());
		_mvShare.addObject("products", _homeService.getDataProducts());
		_mvShare.setViewName("user/bills/billconfirm");
		return _mvShare;
	}
}
