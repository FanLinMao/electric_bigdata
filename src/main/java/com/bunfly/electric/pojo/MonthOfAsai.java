package com.bunfly.electric.pojo;

public class MonthOfAsai {
    private String pscNo;

    private String date;

    private String asai;

    private String pctimes;

    private String totalDay;
    
    private String score;
    
    

    public MonthOfAsai() {
		
	}

	public MonthOfAsai(String pscNo, String date, String asai, String pctimes, String totalDay, String score) {
		super();
		this.pscNo = pscNo;
		this.date = date;
		this.asai = asai;
		this.pctimes = pctimes;
		this.totalDay = totalDay;
		this.score = score;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getPscNo() {
        return pscNo;
    }

    public void setPscNo(String pscNo) {
        this.pscNo = pscNo == null ? null : pscNo.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getAsai() {
        return asai;
    }

    public void setAsai(String asai) {
        this.asai = asai == null ? null : asai.trim();
        double newAsai = Double.parseDouble(asai);
	     if(newAsai == 1.00 || newAsai <= 100) {
	    	 this.score = "100";
	     }else if(newAsai < 99.99) {
	    	 this.score = "90";
	     }else if(newAsai < 99.96) {
	    	 this.score = "80";
	     }else if(newAsai < 99.93) {
	    	 this.score = "70";
	     }else if(newAsai >= 0 && newAsai < 99.90) {
	    	 this.score = "60";
	     }
    }

    public String getPctimes() {
        return pctimes;
    }

    public void setPctimes(String pctimes) {
        this.pctimes = pctimes == null ? null : pctimes.trim();
    }

    public String getTotalDay() {
        return totalDay;
    }

    public void setTotalDay(String totalDay) {
        this.totalDay = totalDay == null ? null : totalDay.trim();
    }
}