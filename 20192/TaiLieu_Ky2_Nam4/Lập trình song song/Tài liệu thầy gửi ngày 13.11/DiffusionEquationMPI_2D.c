#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <math.h>
#include <mpi.h>

#define  m       20
#define  n       20
#define  T       2
#define  dt      0.01
#define  dx      0.1
#define  D       0.1
//==================================
void DisplayMatrix(float *A, int row,  int col)
{
  int i,j;
  for(i=0;i<row;i++){
    for(j=0;j<col;j++) printf("  %f",*(A+i*col+j));
    printf("\n");
  }
}
//==================================
void Write2File(float *C)
{
  FILE *result=fopen("result.txt", "a");
  int i,j;
  for(i=0;i<m;i++) 
  {
    for(j=0;j<n;j++) 
    { 
      fprintf(result, "%lf\t", *(C+i*n+j));
    }
    fprintf(result, "\n");
  }
  fclose(result);
}
//==================================
void KhoiTao(float *C)
{
  int i,j;
for (  i = 0 ; i < m ; i++ )
  for ( j = 0 ; j < n ; j++ ){
    if (i>=(m/2-2)&&i<(m/2+2)&&j>=(n/2-2)&&j<(n/2+2)) 
      *(C+i*n+j) = 80.0;
    else
      *(C+i*n+j) = 25.0;
  }
}
//==================================
void FD(float *Cs,float *Cu,float *Cd,float *dCs,int ms)
{
int i, j;
float c,u,d,l,r;
for (  i = 0 ; i < ms ; i++ )
  for ( j = 0 ; j < n ; j++ )
    {
      c = *(Cs+i*n+j);
      u = (i==0)    ? *(Cu+j)     : *(Cs+(i-1)*n+j);
      d = (i==ms-1) ? *(Cd+j)     : *(Cs+(i+1)*n+j);
      l = (j==0)    ? *(Cs+i*n+j) : *(Cs+i*n+j-1);
      r = (j==n-1)  ? *(Cs+i*n+j) : *(Cs+i*n+j+1);
      *(dCs+i*n+j) = (D/(dx*dx))*(u+d+l+r-4*c);
    }
}
//==================================
//==================================
main(int argc, char *argv[])
{
  int i, j;
  float t; t=0;
  int NP,rank,mc; MPI_Status status;
  double t1,t2,t3,t4,t5;
//
  float *C,*dC,*Cs,*dCs;
  float *Cu,*Cd;
  C   = (float *) malloc ((m*n)*sizeof(float));
  dC  = (float *) malloc ((m*n)*sizeof(float));
//==================================
// Khoi tao MPI
  MPI_Init(&argc,&argv);
//==================================
// Tinh so process: NP, gan ID cho tung process:rank  
  MPI_Comm_size(MPI_COMM_WORLD,&NP);    
  MPI_Comm_rank(MPI_COMM_WORLD,&rank);
//==================================
  // Tinh kich thuoc cua cac ma tran con
  mc = m/NP;
// Cap phat bo nho cho cac ma tran con
  Cs = (float *) malloc ((mc*n)*sizeof(float));
  dCs = (float *) malloc ((mc*n)*sizeof(float));
//
  Cu = (float *) malloc (n*sizeof(float));
  Cd = (float *) malloc (n*sizeof(float));
//==================================
  if (rank==0) {
    KhoiTao(C);
//    printf("Gia tri khoi tao:\n");
//    DisplayMatrix(C, m, n);
  }
  //==================================
// Gui Ma tran C tu Core 0 den tat ca cac Core
   t1 = MPI_Wtime();
   MPI_Scatter(C,mc*n,MPI_FLOAT,
              Cs,mc*n,MPI_FLOAT,0,
              MPI_COMM_WORLD);
//  printf( "Ma tran Cs tai core %d is:\n", rank);
//  DisplayMatrix(Cs, mc, n);
//==================================

while (t<=T)
{
  if (rank==0){
    for (j=0;j<n;j++) *(Cu+j) = *(Cs+0*n+j);
    MPI_Send(Cs+(mc-1)*n,n,MPI_FLOAT,rank+1,rank,MPI_COMM_WORLD);
  } else if (rank==NP-1) {
    MPI_Recv(Cu,n,MPI_FLOAT,rank-1,rank-1,MPI_COMM_WORLD,&status);
  } else {
    MPI_Send(Cs+(mc-1)*n,n,MPI_FLOAT,rank+1,rank,MPI_COMM_WORLD);
    MPI_Recv(Cu,n,MPI_FLOAT,rank-1,rank-1,MPI_COMM_WORLD,&status);
  }
//
  if (rank==NP-1){
    for (j=0;j<n;j++) *(Cd+j) = *(Cs+(mc-1)*n+j);
    MPI_Send(Cs,n,MPI_FLOAT,rank-1,rank,MPI_COMM_WORLD);
  } else if (rank==0) {
    MPI_Recv(Cd,n,MPI_FLOAT,rank+1,rank+1,MPI_COMM_WORLD,&status);
  } else {
    MPI_Send(Cs,n,MPI_FLOAT,rank-1,rank,MPI_COMM_WORLD);
    MPI_Recv(Cd,n,MPI_FLOAT,rank+1,rank+1,MPI_COMM_WORLD,&status);
  }

//      printf( "Ma tran Cu tai core %d is:\n", rank);
//      DisplayMatrix(Cu, 1, n);printf("\n");
  
  FD(Cs,Cu,Cd,dCs,mc);
//     
  for (  i = 0 ; i < mc ; i++ )
    for ( j = 0 ; j < n ; j++ )
      *(Cs+i*n+j) = *(Cs+i*n+j) + dt*(*(dCs+i*n+j));

  t=t+dt;  
}

//==================================
// Gui Ma tran C tu tat ca cac Core ve Core 0
  MPI_Gather(Cs,mc*n,MPI_FLOAT,
             C,mc*n,MPI_FLOAT,0,
             MPI_COMM_WORLD);
  t2 = MPI_Wtime();
  printf ("\tThe Calculation time:%f\n",(t2 - t1));
// In Ket Qua Tai Core 0
  if (rank==0)
    {
//      printf( "Ma tran C:\n");
//      DisplayMatrix(C, m, n);
//      Write2File(C);
    }
    
//==================================
  MPI_Finalize();
  return 0;
}

