package model;

public class Magazine extends Publication{
	private static final long serialVersionUID = -3194832839582684552L;
	
	private int month;
    private int day;
    private String language;
     
    public int getMonth() {
        return month;
    }
    
    public void setMonth(int month) {
        this.month = month;
    }
    
    public int getDay() {
        return day;
    }
    
    public void setDay(int day) {
        this.day = day;
    }
    
    public String getLanguage() {
        return language;
    }
    
    public void setLanguage(String language) {
        this.language = language;
    }
 
    public Magazine(String title, String publisher, String language, int year, int month, int day) {
    	super(year,title,publisher);
        setLanguage(language);
        setMonth(month);
        setDay(day);
    }
 
    @Override
    public String toString() {
    	StringBuilder builder = new StringBuilder(32);
    	builder.append(getTitle());
    	builder.append("; ");
    	builder.append(getPublisher());
    	builder.append("; ");
    	builder.append(getYear());
    	builder.append("; ");
    	builder.append(getMonth());
    	builder.append("; ");
    	builder.append(getDay());
    	builder.append("; ");
    	builder.append(getLanguage());
    	return builder.toString();
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + day;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + month;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Magazine other = (Magazine) obj;
		if (day != other.day)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (month != other.month)
			return false;
		return true;
	}
	
}
