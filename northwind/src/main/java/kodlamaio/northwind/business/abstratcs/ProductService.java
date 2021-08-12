package kodlamaio.northwind.business.abstratcs;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	
	DataResult<List<Product>> getAll();
	
	DataResult<List<Product>> getAllSort();
	
	DataResult<List<Product>> getAllWithPage(int pageNumber, int pageSize);
			
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategory(String productName, int category);
	
	DataResult<List<Product>>getByProductNameOrCategory_CategoryId(String productName, int category);
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}