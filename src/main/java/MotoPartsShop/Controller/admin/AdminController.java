package MotoPartsShop.Controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import MotoPartsShop.Controller.user.BaseController;
import MotoPartsShop.Entity.Users;
import MotoPartsShop.Service.admin.AdminServiceImpl;

@Controller
@EnableWebMvc
@RequestMapping("/admin")
public class AdminController extends BaseController {

	@Autowired
	private AdminServiceImpl adminService;
	
	
	@RequestMapping(value = { "", "/" })
	public ModelAndView showDashboard(HttpSession session) {
		if (session.getAttribute("LoginInfo") == null || ((Users) session.getAttribute("LoginInfo")).getRole() != 1) {
			return new ModelAndView("redirect:/dang-nhap");
		}
		_mvShare.addObject("users", adminService.getAllUsers());
		_mvShare.setViewName("admin/adminindex");
		return _mvShare;
	}

	@RequestMapping(value = "/usermanager")
	public ModelAndView userManager() {
		_mvShare.addObject("users", adminService.getAllUsers());
		_mvShare.setViewName("admin/adminindex");
		return _mvShare;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editUser(@RequestParam("id") int id, 
	                       @RequestParam("username") String username, 
	                       @RequestParam("display_name") String displayName, 
	                       @RequestParam("address") String address, 
	                       @RequestParam("role") int role) {
	    // Tìm người dùng theo ID
	    Users userToEdit = adminService.getUserById(id);
	    
	    // Cập nhật thông tin người dùng
	    if (userToEdit != null) {
	        userToEdit.setUser(username);
	        userToEdit.setDisplay_name(displayName);
	        userToEdit.setAddress(address);
	        userToEdit.setRole(role);
	        
	        // Lưu thông tin người dùng đã chỉnh sửa
	        adminService.saveUser(userToEdit);
	    }
	    
	    // Chuyển hướng về trang quản lý người dùng
	    return "redirect:/admin";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addUser(@RequestParam("username") String username, 
	                      @RequestParam("password") String password,
	                      @RequestParam("display_name") String displayName, 
	                      @RequestParam("address") String address, 
	                      @RequestParam("role") int role) {
	    Users newUser = new Users();
	    newUser.setUser(username);
	    newUser.setPassword(BCrypt.hashpw(password, BCrypt.gensalt(12)));
	    newUser.setDisplay_name(displayName);
	    newUser.setAddress(address);
	    newUser.setRole(role);
	    
	    // Lưu người dùng mới vào cơ sở dữ liệu
	    adminService.saveUser(newUser);

	    // Chuyển hướng lại trang quản lý người dùng
	    return "redirect:/admin";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteUser(@RequestParam("id") int id) {
	    // Xóa người dùng khỏi cơ sở dữ liệu
	    adminService.deleteUser(id);

	    // Chuyển hướng lại trang quản lý người dùng
	    return "redirect:/admin/usermanager";
	}
	
	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
    public String Login(HttpSession session , HttpServletRequest request) {
        session.removeAttribute("LoginInfo");
        
        return "redirect:"+request.getHeader("Referer");
    }
	


}
