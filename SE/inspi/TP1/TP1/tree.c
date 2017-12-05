#include <unistd.h>
#include <sys/types.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{
	pid_t p;
	int i, n=5;
	for (i = 1; i < n; ++i)
	{
		p = fork();
		if(p > 0)
			break;
		printf("Processus %d de pere %d.\n", getpid(), getppid());
		sleep(2);
	}
	sleep(1);
	return 0;
}