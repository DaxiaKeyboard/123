package hust.gjmz.em;

public class EM {
	Parameters parameters;
	double pie;
	double p;
	double q;
	double precesion=0.0001;
	double u0; //依据上一步的参数 计算后验 概率。。。
	double u1;
	
	int[] y;
	
	public EM(){
		parameters=new Parameters(0.0,0.0,0.0);
		y=new int[]{1,1,0,1,0,0,1,0,1,1};
		
		pie=0.4;
		p=0.6;
		q=0.7;
	}
	
	public void process(){
		int count=0;
		
		System.out.println("initial parameters...");
		System.out.println("pie="+pie+"   p="+p+"   q="+q);
		while(true){
			stepE();
			stepM();
			count++;
			System.out.println("----------------------------");
			System.out.println("the "+count+"th iteration...");
			System.out.println("pie="+parameters.pie+"   p="+parameters.p+"   q="+parameters.q);
			
			if((Math.abs(parameters.pie-pie)<=precesion)
			 &&(Math.abs(parameters.p-p)<=precesion)
			 &&(Math.abs(parameters.q-q)<=precesion))
				break;
			
			pie=parameters.pie;
			p=parameters.p;
			q=parameters.q;
		}
		System.out.println("----------------------------");
		System.out.println("Done...");
	}
	
	public void stepE(){
		//因为数据不是来自硬币A，就是来自硬币B...
		//y[i]是0，且观察的数据来自硬币B。。。
		u0=pie*(1-p)/(pie*(1-p)+(1-pie)*(1-q));
		//y[i]是1，且观察的数据来自硬币B。。。
		u1=pie*p/(pie*p+(1-pie)*q);
		  
		
	}
	
	public void stepM(){
		double totalU=0.0;
		double totalP=0.0;
		
		double totalMinusU=0.0;
		double totalQ=0.0;
		
		for(int i=0;i<y.length;i++){
			if(y[i]==0){
				totalU+=u0;
				totalMinusU+=(1-u0);
			}
			else{//y[i]=1;
				totalU+=u1;
				totalP+=u1;
				totalQ+=(1-u1);
				totalMinusU+=(1-u1);
			}
		}
		
		parameters.setPie(totalU/y.length);
		parameters.setP(totalP/totalU);
		parameters.setQ(totalQ/totalMinusU);
	}
}
