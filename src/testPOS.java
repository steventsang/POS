import junit.framework.TestCase;
public class testPOS extends TestCase {
	private IcecreamDecorator test;
	Icecream chocolateicecream = new IcecreamFlavour("Chocolate Icecream",20);
	Icecream vanillaicecream = new IcecreamFlavour("Vanilla Icecream",22);
	public void testPOS()
	{
		double expected = 24;
		Icecream strawberrydecorator = new IcecreamDecorator(chocolateicecream,"Strawberry",4);
		assertEquals(expected, strawberrydecorator.cost());
		expected = 27;
		Icecream MandMdecorator = new IcecreamDecorator(vanillaicecream,"M&M",5);
		assertEquals(expected, MandMdecorator.cost());
		expected = 30;
		Icecream peanutsdecorator = new  IcecreamDecorator(MandMdecorator,"Peanuts",3);
		assertEquals(expected, peanutsdecorator.cost());
	}
}