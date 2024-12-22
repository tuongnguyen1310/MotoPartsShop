package MotoPartsShop.Controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import MotoPartsShop.Entity.Categorys;
import MotoPartsShop.Service.admin.AdminCategoryServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminCategoryController extends BaseAdminController{
	
	@Autowired
	private AdminCategoryServiceImpl adminCategoryServiceImpl;
	
	@RequestMapping(value = "/danh-muc/{id}")
	public ModelAndView Product(@PathVariable("id") int id) {
		_mvShare.setViewName("admin/categorys/category_by_id");
		_mvShare.addObject("categories", adminCategoryServiceImpl.getDataCategorys());
		_mvShare.addObject("allProductsByIDCategory", adminCategoryServiceImpl.getAllProductsByIDCategory(id));
		_mvShare.addObject("idCategory", id);
		return _mvShare;
	}
	
	@RequestMapping(value = "/danh-muc")
	public ModelAndView Category() {
		_mvShare.addObject("categories", adminCategoryServiceImpl.getDataCategorys());
		_mvShare.setViewName("admin/categorys/category_manager");
		return _mvShare;
	}
	
	@RequestMapping(value = "/danh-muc/edit", method = RequestMethod.POST)
	public String editCategory(@RequestParam("id") int id,
	                           @RequestParam("name") String name,
	                           @RequestParam("description") String description) {
	    // Cập nhật danh mục
	    Categorys categoryToUpdate = adminCategoryServiceImpl.getCategoryById(id);
	    if (categoryToUpdate != null) {
	        categoryToUpdate.setName(name);
	        categoryToUpdate.setDescription(description);
	        adminCategoryServiceImpl.saveCategory(categoryToUpdate);
	    }
	    return "redirect:/admin/danh-muc";
	}
	
	@RequestMapping(value = "/danh-muc/delete", method = RequestMethod.POST)
	public String deleteBill(@RequestParam("id") int id) {
		// Xóa người dùng khỏi cơ sở dữ liệu
		adminCategoryServiceImpl.deleteCategory(id);

		// Chuyển hướng lại trang quản lý người dùng
		return "redirect:/admin/danh-muc";
	}

}
