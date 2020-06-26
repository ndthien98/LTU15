#include <conio.h>
#include <stdio.h> 
#include <stdlib.h>
#include <omp.h>

int main(int argc, char *argv[])
{	
	//omp_set_num_threads(6);
    #pragma omp parallel
    { 
	    int i = omp_get_thread_num();
		printf("Thread tham gia song song %d\n",i);
        printf("Hello, world.\n");
    }
    getch();
   return 0;
}
