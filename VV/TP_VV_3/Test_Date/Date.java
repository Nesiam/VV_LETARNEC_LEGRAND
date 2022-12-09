package fr.istic.vv;

class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { }
	int day;
	int month;
	int year;

    public Date(int day, int month, int year) throws IllegalArgumentException{
    	if (isValidDate(day,month,year)){
    		this.day=day;
    		this.month=month;
    		this.year=year;
    	}
    	else{
			throw new IllegalArgumentException("Date non valide");
		}
    }

    public static boolean isValidDate(int day, int month, int year) { return false; }

    public static boolean isValidDate(int day, int month, int year) {
    	if(isLeapYear(year) && month==2){
    		if(0<day && day<30) {
    			return true;
    			}
    		else {
    			return false;
    			}
    		}
    	else {
    		if(month>12 || month<1) {
    			return false;
    		}
			if(month<8){
    			if(month%2==0) {
    				if(month==2) {
    					if(0<day && day<29) {
    						return true;
    					}
    					else {
    						return false;
    					}
    				}
					if(0<day && day<31) {
						return true;
					}
					else {
						return false;
					}
				}
				else {
					if(0<day && day<32) {
						return true;
					}
    				else {
    					return false;
    				}
    			}
   		 	}
			else{
				if(month%2==0) {
					if(0<day && day<32) {
						return true;
					}
					else {
						return false;
					}
				}
				else {
					if(0<day && day<31) {
						return true;
					}
    				else {
    					return false;
    				}
    			}
			}
		}
  	  }

    public static boolean isLeapYear(int year) { return false; }

    public Date nextDate() { return null; }
    public static boolean isLeapYear(int year) { 
    	if(year%400==0) {
    		return true;
    	}
    	if(year%100==0) {
    		return false;
    	}
    	if(year%4==0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    public Date nextDate() { 
    	if(isValidDate(this.day+1,this.month,this.year)) {
    		return new Date(this.day+1,this.month,this.year);
    	}
    	if(isValidDate(1,this.month+1,this.year)) {
    		return new Date(1,this.month+1,this.year);
    	}
    	else {
    		return new Date(1,1,this.year+1);
    	}
    }

    public Date previousDate() { return null; }
    public Date previousDate() { 
    	if(isValidDate(this.day-1,this.month,this.year)) {
    		return new Date(this.day-1,this.month,this.year);
    	}
		if(isValidDate(31,this.month-1,this.year)) {
    		return new Date(31,this.month-1,this.year);
    	}
    	if(isValidDate(30,this.month-1,this.year)) {
    		return new Date(30,this.month-1,this.year);
    	}
    	if(isValidDate(29,this.month-1,this.year)) {
    		return new Date(29,this.month-1,this.year);
    	}
    	if(isValidDate(28,this.month-1,this.year)) {
    		return new Date(28,this.month-1,this.year);
    	}
    	else {
    		return new Date(31,12,this.year-1);
    	}
    }

    public int compareTo(Date other) { return 0; }
    public int compareTo(Date other) {
    	return (this.day-other.day)+(this.month-other.month)*31+(this.year-other.year)*372;
    }

}
}