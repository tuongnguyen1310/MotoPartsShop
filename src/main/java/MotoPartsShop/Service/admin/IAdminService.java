package MotoPartsShop.Service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MotoPartsShop.DTO.ProductsDto;
import MotoPartsShop.Entity.Categorys;
import MotoPartsShop.Entity.Menus;
import MotoPartsShop.Entity.Slides;
import MotoPartsShop.Entity.Users;

@Service
public interface IAdminService {
	@Autowired
	public List<Users> getAllUsers();
//	public boolean addUser(Users user);
//	public boolean updateUser(Users user);
//	public boolean deleteUser(int id);
	public List<Slides> getDataSlides();
	public List<Categorys> getDataCategorys();
	public List<Menus> getDataMenus();
	public List<ProductsDto> getDataNewProducts();
	public List<ProductsDto> getDataHighLightProducts();
	public List<ProductsDto> getDataProducts();
}
