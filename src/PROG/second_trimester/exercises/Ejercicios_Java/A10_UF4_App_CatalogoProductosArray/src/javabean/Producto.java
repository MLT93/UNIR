/**
 * this name-space (package) javabean (without main class)
 */
package javabean;

/**
 * Class Producto
 */
public class Producto {

	/**
	 * Attributes
	 */
	private long longBarcode;
	private String strDescription;
	private double dblePrice;
	private int intStock;
	private String strSize;
	private String strColor;

	/**
	 * Constructor & Constructor Overloaded
	 */
	public Producto() {
		super();
	}

	public Producto(long longBarcode, String strDescription, double dblePrice, int intStock, String strSize,
			String strColor) {
		super();
		this.longBarcode = longBarcode;
		this.strDescription = strDescription;
		this.dblePrice = dblePrice;
		this.intStock = intStock;
		this.strSize = strSize;
		this.strColor = strColor;
	}

	/**
	 * Getters & Setters
	 */
	public long getLongBarcode() {
		return longBarcode;
	}

	public void setLongBarcode(long longBarcode) {
		this.longBarcode = longBarcode;
	}

	public String getStrDescription() {
		return strDescription;
	}

	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
	}

	public double getDblePrice() {
		return dblePrice;
	}

	public void setDblePrice(double dblePrice) {
		this.dblePrice = dblePrice;
	}

	public int getIntStock() {
		return intStock;
	}

	public void setIntStock(int intStock) {
		this.intStock = intStock;
	}

	public String getStrSize() {
		return strSize;
	}

	public void setStrSize(String strSize) {
		this.strSize = strSize;
	}

	public String getStrColor() {
		return strColor;
	}

	public void setStrColor(String strColor) {
		this.strColor = strColor;
	}

	/**
	 * toString
	 */
	// @Override

	// Generar al final

	/**
	 * Methods
	 */
	public double priceWithIVA(int iva) {
		return this.dblePrice * (1 + iva / 100.00);
	}

	public void increaseStock(int quantity) {
		int stock = this.getIntStock();
		this.setIntStock(stock + quantity);
	}

	public boolean decreaseStock(int quantity) {
		int stock = this.getIntStock();
		int newValue = stock - quantity;
		if (newValue < 0) {
			return false;
		} else {
			this.setIntStock(newValue);
			return true;
		}
	}

	public double appliedPrice() {
		String size = this.getStrSize();
		switch (size) {
		case "XS":
			return this.getDblePrice();
		case "S":
		case "M":
			return this.getDblePrice() * (1 + 3 / 100.00);
		case "L":
		case "XL":
			return this.getDblePrice() * (1 + 3 / 100.00);
		case "XXL":
		case "XXXL":
			return this.getDblePrice() * (1 + 4 / 100.00);
		default:
			System.out.println("La talla aplicada es incorrecta");
			return 1000000000.0;
		}
	}

	/**
	 * Methods Overloaded
	 */
}
