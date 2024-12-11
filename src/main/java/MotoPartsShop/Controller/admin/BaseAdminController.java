package MotoPartsShop.Controller.admin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import MotoPartsShop.Service.admin.AdminServiceImpl;

public class BaseAdminController {
	@Autowired
	public AdminServiceImpl _adminServiceImpl;
	public ModelAndView _mvShare = new ModelAndView();
	
	@PostConstruct
	public ModelAndView Init() {
		_mvShare.addObject("user", _adminServiceImpl.getAllUsers());
		return _mvShare;
	}
}
