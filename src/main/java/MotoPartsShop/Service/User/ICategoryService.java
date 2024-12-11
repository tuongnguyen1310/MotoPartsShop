package MotoPartsShop.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import MotoPartsShop.DTO.ProductsDto;

@Service
public interface ICategoryService {
	public List<ProductsDto> getDataProductsPaginate(int id, int start, int totalPage);
	public List<ProductsDto> getAllProductsByIDCategory(int id);
}
