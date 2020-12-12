package datamodels;

public class MobileAnalytics implements java.io.Serializable{
	private Integer id;
	private String name;
	private String use_type;
	private String type;
	private String where_to_buy;
	private String brand;
	private String price;
	private String display;
	private String box_type;
	
	public MobileAnalytics() {
		
	}

	public MobileAnalytics(Integer id, String name, String use_type, String type, String where_to_buy, String brand,
			String price, String display, String box_type) {
		super();
		this.id = id;
		this.name = name;
		this.use_type = use_type;
		this.type = type;
		this.where_to_buy = where_to_buy;
		this.brand = brand;
		this.price = price;
		this.display = display;
		this.box_type = box_type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUse_type() {
		return use_type;
	}

	public void setUse_type(String use_type) {
		this.use_type = use_type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWhere_to_buy() {
		return where_to_buy;
	}

	public void setWhere_to_buy(String where_to_buy) {
		this.where_to_buy = where_to_buy;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public String getBox_type() {
		return box_type;
	}

	public void setBox_type(String box_type) {
		this.box_type = box_type;
	}

	
	
}
