#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <errno.h>
#include <string.h>


int main(int argc, char const *argv[])
{
	FILE * nbP = NULL;
	int nb;

	int nbactuel;

	nbP = fopen("listeNbPremier", "r");

	printf("LE PERE\n");
	for (int i = 0; i < 10; ++i) {
		fscanf(nbP, "%d\n", &nb);
		printf("%d\n", nb);
	}

	pid_t pid = fork();

	if (pid == 0) {
		printf("LE FILS\n");
		for (int i = 0; i < 20; ++i) {
			fscanf(nbP, "%d\n", &nb);
			printf("%d\n", nb);
		}
		exit(0);
	} else {
		
		if (wait(NULL) == -1) {
    		perror("wait :");
    		exit(EXIT_FAILURE);
   		}

   		printf("LE PERE termine\n");
   		while (fscanf(nbP, "%d\n", &nb) != 0) {
   			printf("%d\n", nb);
   		}
	}


	return 0;
}
