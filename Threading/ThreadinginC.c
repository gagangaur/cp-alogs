#include <stdio.h>
#include <unistd.h>
#include <pthread.h>
void *threadfunction(void *vargp){
  sleep(1);
  for(int i=0;i<5;i++){
    sleep(1);
  printf("THIS IS INSIDE THE THREAD FUNCTION %d\n",i+1);
  }
  return NULL;
}
int main(void) {
  pthread_t thread1;
  pthread_t thread2;
  pthread_create(&thread1, NULL, threadfunction, NULL);
  pthread_create(&thread2, NULL, threadfunction, NULL);
  pthread_join(thread1, NULL);
  pthread_join(thread2, NULL);
  return 0;
}