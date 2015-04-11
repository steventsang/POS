import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class SystemAdminInterface extends JFrame {
	private Icecream icecream;
	public SystemAdminInterface(MainPOSInterface MainPOS) {
		super("System Administrator");
		this.setSize(400, 150);
		this.setLocation(600, 100);
		this.setVisible(true);
		Container ContainerSysAdmin = getContentPane();
		JPanel JPanelSysAdmin = new JPanel();
		JPanelSysAdmin.setLayout(new GridLayout(3, 2));
		JLabel LabelDescription = new JLabel("Description:");
		JTextField TextFieldDescription = new JTextField();
		JLabel LabelPrice = new JLabel("Price:");
		JTextField TextFieldPrice = new JTextField();
		JButton ButtonNewFavour = new JButton("Create New Favour");
		JButton ButtonNewDecorator = new JButton("Create New Decorator");
		JPanelSysAdmin.add(LabelDescription);
		JPanelSysAdmin.add(TextFieldDescription);
		JPanelSysAdmin.add(LabelPrice);
		JPanelSysAdmin.add(TextFieldPrice);
		JPanelSysAdmin.add(ButtonNewFavour);
		JPanelSysAdmin.add(ButtonNewDecorator);
		ContainerSysAdmin.setLayout(new BorderLayout());
		ContainerSysAdmin.add(JPanelSysAdmin, BorderLayout.CENTER);
		ButtonNewFavour.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Icecream NewFavourIcecream = new IcecreamFlavour(TextFieldDescription.getText(),Double.parseDouble(TextFieldPrice.getText()));
					MainPOS.CreateNewFlavourButton(NewFavourIcecream.getDescription(),NewFavourIcecream.cost());
				}
			}
		);
		ButtonNewDecorator.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Icecream NewDecoratorIcecream = new NewDecorator(TextFieldDescription.getText(),Double.parseDouble(TextFieldPrice.getText()));
					MainPOS.CreateNewDecoratorButton(NewDecoratorIcecream.getDescription(),NewDecoratorIcecream.cost());
				}
			}
		);
	}
	
}