package MotoPartsShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MotoPartsShop.DAO.ProductsDao;
import MotoPartsShop.DTO.ProductsDto;

@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	ProductsDao productsDao = new ProductsDao();
	
	public ProductsDto getAllProductsByID(int id){
		List<ProductsDto> list = productsDao.getAllProductsByID(id);
		return list.get(0);
	}
	
	public List<ProductsDto> getAllProductsByIDCategory(int id){
		List<ProductsDto> list = productsDao.GetDataAllProductsByIDCategory(id);
		return list;
	}
	
	public List<ProductsDto> getProducts() {
		List<ProductsDto> list = productsDao.GetDataProducts();
		return list;
	}

	@Override
	public List<ProductsDto> getDataProductsPaginate(int start, int totalPage) {
		List<ProductsDto> list = productsDao.GetProductsPaginates(start, totalPage);
		return list;
	}

}
