public class NewDecorator extends Icecream{
	protected double DecoratorPrice;
	public NewDecorator(String description, double price){
			this.description = description;
			this.DecoratorPrice = price; 
	}
	public double cost(){
		return DecoratorPrice;
	}
}
