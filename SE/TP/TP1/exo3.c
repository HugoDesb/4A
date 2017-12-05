#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/wait.h>
#include <errno.h>
#include <string.h>
#include <pthread.h>



int main(void){
  pid_t pid;

  pid = fork();
  

  if(pid == 0){
    while(1){
      printf("I'm a banana\n");
    }
  }else if(pid > 0){
    sleep(5);
    kill(pid,SIGKILL);
  }else{
    perror("Damn..");
  }

  return EXIT_SUCCESS;
}

