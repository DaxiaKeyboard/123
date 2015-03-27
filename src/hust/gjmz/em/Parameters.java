package hust.gjmz.em;


//存的是估计参数  即最终的结果。。。
public class Parameters {
	double pie;
	double p;
	double q;
	
	public Parameters(double pie,double p,double q){
		this.pie=pie;
		this.p=p;
		this.q=q;
	}

	public double getPie() {
		return pie;
	}

	public void setPie(double pie) {
		this.pie = pie;
	}

	public double getP() {
		return p;
	}

	public void setP(double p) {
		this.p = p;
	}

	public double getQ() {
		return q;
	}

	public void setQ(double q) {
		this.q = q;
	}
	
	
	
}
