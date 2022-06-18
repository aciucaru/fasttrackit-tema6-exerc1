package ro.fastrackit.tema6exerc1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ProductService
{
	private ProductRepository repository;
	
	public ProductService(ProductRepository repository)
	{
		if(repository != null)
			this.repository = repository;
	}
	
	public List<Product> getAll()
	{
		return repository.findAll();
	}
	
	// metoda comentata, deoarece nu apuca sa fie apelata niciodata (controller-ul are probleme)
	// aceasta metoda este pentru GET cu parametrii 'category' si 'maxPrice'
//	public List<Product> getAllBy(ProductCategory category, Double maxPrice)
//	{
//		List<Product> products = null;
//		System.out.println("service getAllBy(ProductCategory, Double)");
//		
//		if(category != null && maxPrice != null)
//		{
//			// prima data se filtreaza produsele dupa categorie
//			products = repository.findAll()
//							.stream()
//							.filter((Product product) -> product.getCategory().equals(category))
//							.collect(Collectors.toList());
//			
//			// apoi, daca 'maxPrice' este >= 0, produsele se filtreaza si dupa pretul maxim
//			if(maxPrice.compareTo(0.0) >= 0)
//			{
//				products = products.stream()
//									.filter((Product product) -> product.getPrice().compareTo(maxPrice) < 0.0)
//									.collect(Collectors.toList());
//			}
//			// altfel, nu se mai filtreaza si dupa pretul maxim				
//		}
//		else
//			products = new ArrayList<Product>(0);
//		
//		return products;
//	}
	
	public List<Product> getAllBy(Double maxPrice)
	{
		List<Product> products = null;
		
		if(maxPrice != null && maxPrice.compareTo(0.0) >= 0)
		{
			products = repository.findAll()
								.stream()
								.filter((Product product) -> product.getPrice().compareTo(maxPrice) < 0.0)
								.collect(Collectors.toList());
		}
		else
			products = new ArrayList<Product>(0);
		
		return products;
	}
	
	public List<Product> getAllBy(ProductCategory category)
	{
		List<Product> products = null;
		
		if(category != null)
		{
			products = repository.findAll()
							.stream()
							.filter((Product product) -> product.getCategory() == category)
							.collect(Collectors.toList());		
		}
		else
			products = new ArrayList<Product>(0);
		
		return products;
	}
	
	public Optional<Product> getById(Long id)
	{
		Optional<Product> optProduct = null;
		
		if(id != null)
			optProduct = repository.findById(id);
		else
			optProduct = Optional.ofNullable(null);
		
		return optProduct;
	}
	
	public Optional<Product> addProduct(Product product)
	{
		Optional<Product> optProduct = null;;
		
		if(product != null)
			optProduct = Optional.of(repository.save(product));
		else
			optProduct = Optional.of(null);
		
		return optProduct;
	}
	
	public Optional<Product> deleteProduct(Long id)
	{
		Optional<Product> optProduct = null;
		
		if(id != null)
		{
			optProduct = repository.findById(id);
			if(optProduct.isPresent())
				repository.delete(optProduct.get());
		}
		else
			optProduct = Optional.ofNullable(null);
		
		return optProduct;
	}
}
