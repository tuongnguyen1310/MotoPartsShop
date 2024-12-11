package MotoPartsShop.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import MotoPartsShop.DTO.ProductsDto;
import MotoPartsShop.DTO.ProductsDtoMapper;

@Repository
public class ProductsDao {
	@Autowired
	public JdbcTemplate _jdbcTemplate;
	
	private final boolean YES = true;
	private final boolean NO = false;

	private StringBuffer sqlString() {
		StringBuffer varname11 = new StringBuffer();
		varname11.append("SELECT ");
		varname11.append("    p.id as id_product, ");
		varname11.append("    p.id_category, ");
		varname11.append("    p.name, ");
		varname11.append("    p.price, ");
		varname11.append("    p.sale, ");
		varname11.append("    p.title, ");
		varname11.append("    p.highlight, ");
		varname11.append("    p.new_product, ");
		varname11.append("    p.detail, ");
		varname11.append("    c.id as id_color, ");
		varname11.append("    c.name as name_color, ");
		varname11.append("    c.code as code_color, ");
		varname11.append("    c.img, ");
		varname11.append("    p.created_at, ");
		varname11.append("    p.updated_at ");
		varname11.append("FROM ");
		varname11.append("    products AS p ");
		varname11.append("INNER JOIN ");
		varname11.append("    color AS c ");
		varname11.append("ON ");
		varname11.append("    p.id = c.id_product ");

		return varname11;
	}

	private String sqlProduct(boolean newProduct, boolean highlight) {
		StringBuffer sqlBuffer = sqlString();
		sqlBuffer.append("WHERE 1 = 1 ");
		if (highlight) {
			sqlBuffer.append("AND p.highlight = true ");
		}
		if (newProduct) {
			sqlBuffer.append("AND p.new_product = true ");
		}

		sqlBuffer.append("GROUP BY ");	
		sqlBuffer.append("    p.id, p.id_category, p.name, p.price, p.sale, p.title, p.highlight, p.new_product, p.detail, c.id, c.name, c.code, c.img, p.created_at, p.updated_at ");
		sqlBuffer.append("ORDER BY RAND() ");
		if (highlight == true) {
			sqlBuffer.append("LIMIT 9 ");
		}
		if (newProduct == true) {
			sqlBuffer.append("LIMIT 12 ");
		}
		return sqlBuffer.toString();
	}
	
	private StringBuffer sqlProductByIDCategory(int id) {
		StringBuffer sqlBuffer = sqlString();
		sqlBuffer.append("WHERE 1 = 1 ");
		sqlBuffer.append("AND id_category = " + id + " ");
		
		return sqlBuffer;
	}
	
	private StringBuffer sqlProductByPaginates(int id, int start, int totalPage) {
		StringBuffer sqlBuffer = sqlProductByIDCategory(id);
		sqlBuffer.append("LIMIT " + start + ", " + totalPage + " ");
		
		return sqlBuffer;
	}

	public List<ProductsDto> GetDataHighLightProducts() {
		String sqlString = sqlProduct(NO, YES);
		List<ProductsDto> list = _jdbcTemplate.query(sqlString, new ProductsDtoMapper());
		return list;
	}
	
	public List<ProductsDto> GetDataNewProducts() {
		String sqlString = sqlProduct(YES, NO);
		List<ProductsDto> list = _jdbcTemplate.query(sqlString, new ProductsDtoMapper());
		return list;
	}
	
	public StringBuffer sqlGetAllProduct() {
		StringBuffer sqlBuffer = sqlString();
		sqlBuffer.append("GROUP BY ");	
		sqlBuffer.append("    p.id, p.id_category, p.name, p.price, p.sale, p.title, p.highlight, p.new_product, p.detail, c.id, c.name, c.code, c.img, p.created_at, p.updated_at ");
		sqlBuffer.append("ORDER BY RAND() ");
		
		return sqlBuffer;
		
	}
	
	public StringBuffer sqlGetProducts(int start, int totalPage) {
		StringBuffer sqlBuffer = sqlString();
		sqlBuffer.append("LIMIT " + start + ", " + totalPage + " ");
		
		return sqlBuffer;
		
	}
	
	public List<ProductsDto> GetDataProducts() {
		String sqlString = sqlGetAllProduct().toString();
		List<ProductsDto> list = _jdbcTemplate.query(sqlString, new ProductsDtoMapper());
		return list;
	}


	public List<ProductsDto> GetProductsPaginates(int start, int totalPage) {
		String sqlString = sqlGetProducts(start, totalPage).toString();
		List<ProductsDto> listProducts = _jdbcTemplate.query(sqlString, new ProductsDtoMapper());
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		if(listProducts.size() > 0) {
			 list = _jdbcTemplate.query(sqlString, new ProductsDtoMapper());
		}
		return list;
	}

	
	public List<ProductsDto> GetDataAllProductsByIDCategory(int id) {
		String sqlString = sqlProductByIDCategory(id).toString();
		List<ProductsDto> list = _jdbcTemplate.query(sqlString, new ProductsDtoMapper());
		return list;
	}
	
	public List<ProductsDto> GetDataAllProductsPaginates(int id, int start, int totalPage) {
		StringBuffer sqlGetDataByID = sqlProductByIDCategory(id);
		List<ProductsDto> listProductsByID = _jdbcTemplate.query(sqlGetDataByID.toString(), new ProductsDtoMapper());
		List<ProductsDto> list = new ArrayList<ProductsDto>();
		if(listProductsByID.size() > 0) {
			String sqlString = sqlProductByPaginates(id, start, totalPage).toString();
			 list = _jdbcTemplate.query(sqlString, new ProductsDtoMapper());
		}
		return list;
	}

	private StringBuffer sqlProductByIDProduct(int id) {
		StringBuffer sqlBuffer = sqlString();
		sqlBuffer.append("WHERE 1 = 1 ");
		sqlBuffer.append("AND p.id = " + id + " ");
		sqlBuffer.append("LIMIT 1 ");
		
		
		return sqlBuffer;
	}
	
	public List<ProductsDto> getAllProductsByID(int id) {
		String sqlString = sqlProductByIDProduct(id).toString();
		List<ProductsDto> list = _jdbcTemplate.query(sqlString, new ProductsDtoMapper());
		return list;
	}
	
	public ProductsDto findProductsByID(int id) {
		String sqlString = sqlProductByIDProduct(id).toString();
		ProductsDto product = _jdbcTemplate.queryForObject(sqlString, new ProductsDtoMapper());
		return product;
	}
	
	
}
