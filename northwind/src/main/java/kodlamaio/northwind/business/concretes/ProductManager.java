package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import kodlamaio.northwind.business.abstratcs.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;



@Service
public class ProductManager implements ProductService{

	private ProductDao productDao;

	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data Listelendi");
					
	}

	@Override
	public Result add(Product product) {
		productDao.save(product);
		return new SuccessResult("Ürün Eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName), "Urun Listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategory(String productName, int category) {
		
		return new SuccessDataResult<Product>(productDao.getByProductNameAndCategory_CategoryId(productName, category), "Urun Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int category) {
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName, category), "Urunler Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName), "Urunler Listelendi");
	}

	@Override
	public DataResult<List<Product>> getAllWithPage(int pageNumber, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent(), "Urunler Listelendi");
	}

	@Override
	public DataResult<List<Product>> getAllSort() {
		
		Sort sort = Sort.by(Sort.Direction.DESC, "productName");
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort), "Urunler Listelendi");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(), "Data Listelendi"); 
	}
	
	
}
