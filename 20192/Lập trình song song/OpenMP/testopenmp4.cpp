#include <stdio.h> 
#include <stdlib.h>
#include <omp.h>

#define NUM_THREADS 2

main ()
{ 
	int i, id;
	omp_set_num_threads(NUM_THREADS);
	int a=0,b=0;
	#pragma omp parallel
	{
		#pragma omp sections private(i)
		{
			#pragma omp section
			{
				for	(i=0;i<10000;i++)
				{
					a++;
				}
				printf("a=%d\n", a);
			}
			
			#pragma omp section
			{
				for	(i=0;i<9000;i++)
				{
					b++;
				}
				printf("b=%d\n", b);
			}
		}
	}
	
	//printf("a=%d, b=%d", a, b);
}

