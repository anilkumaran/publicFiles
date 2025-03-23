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
int calculate_times(struct Process p[], int i, int timer){
    p[i].CT = timer + p[i].BT;
    p[i].TAT = p[i].CT - p[i].AT;
    p[i].WT = p[i].TAT - p[i].BT;
    timer += p[i].BT;
    return timer;
}

void fcfs(struct Process p[], int n){
    // bool completed = false;
    int timer = p[0].AT;
    printf("\n");
    for(int i=0; i<n; i++) {
        printf("\n-------------------------");
        printf("\nSTART i=%d, p[i].PID=%d, p[i].AT=%d, p[i].CT=%d, timer=%d\n", i, p[i].PID, p[i].AT, p[i].CT, timer);
        if(p[i].AT <= timer) {
            printf("\nIn if\n");
            timer = calculate_times(p, i, timer);
        } else {
            printf("\nIn else\n");
            while (p[i].AT > timer) {
                timer += 1;
            }
            timer = calculate_times(p, i, timer);
        }
        printf("END i=%d, p[i].PID=%d, p[i].AT=%d, p[i].CT=%d, timer=%d\n", i, p[i].PID, p[i].AT, p[i].CT, timer);
        printf("\n-------------------------");
    }
}

float get_avg_WT(struct Process p[], int n) {
    float sum_WT = 0;
    for(int i=0; i<n; i++) {
        sum_WT += p[i].WT;
    }
    return sum_WT/n;
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
    // 1
    // int n = 5;
    // struct Process proc[5] = {
    //     {1, 20,	2,  0, 0, 0},
    //     {2, 30,	2,  0, 0, 0},
    //     {3, 31,	2,  0, 0, 0},
    //     {4, 10,	2,  0, 0, 0},
    //     {5, 50,	2,  0, 0, 0}
    // };

    int n = 3;
    struct Process proc[5] = {
        {1, 0,	10,  0, 0, 0},
        {2, 0,	5,  0, 0, 0},
        {3, 0,	5,  0, 0, 0}
    };

    // printf("Before Sorting:\n");
    // display(proc, n);
    sortByArrivalTime(proc, n);
    printf("\nAfter Sorting by Arrival Time:\n");
    display(proc, n);

    fcfs(proc, n);
    printf("\n\nAfter FCFS:\n");
    display(proc, n);
    
    sortByProcessId(proc, n);
    printf("\n\nAfter FCFS with PID sort:\n");
    display(proc, n);

    float avg_WT = get_avg_WT(proc, n);
    printf("\nAVG WT=%.2f", avg_WT);
    return 0;
}
