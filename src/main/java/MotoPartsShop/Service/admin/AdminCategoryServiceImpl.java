package MotoPartsShop.Service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MotoPartsShop.DAO.CategorysDao;
import MotoPartsShop.DAO.ProductsDao;
import MotoPartsShop.DTO.ProductsDto;
import MotoPartsShop.Entity.Categorys;

@Service
public class AdminCategoryServiceImpl {

	@Autowired
	private CategorysDao categorysDao;
	
	@Autowired
	private ProductsDao productsDao;
	
	public List<ProductsDto> getAllProductsByIDCategory(int id) {
		return productsDao.GetDataAllProductsByIDCategory(id);
	}
	
	public List<Categorys> getDataCategorys() {
		// TODO Auto-generated method stub
		return categorysDao.GetDataCategorys();
	}

	public Categorys getCategoryById(int id) {
	    return categorysDao.getCategoryById(id);
	}

	public void saveCategory(Categorys category) {
		categorysDao.saveCategory(category);
	}

	public void deleteCategory(int id) {
		categorysDao.deleteCategory(id);
	}




}
