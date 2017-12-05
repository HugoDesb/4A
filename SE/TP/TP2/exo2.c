#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <errno.h>
#include <string.h>
#include <pthread.h>
#include <semaphore.h>
#include <sys/shm.h>
#include <sys/mman.h>
#include <sys/stat.h>
#include <unistd.h>
#include <fcntl.h>


int continuer = 1; 

sem_t semaphore1;
sem_t semaphore2;
sem_t semaphore3;

//thread impair
void *thread_1(void * args){
  int nb[10];
  int i=0, n;
  
  while(continuer){
    sem_wait(&semaphore2);
    n = *((int*)args);
    if(n%2 !=0){
      nb[i] = n;
      i++;
      if(i==10){
	for(i=0; i<10; i++){
	  printf("%d\n", nb[i]);
	}
	i=0;
      }
    }
    sem_post(&semaphore3);
  }
}

//thread pair
void *thread_2(void * args){
  int nb[10];
  int i=0, n;
  
  while(continuer){
    sem_wait(&semaphore3);
    n = *((int*)args);
    if(n%2==0){
      nb[i] = n;
      i++;

      if(i==10){
	for(i=0; i<10; i++){
	  printf("%d\n", nb[i]);
	}
	i=0;
      }
    }
    sem_post(&semaphore1);
  }
}


int main(void){
  pthread_t thread1 ,thread2;
  int i;
  
  int fd, res;
  int *partage = NULL;
  
  fd = shm_open("/regint", O_CREAT | O_RDWR, S_IRUSR |S_IWUSR);
  if(fd == -1){
    perror("shm_open");
    exit(1);
  }
  
  res = ftruncate(fd, 4);
  if(res==-1){
    perror("ftruncate");
    exit(1);
  }
  
  partage = (int *)mmap(NULL, sizeof(int),PROT_READ|PROT_WRITE, MAP_SHARED, fd, 0);
  if(partage == MAP_FAILED){
    perror("mmap");
    exit(1);
  }

  sem_init(&semaphore1, 0, 1); //processus père --actif
  sem_init(&semaphore2, 0, 0); //fils impaire
  sem_init(&semaphore3, 0, 0); //fils pair
  
 
  if(pthread_create(&thread1, NULL, thread_1,partage)==-1){
    perror("Erreur a la création du thread 1");
    return EXIT_FAILURE;
  }

  if(pthread_create(&thread2, NULL, thread_2,partage) ==-1){
    perror("Erreur a la création du thread 2");
    return EXIT_FAILURE;
  }

  for(i = 1; i<=1000; i++){
    sem_wait(&semaphore1);
    //on stocke le nb dans la mémoire partagée
    memcpy(partage, &i, sizeof(int));
    sem_post(&semaphore2);
  }

  continuer = 0;

  pthread_join(thread1, NULL);
  pthread_join(thread2, NULL);

  return EXIT_SUCCESS;
}

