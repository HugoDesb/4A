#include <stdio.h>
#include <stdlib.h>
#include "tools.h"


int main(void){
  int choiceProgram;
  char filename[256], targetFilename[256], password[256];
  do{
    printf("Que voulez vous faire ?");
    printf("\t - Chiffrer (1)\t - Déchiffrer (0)\n");
    scanf("%i", &choiceProgram);
  }while(choiceProgram!=0 && choiceProgram!=1);
    
  printf("Donner le nom de votre fichier source: ");
  scanf( "%s" , filename );
    
  printf("Donner le nom de votre fichier cible: ");
  scanf( "%s" , targetFilename );
    
  printf("Donnez votre password : ");
  scanf( "%s",password);
    
  do_crypt(password, filename, targetFilename, choiceProgram);
    
  
}
