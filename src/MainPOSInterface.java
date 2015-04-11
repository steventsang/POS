import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class MainPOSInterface extends JFrame {
	public int NoofNewFlavour=0;
	public int NoofNewDecorator=0;
	public JPanel JPanelMain = new JPanel();
	public JPanel JPanelSelectFlavour = new JPanel();
	public JPanel JPanelSelectDecorator = new JPanel();
	public JButton ButtonNewIcecream = new JButton("New IceCream");
	public JButton ButtonSystemAdmin = new JButton("System Administrator");
	public JLabel LabelIcecream = new JLabel("Icecream:");
	public JTextField TextFieldIcecream = new JTextField();
	public JLabel LabelTotal = new JLabel("Total:");
	public JTextField TextFieldTotalPrice = new JTextField();
	public JLabel LabelIcecreamFlavor = new JLabel("ICE-CREAM Flavor");
	public JLabel LabelDecorator = new JLabel("Decorator"); 
	public JButton ButtonChocolate = new JButton("Chocolate,$20.0");
	public JButton ButtonMandM = new JButton("M&M,$5.0");
	public JButton ButtonVanilla = new JButton("Vanilla,$20.0");
	public JButton ButtonStrawberry = new JButton("Strawberry,$4.0");
	public Icecream icecream;
	public MainPOSInterface() {
		super("Point-of-Sales System");
		MainPOSInterface MainPOS = this;
		this.setSize(500, 220);
		this.setLocation(100, 100);
		this.setVisible(true);
		Container ContainerMain = getContentPane();
		JPanelMain.setLayout(new GridLayout(4, 2));
		JPanelMain.add(ButtonNewIcecream);
		JPanelMain.add(ButtonSystemAdmin);
		JPanelMain.add(LabelIcecream);
		JPanelMain.add(TextFieldIcecream);
		JPanelMain.add(LabelTotal);
		JPanelMain.add(TextFieldTotalPrice);
		JPanelMain.add(LabelIcecreamFlavor);
		JPanelMain.add(LabelDecorator);
		JPanelSelectFlavour.setLayout(new GridLayout(2, 1));
		JPanelSelectDecorator.setLayout(new GridLayout(2, 1));
		JPanelSelectFlavour.add(ButtonChocolate);
		JPanelSelectFlavour.add(ButtonVanilla);
		JPanelSelectDecorator.add(ButtonMandM);
		JPanelSelectDecorator.add(ButtonStrawberry);
		ContainerMain.setLayout(new BorderLayout());
		ContainerMain.add(JPanelMain, BorderLayout.NORTH);
		ContainerMain.add(JPanelSelectFlavour, BorderLayout.LINE_START);
		ContainerMain.add(JPanelSelectDecorator, BorderLayout.LINE_END);
		setVisible(true);
		ButtonNewIcecream.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					icecream = new IcecreamFlavour("-",0);
					TextFieldIcecream.setText("-");
					TextFieldTotalPrice.setText(String.valueOf(0));
				}
			}
		);
		ButtonChocolate.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						icecream = new IcecreamFlavour("Chocolate Icecream",20);

						TextFieldTotalPrice.setText(String.valueOf(icecream.cost()));
						TextFieldIcecream.setText(icecream.getDescription());
					}
				}
		);
		ButtonVanilla.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						icecream = new IcecreamFlavour("Vanilla Icecream",20);
						TextFieldTotalPrice.setText(String.valueOf(icecream.cost()));
						TextFieldIcecream.setText(icecream.getDescription());
					}
				}
		);
		ButtonMandM.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						icecream = new IcecreamDecorator(icecream, "M & M" ,5.0);
						TextFieldTotalPrice.setText(String.valueOf(icecream.cost()));
						TextFieldIcecream.setText(icecream.getDescription());
					}
				}
		);
		ButtonStrawberry.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						icecream = new IcecreamDecorator(icecream, "Strawberry" ,4.0);
						TextFieldTotalPrice.setText(String.valueOf(icecream.cost()));
						TextFieldIcecream.setText(icecream.getDescription());
					}
				}
		);
		ButtonSystemAdmin.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SystemAdminInterface SystemAdmin = new SystemAdminInterface(MainPOS);
					}
				}
		);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		public void CreateNewFlavourButton(String description,double price){
			NoofNewFlavour++;
			JPanelSelectFlavour.setLayout(new GridLayout(2+NoofNewFlavour, 1));
			this.setSize(500, 250 + (Math.max(NoofNewDecorator,NoofNewFlavour) * 40));
			JButton NewFlavourButton = new JButton(description+", $" + price);
			JPanelSelectFlavour.add(NewFlavourButton);
			TextFieldTotalPrice.setText(String.valueOf(price));
			TextFieldIcecream.setText(description);
			SwingUtilities.updateComponentTreeUI(this);
			NewFlavourButton.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							icecream = new IcecreamFlavour(description,price);
							TextFieldTotalPrice.setText(String.valueOf(icecream.cost()));
							TextFieldIcecream.setText(icecream.getDescription());
						}
					}
			);
		}
	public void CreateNewDecoratorButton(String description,double price){
		NoofNewDecorator++;
		JPanelSelectDecorator.setLayout(new GridLayout(2+NoofNewDecorator, 1));
		this.setSize(500, 250 + (Math.max(NoofNewDecorator,NoofNewFlavour) * 40));
		JButton NewDecoratorButton = new JButton(description+", $" + price);
		JPanelSelectDecorator.add(NewDecoratorButton);
		SwingUtilities.updateComponentTreeUI(this);
		NewDecoratorButton.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						icecream = new IcecreamDecorator(icecream, description,price);
						TextFieldTotalPrice.setText(String.valueOf(icecream.cost()));
						TextFieldIcecream.setText(icecream.getDescription());
					}
				}
		);
	}
}
