package assignmentWeek18.Browser;

public enum Browsers {

	GOOGLE_CHROME("Chrome"), 
	EDGE("Edge"), 
	FIREFOX("Firefox");

	String name;

	private Browsers(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
