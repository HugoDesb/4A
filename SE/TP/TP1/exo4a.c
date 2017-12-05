#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <errno.h>
#include <string.h>
#include <pthread.h>
#include <ctype.h>

#define R 0
#define W 1

#define ASCII_RANGE 128



int continuer = 1;

int main(void){
  pid_t fils1, fils2;
  int fd1[2];
  int fd2[2];
  int i;
  
  pipe(fd1);
  pipe(fd2);
 
  
  fils1 = fork();
  if(fils1>0){
    fils2 = fork();
  }

  
  

  
  if(fils1!=0 && fils2!=0){
    //LE PERE

    FILE *fp;
    char c;
    int n = 0;
    fp = fopen("lecture.txt", "r");
    if(fp == NULL){
      perror ("Error opening file");
    }else{
      do  {
	c = getc(fp);
	printf("%c\n", c);
	if(isdigit(c) && c!='0'){
	  //write pour fils 1
	  write(fd1[W], &c, sizeof(c));
	}else if(c!='0'){
	  //write pour fils 2
	  write(fd2[W], &c, sizeof(c));
	}else{
	  //do nothing, ignore
	}
      }while(c != EOF);
      
      fclose(fp);
      
      //SEND 0 to both
      write(fd1[W], &c, sizeof(c));
      write(fd2[W], &c, sizeof(c));
      char  count[ASCII_RANGE];
      int sum;
      continuer = 0;
      read(fd1[R], &sum, sizeof(int));
      read(fd2[R], &count, sizeof(int));
      
      printf("La somme : %d\n", sum);
      for(i=0; i<ASCII_RANGE; i++){
	//printf("'%c' est apparue %d fois\n",i, count[i]);
      }
      
      
	
    }
  }else if(fils1==0){
    //LE FILS
    char c;
    int nb, sum=0;
    while(continuer){
      read(fd1[R], &c, sizeof(c));
      printf("FILS 1 ---- %c\n", c);

      if(c=='0'){
	write(fd1[W], &sum, sizeof(int));
	printf("TA SOMME FDP : %d", sum);
      }else{
	nb = c - '0';
	sum+=nb;
      }
     
    }

    exit(0);
    
  }else if(fils2 == 0){
    //LE SAINT ESPRIT
    char c;
    char carac[ASCII_RANGE]; 
    while(continuer){
      read(fd1[R], &c, sizeof(c));
      printf("FILS 2 ---- %c\n", c);
      if(c=='0'){
	write(fd1[W], &carac, sizeof(carac));
      }else{
	carac[(int)c]++;
      }
     
    }

    exit(0);
    
  }else{
    perror("Damn..");
  }
  
}

