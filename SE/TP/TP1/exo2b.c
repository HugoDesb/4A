#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <errno.h>
#include <string.h>
#include <pthread.h>

#define TABSIZE 400
#define TRUE 1
#define FALSE 0

void *thread_1(void * args){
  int * tab = args;
  int i;
  
  /* Booléen marquant l'arrêt du tri si le tableau est ordonné */
  int en_desordre = TRUE; 
  /* Boucle de répétition du tri et le test qui
     arrête le tri dès que le tableau est ordonné(en_desordre=FALSE) */
  while (en_desordre)
    {
      /* Supposons le tableau ordonné */
      en_desordre = FALSE;
      /* Vérification des éléments des places j et j+1 */
      for (i = 0; i < TABSIZE-1; i++)
	{
	  /* Si les 2 éléments sont mal triés */
	  if(tab[i] > tab[i+1])
	    {
	      /* Inversion des 2 éléments */
	      int tmp = tab[i+1];
	      tab[i+1] = tab[i];
	      tab[i] = tmp;
	      
	      /* Le tableau n'est toujours pas trié */
	      en_desordre = TRUE;
	    }
	}
    }
}

void *thread_2(void * args){
  int i;
  int * tab = args;

  printf("(");
  for(i=0;i<TABSIZE-1; i++){
    printf("%d,\n",tab[i]);
  }
  printf("%d )\n",tab[TABSIZE-1]);
}


int main(void){
  pthread_t thread1 ,thread2;



  int tab[TABSIZE];
  int i;
  srand(TABSIZE);
  //Création du tableau
  for(i = 0; i < TABSIZE; i++){
    tab[i] = (rand() % 1000) + 1;
  }

  
  if(pthread_create(&thread1, NULL, thread_1,(void *)tab)==-1){
    perror("Erreur a la création du thread A");
    return EXIT_FAILURE;
  }

  if(pthread_create(&thread2, NULL, thread_2,(void *)tab)==-1){
    perror("Erreur a la création du thread B");
    return EXIT_FAILURE;
  }
  

  pthread_join(thread1, NULL);

  pthread_cancel(thread2);

  return EXIT_SUCCESS;
}

