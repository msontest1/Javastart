package app;

public enum Option {
	EXIT(0 ,"Wyjœcie z programu"),
	ADD_BOOK(1 , "Dodaj ksi¹¿ke"),
	ADD_MAGAZINE(2 , "Dodaj magazyn"),
	PRINT_BOOKS(3 , "Poka¿ ksi¹¿ki"),
	PRINT_MAGAZINS(4 , "Poka¿ magazyny");
	
	private int value;
	private String description;
	
	Option(int value, String description) {
		this.value = value;
		this.description = description;
	}

	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
	
	public static Option createFromInt(int option) {
		return Option.values()[option];
	}
	
	@Override
	public String toString() {
		return value + " - " + description;
	}
}
