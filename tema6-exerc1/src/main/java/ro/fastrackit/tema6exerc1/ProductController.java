package ro.fastrackit.tema6exerc1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController
{
	private ProductService productService;
	
	public ProductController(ProductService productService)
	{
		this.productService = productService;
	}
	
	@GetMapping
	List<Product> getAll()
	{
		return productService.getAll();
	}
	
	// metoda comentata, deoarece nu functioneaza cu ambii parametrii ('category' si 'maxPrice') in acealsi timp
//	@GetMapping(value = "", params = "category, maxPrice")
//	public List<Product> getAllByCategoryAndMaxPrice
//							(@RequestParam("category") ProductCategory category,
//							 @RequestParam("maxPrice") Double maxPrice)
//	{
//		List<Product> products = null;
//		
//		if(category != null && maxPrice != null)
//			// se foloseste o metoda a service-ului ('getAllBy(category, maxPrice)') ca sa se returneze produsele dupa filtrare
//			products = productService.getAllBy(category, maxPrice);
//		else
//			// se initializeaza 'products' la un sir gol, ca sa nu se returneze null
//			products = new ArrayList<Product>(0);
//		
//		return products;
//	}
	
	@GetMapping(value = "", params = "maxPrice")
	List<Product> getAllByMaxPrice(@RequestParam("maxPrice") Double maxPrice)
	{
		List<Product> products = null;
		
		if(maxPrice != null)
			// se foloseste o metoda a service-ului ('getAllBy(category, maxPrice)') ca sa se returneze produsele dupa filtrare
			products = productService.getAllBy(maxPrice);
		else
			// se initializeaza 'products' la un sir gol, ca sa nu se returneze null
			products = new ArrayList<Product>(0);
		
		return products;
	}
	
	@GetMapping(value = "", params = "category")
	List<Product> getAllByCategory(@RequestParam("category") ProductCategory category)
	{
		List<Product> products = null;
		
		if(category != null)
			// se foloseste o metoda a service-ului ('getAllBy(category, maxPrice)') ca sa se returneze produsele dupa filtrare
			products = productService.getAllBy(category);
		else
			// se initializeaza 'products' la un sir gol, ca sa nu se returneze null
			products = new ArrayList<Product>(0);
		
		return products;
	}
	
	@GetMapping("{id}")
	Product getById(@PathVariable Long id)
	{
		Optional<Product> optProduct = productService.getById(id);
		
		if(optProduct.isPresent())
			return optProduct.get();
		else
			return null;
	}
	
	@PostMapping
	Product addProduct(@RequestBody Product product)
	{
		Optional<Product> optProduct = null;
		
		if(product != null)
			optProduct = productService.addProduct(product);
		
		if(optProduct.isPresent())
			return optProduct.get();
		else
			return null;
	}
	
	@DeleteMapping("{id}")
	Product deleteProduct(@PathVariable Long id)
	{
		Optional<Product> optProduct = null;
		
		if(id != null)
			optProduct = productService.deleteProduct(id);
		
		if(optProduct.isPresent())
			return optProduct.get();
		else
			return null;
	}
}
