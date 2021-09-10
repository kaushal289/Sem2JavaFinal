package TechPrali;

public class Mobiledata {
	String username;
	String mobilename;
	String company;
	String ram;
	String storage;
	String price;
	String processor;
	String camera;
	String contact;
	public Mobiledata(String username, String mobilename, String company, String ram, String storage, String price,
			String processor, String camera, String contact) {
		super();
		this.username = username;
		this.mobilename = mobilename;
		this.company = company;
		this.ram = ram;
		this.storage = storage;
		this.price = price;
		this.processor = processor;
		this.camera = camera;
		this.contact = contact;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobilename() {
		return mobilename;
	}
	public void setMobilename(String mobilename) {
		this.mobilename = mobilename;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
