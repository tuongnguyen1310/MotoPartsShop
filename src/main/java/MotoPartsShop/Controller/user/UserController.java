package MotoPartsShop.Controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import MotoPartsShop.Entity.RecaptchaResponse;
import MotoPartsShop.Entity.Users;
import MotoPartsShop.Service.User.AccountServiceImpl;

@Controller
public class UserController extends BaseController {

	@Autowired
	private AccountServiceImpl accountServiceImpl; // Đã sửa: Không khởi tạo mới đối tượng

	/**
	 * Xử lý ngoại lệ IllegalArgumentException và trả về trang đăng ký với thông báo
	 * lỗi.
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
			if (count > 0) {
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
	public ModelAndView Login(HttpServletRequest request, HttpSession session, @ModelAttribute("user") Users user) {
		try {
			// Lấy giá trị g-recaptcha-response từ request
			String recaptchaResponse = request.getParameter("g-recaptcha-response");

			// Xác thực reCAPTCHA
			if (!isCaptchaValid(recaptchaResponse)) {
				_mvShare.addObject("statusLogin", "Vui lòng xác thực reCAPTCHA.");
			} else {
				// Nếu reCAPTCHA hợp lệ, kiểm tra thông tin đăng nhập
				user = accountServiceImpl.checkAccount(user);
				if (user != null) {
					session.setAttribute("LoginInfo", user);
					if (user.getRole() == 1) {
						_mvShare.setViewName("redirect:/admin");
					} else {
						_mvShare.setViewName("redirect:/home");
					}
					return _mvShare; // Kết thúc nếu đăng nhập thành công
				} else {
					_mvShare.addObject("statusLogin", "Đăng nhập thất bại!");
				}
			}
		} catch (Exception ex) {
			_mvShare.addObject("statusLogin", "Đã xảy ra lỗi. Vui lòng thử lại sau.");
		}

		_mvShare.addObject("categories", _homeService.getDataCategorys());
		return _mvShare;
	}

	private boolean isCaptchaValid(String recaptchaResponse) {
		String secretKey = "6LcH9KIqAAAAAFEqQd06do1P8qKbyyWAcksVpijd"; // Thay bằng Secret Key từ Google
		String recaptchaVerifyUrl = "https://www.google.com/recaptcha/api/siteverify";

		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		requestParams.add("secret", secretKey);
		requestParams.add("response", recaptchaResponse); // Sử dụng biến recaptchaResponse

		// Gửi request xác thực reCAPTCHA
		RecaptchaResponse recaptchaResponseObj = restTemplate.postForObject(recaptchaVerifyUrl, requestParams,
				RecaptchaResponse.class);

		return recaptchaResponseObj != null && recaptchaResponseObj.isSuccess();
	}

	@RequestMapping(value = "/dang-xuat", method = RequestMethod.GET)
	public String Login(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("LoginInfo");

		return "redirect:" + request.getHeader("Referer");
	}

}
