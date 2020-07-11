#include <stdio.h> 
#include <stdlib.h>
#include <omp.h>

static long num_steps = 100000;
double step;

main ()
{
	int i;
	double x, pi, sum = 0.0;
	
	step = 1.0/(double) num_steps;
	
	for (i=1;i<= num_steps; i++){
		x = (i-0.5)*step;
		sum = sum + 4.0/(1.0+x*x);//f(x) = 4/(1+x^2)
	}
	
	pi = step * sum;
	
	printf("So pi %8.8f",pi);
	
	
}

/*static long num_steps = 100000;
double step;
#define NUM_THREADS 2
main ()
{ 
	int i, id;
	double x, pi, sum;
	step = 1.0/(double) num_steps;
	omp_set_num_threads(NUM_THREADS);
	#pragma omp parallel private(x, i, id) reduction(+:sum)
	{
		id = omp_get_thread_num();
		printf("Thread tham gia song song %d\n",id);
		for (i=id+1; i<=num_steps; i=i+NUM_THREADS) {
			x = (i-0.5)*step;
			sum = sum + 4.0/(1.0+x*x);
		}
	}
	
	pi = sum * step;
	
	printf("So pi %8.8f",pi);
}*/

