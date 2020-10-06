#include <iostream>
#include <fstream>

using namespace std;

void merge(int *arr, int start, int mid, int end)
{
  printf("\nMerge: %d %d %d \n", start, mid, end);
  for (int i = start; i <= mid; i++)
  {
    printf("%d ", arr[i]);
  }
  printf("\n");
  for (int i = mid + 1; i <= end; i++)
  {
    printf("%d ", arr[i]);
  }
  printf("\n");

  int i = start;
  int j = mid + 1;
  int k = 0;
  int temp[end - start + 1];

  while (true)
  {
    if (i > mid && j <= end)
    {
      temp[k] = arr[j];
      k++;
      j++;
      continue;
    }
    else if (j > end && i <= mid)
    {
      temp[k] = arr[i];
      k++;
      i++;
      continue;
    }
    else if (i <= mid && j <= end)
    {
      if (arr[i] < arr[j])
      {
        temp[k] = arr[i];
        i++;
      }
      else
      {
        temp[k] = arr[j];
        j++;
      }
      k++;
    }
    else
      break;
  }
  printf("After merge: ");
  for (int l = 0; l < k; l++)
  {
    arr[start] = temp[l];
    start++;
    printf("%d ", temp[l]);
  }
};

void merge_sort(int *a, int start, int end)
{
  if (start < end)
  {
    int mid = (start + end) / 2;
    merge_sort(a, start, mid);
    merge_sort(a, mid + 1, end);
    merge(a, start, mid, end);
  }
};

int main()
{
  FILE *f;
  int n;
  f = fopen("input.txt", "r");
  fscanf(f, "%d", &n);
  int a[n];
  for (int i = 0; i < n; i++)
  {
    fscanf(f, "%d", &a[i]);
    printf("%d ", a[i]);
  }
  fclose(f);

  merge_sort(a, 0, n - 1);
  printf("\nAfter merge sort: ");
  for (int i = 0; i < n; i++)
  {
    printf("%d ", a[i]);
  }
  printf("\n");
}