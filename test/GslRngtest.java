import JAMAJniGsl.*;
/* GslRngtest.java */
public final class GslRngtest {
    private GslRngtest() {}
    public static void main(String[] args) {

	JniGslRng.seed();
	//uninorm
	double sigma = 2.0;
	int i;	
	double sigma2 = 2.0;
	System.out.println("uninorm()");	
	System.out.printf("%.4f\t", JniGslRng.uninorm(sigma));
	System.out.printf("%.4f\t", JniGslRng.uninorm(sigma2));
	System.out.printf("%.4f\t", JniGslRng.uninorm(sigma));
	System.out.printf("%.4f\t", JniGslRng.uninorm(sigma2));
        System.out.println();

	//multinorm
	int k = 4;
	double[] mu = {1,2,3,4};
	double[] l = {1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1};
	double[] result = new double [k];	
	System.out.println("multinorm()");	
	JniGslRng.multinorm(k, mu, l, result);
	for(i=0; i<k; i++)
		System.out.println(result[i]);
        System.out.println();

	//gamma
	double a = 2;
	double b = 2;	
	System.out.println("gamma()");	
	System.out.printf("%.4f\t", JniGslRng.gamma(a, b));
	System.out.printf("%.4f\t", JniGslRng.gamma(a, b));
	System.out.printf("%.4f\t", JniGslRng.gamma(a, b));
	System.out.printf("%.4f\t", JniGslRng.gamma(a, b));
        System.out.println();

	//invergamma
	a = 1;
	b = 1;	
	System.out.println("inversegamma()");	
	System.out.printf("%.4f\t", JniGslRng.invergamma(a, b));
	System.out.printf("%.4f\t", JniGslRng.invergamma(a, b));
	System.out.printf("%.4f\t", JniGslRng.invergamma(a, b));
	System.out.printf("%.4f\t", JniGslRng.invergamma(a, b));
        System.out.println();

	//wishart
	double n = 3;
	int  p = 2;
	double[] ll = {10,1,1,10};
	double[] result_wi = new double [p * p];	
	System.out.println("wishart()");	
	JniGslRng.wishart(n, p, ll, result_wi);
	for(i=0; i<p*p; i++)
		System.out.println(result_wi[i]);
        System.out.println();

	//inverwishart
	n = 3;
	p = 2;
	int ii;
	double[] lll = {10,1,1,10};
	double[] result_inwi = new double [p * p];	
	System.out.println("inverwishart()");	
	for(ii = 0; ii<500; ii++){
	JniGslRng.inverwishart(n, p, lll, result_inwi);
	for(i=0; i<p*p; i++)
		System.out.println(result_inwi[i]);
        System.out.println();
	}

	JniGslRng.free();
    }
    
}







