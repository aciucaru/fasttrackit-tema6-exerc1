package ro.fastrackit.tema6exerc1;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name = "n/a";
	private Double price = 0.0;
	private String description = "n/a";
	private ProductCategory category = ProductCategory.COMPUTERS;
	
	public Product(String name, Double price, String description, ProductCategory category)
//	public Product(String name, Double price, String description)
	{
		if(name != null)
			this.name = name;
		
		if(price != null)
			this.price = price;
		
		if(description != null)
			this.description = description;
		
		if(category != null)
			this.category = category;
	}
	
	public Product() // Spring cere un constructor default
	{
		this("n/a", 0.0, "n/a", ProductCategory.COMPUTERS);
	}
	
	// getteri:
	public Long getId() { return this.id; }
	public String getName() { return this.name; }
	public Double getPrice() { return this.price; }
	public String getDescription() { return this.description; }
	public ProductCategory getCategory() { return this.category; }
	
	// setteri:
	public void setId(Long id) { if(id != null) this.id = id; }
	public void setName(String name) { if(name != null) this.name = name; }
	public void setPrice(Double price) { if(price != null) this.price = price; }
	public void setDescription(String description) { if(description != null) this.description = description; }
	public void setCategory(ProductCategory category) { if(category != null) this.category = category; }
	
	@Override
	public boolean equals(Object otherObj)
	{
		boolean areEqual = false;
		
		if(otherObj != null)
		{
			if(otherObj instanceof Product)
			{
				Product otherProduct = (Product) otherObj;
				areEqual = Objects.equals(this.id, otherProduct.id) &&
						Objects.equals(this.name, otherProduct.name) &&
						Objects.equals(this.price, otherProduct.price) &&
						Objects.equals(this.description, otherProduct.description) &&
						Objects.equals(this.category, otherProduct.category);
			}
		}
		
		return areEqual;
	}
	
    @Override
    public int hashCode()
    {
        return Objects.hash(id, name, price, description, category);
//        return Objects.hash(id, name, price, description);
    }
}
