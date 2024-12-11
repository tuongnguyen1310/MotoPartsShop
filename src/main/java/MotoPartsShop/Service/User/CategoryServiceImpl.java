package MotoPartsShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MotoPartsShop.DAO.ProductsDao;
import MotoPartsShop.DTO.ProductsDto;

@Service
public class CategoryServiceImpl implements ICategoryService{
	@Autowired
	private ProductsDao productsDao;
	
	
	@Override
	public List<ProductsDto> getAllProductsByIDCategory(int id) {
		return productsDao.GetDataAllProductsByIDCategory(id);
	}
	
	public List<ProductsDto> getDataProductsPaginate(int id, int start, int totalPage){
		List<ProductsDto> products = productsDao.GetDataAllProductsPaginates(id, start, totalPage);
		return products;
	}

	
	
	
}
