package MotoPartsShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MotoPartsShop.DAO.CategorysDao;
import MotoPartsShop.DAO.MenusDao;
import MotoPartsShop.DAO.ProductsDao;
import MotoPartsShop.DAO.SlidesDao;
import MotoPartsShop.DTO.ProductsDto;
import MotoPartsShop.Entity.Categorys;
import MotoPartsShop.Entity.Menus;
import MotoPartsShop.Entity.Slides;

@Service
public class HomeServiceImpl implements IHomeService{

	@Autowired
	private SlidesDao slidesDao;
	@Autowired
	private CategorysDao categorysDao;
	@Autowired
	private MenusDao menuDao;
	@Autowired
	private ProductsDao productsDao;
	
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
	
}
