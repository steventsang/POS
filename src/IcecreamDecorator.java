public class IcecreamDecorator extends Icecream{
	protected Icecream icecream;
	public IcecreamDecorator(Icecream icecream, String DecoratorDescription, double DecoratorPrice){	
		this.description = icecream.getDescription() + " with " + DecoratorDescription;
		this.IcecreamPrice = icecream.cost() + DecoratorPrice;
	}
}
