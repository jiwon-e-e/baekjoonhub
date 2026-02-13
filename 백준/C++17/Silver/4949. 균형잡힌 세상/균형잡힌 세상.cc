#include <stdio.h>
#pragma warning (disable:4996)

#define MAX_STACK_SIZE 100

typedef struct {
   char data[MAX_STACK_SIZE];
   int top;
}StackType;

void init(StackType* s) { s->top = -1; }

int is_empty(StackType* s) {
   return (s->top == -1);
}

void push(StackType* s, char ch) {
   s->data[++(s->top)] = ch;
}

char pop(StackType* s) {
   return s->data[(s->top)--];
}

int is_match(StackType* s, char ch) {
   if (s->data[s->top] == '[' && ch == ']') { return 1; }
   if (s->data[s->top] == '(' && ch == ')') { return 1; }
   else return 0;
}

int main(void) {

   StackType s;
   char arr[102] = { '\0' };

   while (fgets(arr, sizeof(arr), stdin)) {
      init(&s);

      int i = 0;
      for (; *(arr + i) != '.'; i++) {
         char ch = *(arr + i);
         if (ch == '[' || ch == '(') {
            push(&s, ch);
         }
         if (ch == ']' || ch == ')') {
            if (is_empty(&s)) { push(&s, '\0'); break; }
            if (!is_match(&s, ch)) { break; }
            pop(&s);
         }
      }
      if (i == 0 && *(arr + i) == '.') { break; }
      printf(is_empty(&s) ? "yes\n" : "no\n");
   }

   return 0;
}
