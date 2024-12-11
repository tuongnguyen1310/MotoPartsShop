package MotoPartsShop.Service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MotoPartsShop.DAO.CategorysDao;
import MotoPartsShop.DAO.MenusDao;
import MotoPartsShop.DAO.ProductsDao;
import MotoPartsShop.DAO.SlidesDao;
import MotoPartsShop.DAO.UsersDao;
import MotoPartsShop.DTO.ProductsDto;
import MotoPartsShop.Entity.Categorys;
import MotoPartsShop.Entity.Menus;
import MotoPartsShop.Entity.Slides;
import MotoPartsShop.Entity.Users;

@Service
public class AdminServiceImpl implements IAdminService{

	@Autowired
	private SlidesDao slidesDao;
	@Autowired
	private CategorysDao categorysDao;
	@Autowired
	private MenusDao menuDao;
	@Autowired
	private ProductsDao productsDao;
	@Autowired
	private UsersDao usersDao;
	
	public List<ProductsDto> getDataNewProducts() {
		List<ProductsDto> list = productsDao.GetDataNewProducts() ;
		return list;
	}
	
	public List<ProductsDto> getDataHighLightProducts() {
		List<ProductsDto> list = productsDao.GetDataHighLightProducts() ;
		return list;
	}
	
	public List<ProductsDto> getDataProducts() {
		List<ProductsDto> list = productsDao.GetDataProducts() ;
		return list;
	}
	
	public List<Slides> getDataSlides() {
		// TODO Auto-generated method stub
		return slidesDao.GetDataSlide();
	}

	public List<Categorys> getDataCategorys() {
		// TODO Auto-generated method stub
		return categorysDao.GetDataCategorys();
	}

	public List<Menus> getDataMenus() {
		// TODO Auto-generated method stub
		return menuDao.GetDataMenus();
	}

	public List<Users> getAllUsers() {
        return usersDao.getDataAllUser();
    }
	

//    public List<Users> getAllUsers() {
//        return userDao.GetDataProducts();
//    }
//
//    public Users getUserById(int id) {
//        return userDao.getUserById(id);
//    }
//
//    public boolean addUser(Users user) {
//        return userDao.addUser(user);
//    }
//
//    public boolean updateUser(Users user) {
//        return userDao.updateUser(user);
//    }
//
//    public boolean deleteUser(int id) {
//        return userDao.deleteUser(id);
//    }
}
