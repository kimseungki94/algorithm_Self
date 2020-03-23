package virus;

public class Corona extends Virus {
	private String spreadspeed;

	public Corona() {
		
	}

	public Corona(String name, int level, String spreadspeed) {
		super(name, level);
		this.spreadspeed = spreadspeed;
	}

	public String getSpreadspeed() {
		return spreadspeed;
	}

	public void setSpreadspeed(String spreadspeed) {
		this.spreadspeed = spreadspeed;
	}
	
}
