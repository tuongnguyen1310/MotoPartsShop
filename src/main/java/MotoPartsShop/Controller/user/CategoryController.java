package MotoPartsShop.Controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CategoryController {
	
	@RequestMapping(value = "/san-pham/{id}")
	public ModelAndView Product(@PathVariable String id) {
		ModelAndView mView = new ModelAndView("user/products/category");
		mView.addObject("id_category", id);
		return mView;
	}
	
}
