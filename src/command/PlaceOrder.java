package command;

public class PlaceOrder {
	private String label;
	private Command command;
	
	public PlaceOrder(Command command) {
		this.command = command;
	}
	
	public void click() {
		command.execute();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
