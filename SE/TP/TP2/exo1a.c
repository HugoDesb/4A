#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <errno.h>
#include <string.h>
#include <pthread.h>

void *thread_1(void * args){
  int i;
  for(i=2; i<=1000; i=i+2){
    printf("%d\n", i);
  }
  
}

void *thread_2(void * args){
  int i;
  for(i=1; i<=999; i=i+2){
    printf("%d\n", i);
  }
}


int main(void){
  pthread_t thread1 ,thread2;
 
  if(pthread_create(&thread1, NULL, thread_1,NULL)==-1){
    perror("Erreur a la création du thread 1");
    return EXIT_FAILURE;
  }

  if(pthread_create(&thread2, NULL, thread_2,NULL) ==-1){
    perror("Erreur a la création du thread 2");
    return EXIT_FAILURE;
  }
  

  pthread_join(thread2, NULL);
  pthread_join(thread1, NULL);

  return EXIT_SUCCESS;
}

