#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <errno.h>
#include <string.h>
#include <pthread.h>

void *thread_1(void * args){
  printf("%s",args);
  pthread_exit("Je suis A et j'ai fini\n");
}

void *thread_2(void * args){
  perror((char *)args);
  pthread_exit("Je suis B et j'ai fini\n");
}


int main(void){
  pthread_t thread1 ,thread2;
  void * ret1;
  void * ret2;

  if(pthread_create(&thread1, NULL, thread_1,(void *)"Je suis le message de A\n")
     ==-1){
    perror("Erreur a la création du thread A");
    return EXIT_FAILURE;
  }

  if(pthread_create(&thread2, NULL, thread_2,(void *)"Je suis le message de B\n")
     ==-1){
    perror("Erreur a la création du thread B");
    return EXIT_FAILURE;
  }
  

  pthread_join(thread2, &ret2);
  printf((char *)ret2);

  pthread_join(thread1, &ret1);
  perror((char *)ret1);

  return EXIT_SUCCESS;
}

