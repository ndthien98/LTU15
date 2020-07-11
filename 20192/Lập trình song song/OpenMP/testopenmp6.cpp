#include <stdio.h> 
#include <stdlib.h>
#include <omp.h>

#define NUM_THREADS 6

main ()
{ 
	int i, id;
	omp_set_num_threads(NUM_THREADS);
	int a=0,b=0;
	#pragma omp parallel private(id)
	{
		id = omp_get_thread_num();
		printf("Thread tham gia song song %d\n",id);
		#pragma omp critical
		{
			id = omp_get_thread_num();
			printf("Thread tham gia critical %d\n",id);
			for(i=0;i<10000;i++)
				a++;
			printf("Thread ket thuc critical %d\n",id);
		}
	}
	
	//printf("a=%d, b=%d", a, b);
}

