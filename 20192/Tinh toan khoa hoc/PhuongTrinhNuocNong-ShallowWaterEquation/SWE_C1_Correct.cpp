#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include <math.h>
#include <time.h>

#define  f       0.0001   
#define  g       10.0

#define  NX      100
#define  NY      100
#define  hx      4400000.0
#define  hy      4400000.0

#define  T       1000.0
#define  ht      0.1
//=========================
int Index(int I, int J, int N)
{
  return J*N+I;
}
//=========================
void DisplayMatrix(float *A)
{
  int i,j;
  for(i=0;i<NX;i++){
    for(j=0;j<NY;j++) 
      printf("  %f",*(A+Index(i,j,NX)));
    printf("\n");
  }
}
//=========================
void Write2File(float *C)
{
  FILE *result=fopen("result.txt", "a");
  int i,j;
  for(i=0;i<NX;i++) 
  {
    for(j=0;j<NY;j++) 
    { 
      fprintf(result, "%lf\t", *(C+i*NY+j));
    }
    fprintf(result, "\n");
  }
  fclose(result);
}

//=========================
void KhoiTao(float *U,float *V,float *H)
  {
  int i,j;
  float X,Y,Y0;

  float H0 = 20000.0;
  float H1 = 4400.0;
  float H2 = 2660.0;
  float D  = 4400000.0;
  float XL = 4400000.0;
  float DX = 628571.4;
  //
  for(i=0;i<NX;i++)
    for(j=0;j<NY;j++) {
      Y = j*DX;
      Y0= 6.0*DX;
      X = i*DX/XL;
      *(U+Index(i,j,NX)) = 0.0;
      *(V+Index(i,j,NX)) = 0.0;
      *(H+Index(i,j,NX)) = 1.0
                          *H0
                          +H1*tanh(9.0*(Y - Y0)/(2.0*D))
                          +H2*(sin(2.0*3.1415*X))
                             /(cosh(9.0*Y - Y0/D)*cosh(9.0*Y - Y0/D));                          
    }
  }
//=========================
// HAM ROI RAC HOA THEO KHONG GIAN
void FD(
  float *dU,float *dV,float *dH,
  float *U,float *V,float *H
        )
  {
  int i,j;
  float Uc,Vc,Hc,Ur,Vr,Hr,Ud,Vd,Hd;
  float Ux,Uy,Vx,Vy,Hx,Hy;
  for (i = 0 ; i < NX ; i++)
    for (j = 0 ; j < NY ; j++){
      // TINH Uc = U(i,j),Vc = V(i,j),Hc = H(i,j)
      Uc = *(U+Index(i,j,NX));
      Vc = *(V+Index(i,j,NX));
      Hc = *(H+Index(i,j,NX));
      // TINH Uu = U(i+1,j),Vu = V(i+1,j),Hu = H(i+1,j)
      // Cyclic Boundary Condition in x-direction
      Ur = (i==NX-1) ? *(U+Index(0,j,NX)) : *(U+Index(i+1,j,NX));
      Vr = (i==NX-1) ? *(V+Index(0,j,NX)) : *(V+Index(i+1,j,NX));
      Hr = (i==NX-1) ? *(H+Index(0,j,NX)) : *(H+Index(i+1,j,NX));
      // TINH Ud = U(i,j+1),Vd = V(i,j+1),Hd = H(i,j+1)
      Ud = (j==NY-1) ? 0.0 : *(U+Index(i,j+1,NX));
      Vd = (j==NY-1) ? 0.0 : *(V+Index(i,j+1,NX));
      Hd = (j==NY-1) ? 0.0 : *(H+Index(i,j+1,NX));
      // TINH Ux,Uy THEO PP SAI PHAN THUAN
      Ux = (Ur - Uc)/hx;
      Uy = (Ud - Uc)/hy;
      // TINH Vx,Vy THEO PP SAI PHAN THUAN
      Vx = (Vr - Vc)/hx;
      Vy = (Vd - Vc)/hy;
      // TINH Hx,Hy THEO PP SAI PHAN THUAN
      Hx = (Hr - Hc)/hx;
      Hy = (Hd - Hc)/hy;
      // TINH dU,dV,dH
      *(dU+Index(i,j,NX)) = f*Vc - Uc*Ux - Vc*Uy - g*Hx;
      *(dV+Index(i,j,NX)) = - f*Uc - Uc*Vx - Vc*Vy - g*Hy;
      *(dH+Index(i,j,NX)) = - Uc*Hx - Hc*Ux - Vc*Hy - Hc*Vy;
    }
  }
//=========================
// HAM ROI TICH HOP THEO THOI GIAN
void TI(
  float *Un,float *Vn,float *Hn,
  float *Uc,float *Vc,float *Hc,
  float *dU,float *dV,float *dH
        )
  {
  int i,j;
  for (i = 0 ; i < NX ; i++)
    for (j = 0 ; j < NY ; j++){
      // TINH Un,Vn,Hn
      *(Un+Index(i,j,NX)) = *(Uc+Index(i,j,NX)) + *(dU+Index(i,j,NX))*ht;
      *(Vn+Index(i,j,NX)) = *(Vc+Index(i,j,NX)) + *(dV+Index(i,j,NX))*ht;
      *(Hn+Index(i,j,NX)) = *(Hc+Index(i,j,NX)) + *(dH+Index(i,j,NX))*ht;
    }
  } 
//=========================
int main()
{
  int i,j;
  float t = 0.0;
  float *Unew,*Ucurrent,*dU;
  float *Vnew,*Vcurrent,*dV;
  float *Hnew,*Hcurrent,*dH;
  Unew     = (float *) malloc (NX*NY*sizeof(float));
  Ucurrent = (float *) malloc (NX*NY*sizeof(float));
  dU       = (float *) malloc (NX*NY*sizeof(float));
  //
  Vnew     = (float *) malloc (NX*NY*sizeof(float));
  Vcurrent = (float *) malloc (NX*NY*sizeof(float));
  dV       = (float *) malloc (NX*NY*sizeof(float));
  //
  Hnew     = (float *) malloc (NX*NY*sizeof(float));
  Hcurrent = (float *) malloc (NX*NY*sizeof(float));
  dH       = (float *) malloc (NX*NY*sizeof(float));
  //
  KhoiTao(Ucurrent,Vcurrent,Hcurrent);
  Write2File(Hcurrent);
  printf("Gia tri khoi tao:\n");
  DisplayMatrix(Hcurrent);
  //
  while (t<=T)
  {
    //
    FD(dU,dV,dH,Ucurrent,Vcurrent,Hcurrent);
    //
    TI(Unew,Vnew,Hnew,Ucurrent,Vcurrent,Hcurrent,dU,dV,dH);
    //
    for (i = 0 ; i < NX ; i++)
      for (j = 0 ; j < NY ; j++){
        *(Ucurrent+Index(i,j,NX)) = *(Unew+Index(i,j,NX));
        *(Vcurrent+Index(i,j,NX)) = *(Vnew+Index(i,j,NX));
        *(Hcurrent+Index(i,j,NX)) = *(Hnew+Index(i,j,NX));
      }
    t=t+ht;
//    Write2File(Phi_c,m,1);
  }
  printf("Gia tri cuoi cung:\n");
  DisplayMatrix(Hcurrent);
  Write2File(Hcurrent);
  //
  printf("Completed\n");
  getch();
  return 0;
}

