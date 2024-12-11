package MotoPartsShop.Controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import MotoPartsShop.Controller.user.BaseController;
import MotoPartsShop.Entity.Users;
import MotoPartsShop.Service.admin.AdminServiceImpl;

@Controller
public class AdminController extends BaseController {

    @Autowired
    private AdminServiceImpl adminService;  // Giả sử bạn có một service cho admin

    @RequestMapping(value = "/admin")
    public ModelAndView showDashboard(HttpSession session) {
        if (session.getAttribute("LoginInfo") == null || ((Users) session.getAttribute("LoginInfo")).getRole() != 1) {
            return new ModelAndView("redirect:/dang-nhap");
        }
        _mvShare.addObject("users", adminService.getAllUsers());
        _mvShare.setViewName("admin/adminindex");  
        return _mvShare;
    }
    
    @RequestMapping(value = "/admin/usermanager")
    public ModelAndView userManager() {
        _mvShare.addObject("users", adminService.getAllUsers());
        _mvShare.setViewName("admin/user/user");  
        return _mvShare;
    }


}
