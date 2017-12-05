#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <errno.h>
#include <string.h>


int main(int argc, char const *argv[])
{
  FILE * fileNb = fopen("listeNbPremiers", "r");
  int nb, i;
  pid_t pidParent = getpid();



  printf("Processus pere : \n");
  //lecture et affichage des 10 premiers nombres
  for (i = 0; i < 10; i++) {
    fscanf(fileNb, "%d\n", &nb);
    printf("%d\n", nb);
  }

  //on crée un fils
  pid_t pid = fork();
  //si le fils a été créé, on fait la lecture
  if(pid == 0){
    printf("Processus fils : \n");
    for(i = 0; i<20; i++){
      fscanf(fileNb, "%d\n", &nb);
      printf("%d\n", nb);
    }
    printf("fin de la lecture du processus fils\n");
    //on quitte le processus
    exit(0);
  }/*else{
    //sinon on quitte
    if(wait(NULL) == -1){
      perror("wait :");
      exit(EXIT_FAILURE);
    }
    }*/

  printf("le pere termine sa lecture\n");
  //tant que la fin du fichier n'est pas atteinte
  while (fscanf(fileNb, "%d\n", &nb) != EOF) {
    printf("%d\n", nb);
  }

	
  return 0;
}
