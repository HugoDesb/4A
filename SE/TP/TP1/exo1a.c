#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <errno.h>
#include <string.h>

int main(void){
  
  printf("id de ce processus %i\n", getpid());
  printf("id du pêre %i\n",getppid());
}
