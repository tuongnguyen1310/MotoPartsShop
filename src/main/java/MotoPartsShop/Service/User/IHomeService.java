package MotoPartsShop.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import MotoPartsShop.DTO.ProductsDto;
import MotoPartsShop.Entity.Categorys;
import MotoPartsShop.Entity.Menus;
import MotoPartsShop.Entity.Slides;

@Service
public interface IHomeService {
	@Autowired
	public List<Slides> getDataSlides();
	public List<Categorys> getDataCategorys();
	public List<Menus> getDataMenus();
	public List<ProductsDto> getDataNewProducts();
	public List<ProductsDto> getDataHighLightProducts();
	public List<ProductsDto> getDataProducts();
}
