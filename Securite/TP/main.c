
#include <stdlib.h>
#include <stdio.h>
//#include <openssl/aes.h>






int main(void){
	int choixMenu;
	printf("Bonjour !");
	do
	{
		printf("Que voulez vous faire ? \n\t 0-Quitter \n\t 1-Chiffrer un fichier en AES-CBC \n\t \n");
		scanf("%i", &choixMenu);
		if (choixMenu == 1) {
			int choixTailleBlocs,tailleBlocs;
			FILE* plainFile, cipherFile;

			printf("Quelle taille de blocs ? \n\t 0-128 bits \n\t 1-192 bits \n\t 2-256 bits \n");
			scanf("%i", &choixTailleBlocs);
			if (choixTailleBlocs == 0) {
				tailleBlocs == 128;
			}
			else if (choixTailleBlocs == 1) {
				tailleBlocs = 192;
			}
			else {
				tailleBlocs = 256;
			}

			printf("Chiffrage du fichier connard.jpg en AES-CBC...\n");
		}
		else if (choixMenu == 2) {

		}
	} while (choixMenu !=0);
	

}


