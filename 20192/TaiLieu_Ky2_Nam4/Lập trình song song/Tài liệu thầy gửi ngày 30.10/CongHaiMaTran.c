//lenh dich la mpicc mpi1.c
#include <stdio.h>
#include <mpi.h>
#include <malloc.h>
#define M 20
int main()
{
int rank, size;

MPI_Init(NULL,NULL);
MPI_Comm_rank(MPI_COMM_WORLD,&rank);
MPI_Comm_size(MPI_COMM_WORLD,&size);
MPI_Status thongbao;

int i,Mc, *A, *B, *C;
A=(int *) malloc(sizeof(int)*M);
B=(int *) malloc(sizeof(int)*M);
C=(int *) malloc(sizeof(int)*M);
//Chia mien tinh toan:
	Mc = M/size;
int *Ac, *Bc, *Cc;
Ac=(int *) malloc(sizeof(int)*Mc);
Bc=(int *) malloc(sizeof(int)*Mc);
Cc=(int *) malloc(sizeof(int)*Mc);
//Khoi tao
if (rank==0)
	for (i=0; i<M;i++){
	*(A+i) = i;
	*(B+i) = 2*i;
	}
}
//gui input
	if (rank==0){
		for (i=0;i<M;i++){
			*(Ac+i) = *(A+i);
			*(Bc+i) = *(B+i);
	}


