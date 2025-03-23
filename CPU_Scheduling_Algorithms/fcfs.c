#include <stdio.h>
#define MAX 10

/*
        PID AT  BT  CT  TAT WT
        1   2   6   0   0   0
        2   5   3   0   0   0
        3   1   8   0   0   0
        4   0   3   3   0   0
        5   4   4   0   0   0

        Gantt
        Idle    P1
        0       3

        TAT = CT - AT
        WT = TAT - BT
*/
struct Process {
    int PID, AT, BT, CT, TAT, WT;
};


void display(struct Process p[], int n) {
    printf("\nPID\t\t|Arrival\t|Burst\t\t|Complete\t|TurnAround\t|Waiting\t\t");
    for(int i=0; i<n; i++) {
        printf("\n%d\t\t|%d\t\t\t|%d\t\t\t|%d\t\t\t|%d\t\t\t|%d", p[i].PID, p[i].AT, p[i].BT, p[i].CT, p[i].TAT, p[i].WT);
    }
}

void swap(struct Process *a, struct Process *b) {
    struct Process temp = *a;
    *a = *b;
    *b = temp;
}

void sortByProcessId(struct Process proc[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (proc[j].PID > proc[j + 1].PID) {
                swap(&proc[j], &proc[j + 1]);
            }
        }
    }
}

void sortByArrivalTime(struct Process proc[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (proc[j].AT > proc[j + 1].AT) {
                swap(&proc[j], &proc[j + 1]);
            }
        }
    }
}
void fcfs(struct Process p[], int n){
    // bool completed = false;
    int timer = p[0].AT;
    printf("\n");
    for(int i=0; i<n; i++) {
        // if (i == n-1) {
        //     struct Process next_proc = p[i];
        // } else {
        //     struct Process next_proc = p[i+1];
        // }
        // printf("\nSTART i=%d, p[i].PID=%d, p[i].AT=%d, timer=%d\n", i, p[i].PID, p[i].AT, timer);
        if(p[i].AT <= timer) {
            printf("\nIn if\n");
            p[i].CT = timer + p[i].BT;
            p[i].TAT = p[i].CT - p[i].AT;
            p[i].WT = p[i].TAT - p[i].BT;
            timer += p[i].BT;
        } else {
            printf("\nIn else\n");
            timer += 1;
        }
        // printf("END i=%d, p[i].PID=%d, p[i].AT=%d, timer=%d\n", i, p[i].PID, p[i].AT, timer);
    }
}


int main() {
    // int n;
    // struct Process proc[MAX];
    // printf("Enter number of processes: ");
    // scanf("%d", &n);
    // for(int i=0; i<n; i++) {
    //     proc[i].PID = i+1;
    //     printf("Enter AT of process %d: ", proc[i].PID);
    //     scanf("%d", &proc[i].AT);
    //     printf("Enter BT of process %d: ", proc[i].PID);
    //     scanf("%d", &proc[i].BT);
    // }
    struct Process proc[5] = {
        {1, 2, 6,  0, 0, 0},
        {2, 5, 3,  0, 0, 0},
        {3, 1, 8,  0, 0, 0},
        {4, 0, 3,  0, 0, 0},
        {5, 4, 4,  0, 0, 0}
    };

    int n = 5;

    // printf("Before Sorting:\n");
    // display(proc, n);

    sortByArrivalTime(proc, n);

    printf("\nAfter Sorting by Arrival Time:\n");
    display(proc, n);

    fcfs(proc, n);
    sortByProcessId(proc, n);
    printf("\n\nAfter FCFS - Sort by PID:\n");
    display(proc, n);

    return 0;
}
