package com.bunfly.electric.pojo;

public class MonthOfPscVqr {
    private String pscNo;

    private String date;

    private String upperTime;

    private String lowTime;

    private String vqr;
    
    private String score;
    
    

    public MonthOfPscVqr() {
		
	}

	public MonthOfPscVqr(String pscNo, String date, String upperTime, String lowTime, String vqr, String score) {
		this.pscNo = pscNo;
		this.date = date;
		this.upperTime = upperTime;
		this.lowTime = lowTime;
		this.vqr = vqr;
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

    public String getUpperTime() {
        return upperTime;
    }

    public void setUpperTime(String upperTime) {
        this.upperTime = upperTime == null ? null : upperTime.trim();
    }

    public String getLowTime() {
        return lowTime;
    }

    public void setLowTime(String lowTime) {
        this.lowTime = lowTime == null ? null : lowTime.trim();
    }

    public String getVqr() {
        return vqr;
    }

    public void setVqr(String vqr) {
        this.vqr = vqr == null ? null : vqr.trim();
        double newVqr = Double.parseDouble(vqr);
	     if(newVqr <= 100) {
	    	 this.score = "100";
	     }else if(newVqr < 99.80) {
	    	 this.score = "90";
	     }else if(newVqr < 99.60) {
	    	 this.score = "80";
	     }else if(newVqr < 98.80) {
	    	 this.score = "70";
	     }else if(newVqr >= 0 && newVqr < 97.80) {
	    	 this.score = "60";
	     }
    }

	@Override
	public String toString() {
		return "MonthOfPscVqr [pscNo=" + pscNo + ", date=" + date + ", upperTime=" + upperTime + ", lowTime=" + lowTime
				+ ", vqr=" + vqr + ", score=" + score + "]";
	}
    
}