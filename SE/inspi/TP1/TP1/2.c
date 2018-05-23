#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <sys/wait.h>
#include <errno.h>
#include <string.h>
#include <pthread.h>

void *thread_1(void *arg)
{
    printf("%s", arg);

    /* Pour enlever le warning */
    (void) arg;
    char * a = "Je suis A et j'ai fini\n";
    pthread_exit((void*) a);
}

void *thread_2(void *arg)
{
    printf("%s", arg);

    /* Pour enlever le warning */
    (void) arg;
    char * a = "Je suis B et j'ai fini\n";
    pthread_exit((void*) a);
}

int main(int argc, char const *argv[])
{
	pthread_t thread1;
	pthread_t thread2;

	char * phrase1 = "Je suis la phrase fourni au A\n";
	char * phrase2 = "Je suis la phrase fourni au B\n";

	char * ret1;
	char * ret2;

    printf("Avant la création du thread.\n");

    if(pthread_create(&thread1, NULL, thread_1, phrase1) == -1) {
	perror("pthread_create");
	return EXIT_FAILURE;
    }

    if(pthread_create(&thread2, NULL, thread_2, phrase2) == -1) {
	perror("pthread_create");
	return EXIT_FAILURE;
    }

    pthread_join(thread2, (void **)&ret2);
    printf("%s\n", ret2);

    pthread_join(thread1, (void **)&ret1);
    fprintf(stderr, "%s\n", ret1);

    return EXIT_SUCCESS;
}