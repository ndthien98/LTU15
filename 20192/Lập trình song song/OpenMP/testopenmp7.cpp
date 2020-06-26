#include <stdio.h> 
#include <stdlib.h>
#include <omp.h>

#define NUM_THREADS 6

main ()
{ 
	int i, id;
	omp_set_num_threads(NUM_THREADS);
	int a=0,b=0;
	#pragma omp parallel private(id) shared(a)
	{
		id = omp_get_thread_num();
		printf("Thread tham gia song song %d\n",id);
		#pragma omp atomic
			a++;			
	}
	
	printf("a=%d", a);
}

