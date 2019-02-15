#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

bool isMatch(char *s, char *p) {
    if (strlen(p) == 0) {
        return strlen(s) == 0;
    } else {
        bool match = strlen(s) > 0 && (s[0] == p[0] || p[0] == '.');

        if (strlen(p) > 1 && p[1] == '*')
            return isMatch(s, p + 2) || (match && isMatch(s + 1, p));
        else
            return match && isMatch(s + 1, p + 1);
    }
}

int main() {
    char *s = "abc";
    char *p = "a.cd*";
    printf("isMatch(%s, %s): %s\n", s, p, isMatch(s, p) ? "true" : "false");
    return 0;
}