#include <stdio.h>
#include <mpi.h>
#include <malloc.h>
#define m 8
#define n 8
#define p 4

int main(int argc,char** argv)
{
int i,j,k,NP, rank, mc;
// Khoi Tao MPI
MPI_Init(NULL,NULL);
MPI_Comm_size(MPI_COMM_WORLD,&NP);
MPI_Comm_rank(MPI_COMM_WORLD,&rank);
MPI_Status thongbao;

int *A, *B, *C;
A = (int *) malloc (sizeof(int)*m*n);
B = (int *) malloc (sizeof(int)*n*p);
C = (int *) malloc (sizeof(int)*m*p);
// 1-Chia mien tinh toan
mc = m/NP;
//
int *Ac, *Cc, *Bc;
Ac = (int *) malloc (sizeof(int)*mc*n);
Bc = (int *) malloc (sizeof(int)*n*p);
Cc = (int *) malloc (sizeof(int)*mc*p);
//2-Khoi tao
if (rank==0){
	for (i=0;i<m;i++)
		for (j=0;j<n;j++)
			if (i==j)
				*(A+i*n+j) = 1;	
			else 
				*(A+i*n+j) = 0;
	for (i=0;i<n;i++)
		for (j=0;j<p;j++)
			*(B+i*p+j) = i*p+j;
	for (i=0;i<m;i++)
		for (j=0;j<p;j++)
			*(C+i*p+j) = 0;	
}

//3-Gui Data den tat ca cac CPU
	if (rank == 0) {
		for (i=0;i<mc;i++)
			for (j=0;j<n;j++)
				*(Ac+i*n+j) = *(A+i*n+j);
		for (i=0;i<n;i++)
			for (j=0;j<p;j++)
				*(Bc+i*p+j) = *(B+i*p+j);
		for (k=1;k<NP;k++){
			MPI_Send(A+k*mc*n,mc*n,MPI_INT,k,k,MPI_COMM_WORLD);
			MPI_Send(B,n*p,MPI_INT,k,1000+k,MPI_COMM_WORLD);
		}	

	} else {
		MPI_Recv(Ac,mc*n,MPI_INT,0,rank,MPI_COMM_WORLD,&thongbao);
		MPI_Recv(Bc,n*p,MPI_INT,0,1000+rank,MPI_COMM_WORLD,&thongbao);
	}
	
// 4 - Tinh toan: Nhan ma tran
	for (i=0;i<mc;i++)
		for (k=0;k<p;k++){
			*(Cc+i*p+k) = 0;	
			for (j=0;j<n;j++)
				*(Cc+i*p+k) = *(Cc+i*p+k) + *(Ac+i*n+j)* *(Bc+j*p+k);
		}
// 5 - Tap hop ket qua
	if (rank != 0) {
			MPI_Send(Cc,mc*p,MPI_INT,0,rank,MPI_COMM_WORLD);	
	} else {
		for (i=0;i<mc;i++)
			for (j=0;j<p;j++)
				*(C+i*p+j) = *(Cc+i*p+j);

		for (k=1;k<NP;k++)
			MPI_Recv(C+k*mc*p,mc*p,MPI_INT,k,k,MPI_COMM_WORLD,&thongbao);
	}	

// In Ket Qua
if (rank==0)
	for (i=0;i<m;i++){
		for (j=0;j<p;j++) printf("%d\t",*(C+i*p+j));
		printf("\n");
	}
//
MPI_Finalize();
return 0;
}
 