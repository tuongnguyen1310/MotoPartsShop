package MotoPartsShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import MotoPartsShop.DTO.ProductsDto;

@Service
public interface IProductService {
	public ProductsDto getAllProductsByID(int id);
	public List<ProductsDto> getAllProductsByIDCategory(int id);
}
