package MotoPartsShop.Controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import MotoPartsShop.Entity.Users;
import MotoPartsShop.Service.User.AccountServiceImpl;

@Controller
public class UserController extends BaseController {

    @Autowired 
    private AccountServiceImpl accountServiceImpl;  // Đã sửa: Không khởi tạo mới đối tượng

    /**
     * Xử lý ngoại lệ IllegalArgumentException và trả về trang đăng ký với thông báo lỗi.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView handleInvalidInputException(IllegalArgumentException ex) {
        ModelAndView mv = new ModelAndView("user/account/register");
        mv.addObject("status", ex.getMessage());
        mv.addObject("user", new Users()); // Reset form đăng ký
        return mv;
    }
    
    /**
     * Hiển thị trang đăng ký người dùng (GET).
     */
    @RequestMapping(value = "/dang-ky", method = RequestMethod.GET)
    public ModelAndView Register() {
        _mvShare.addObject("categories", _homeService.getDataCategorys());
        _mvShare.addObject("user", new Users());
        _mvShare.setViewName("user/account/register");
        return _mvShare;
    }
    
    /**
     * Xử lý đăng ký người dùng (POST).
     */
    @RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
    public ModelAndView CreateAcc(@ModelAttribute("user") Users user) {
        try {
            int count = accountServiceImpl.addAccount(user);
            if(count > 0) {
                _mvShare.addObject("status", "Đăng ký tài khoản thành công");
                _mvShare.addObject("user", new Users()); // Reset form đăng ký
            } else {
                _mvShare.addObject("status", "Đăng ký tài khoản thất bại");
            }
        } catch (IllegalArgumentException ex) {
            // Để @ExceptionHandler xử lý
            throw ex;
        } catch (Exception ex) {
            // Xử lý các ngoại lệ chung khác nếu cần
            _mvShare.addObject("status", "Đã có lỗi xảy ra. Vui lòng thử lại sau.");
        }
        _mvShare.addObject("categories", _homeService.getDataCategorys());
        _mvShare.setViewName("user/account/register");
        return _mvShare;
    }
    
    @RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
    public ModelAndView Login(HttpSession session , @ModelAttribute("user") Users user) {
        user = accountServiceImpl.checkAccount(user);
        if(user != null) {
            session.setAttribute("LoginInfo", user);
            if(user.getRole() == 1) {
            	_mvShare.setViewName("redirect:/admin");
            } else {
                _mvShare.setViewName("redirect:/home");
            }
        }
        else {
        	_mvShare.addObject("statusLogin", "Đăng nhập thất bại!");
		}
        _mvShare.addObject("categories", _homeService.getDataCategorys());
        
        return _mvShare;
    }
    
    @RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
    public String Login(HttpSession session , HttpServletRequest request) {
        session.removeAttribute("LoginInfo");
        
        return "redirect:"+request.getHeader("Referer");
    }
    
    
}
