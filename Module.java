package TabbedPane;

public class Module {
	private String title;
	private int credit;
	
	public Module(String title, int credit) {
		this.title = title;
		this.credit = credit;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getCredit() {
		return this.credit;
	}
}
