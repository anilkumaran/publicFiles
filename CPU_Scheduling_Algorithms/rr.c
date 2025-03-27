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

// struct Process clone_process(struct Process p, int n) {
//     struct Process cloned_p[n];
//     for(int i=0; i<n; i++) {
//         cloned_p[i] = p[i];
//     }
//     return cloned_p;
// }

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


void deleteFirstElement(int arr[], int *n) {
    for (int i = 1; i < *n; i++) {
        arr[i - 1] = arr[i];  // Shift elements left
    }
    (*n)--; // Reduce array size
}


int binarySearch(int arr[], int left, int right, int key) {
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == key) return 1;  // Element found
        if (arr[mid] < key) left = mid + 1;
        else right = mid - 1;
    }
    return 0;  // Element not found
}

int allZeros(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        if (arr[i] != 0) {
            return 0; // Return false if any element is non-zero
        }
    }
    return 1; // Return true if all elements are zero
}


void printArray(int arr[], char name[]) {
    int n = sizeof(arr)/sizeof(arr[0]);
    printf("\nPrinting %s: ", name);
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
}

void round_robin(struct Process proc[], struct Process p[], int n, int TQ){
    int ready_queue[100], RQ_counter = 0;   // [P1, P2]
    
    int Rem_BT[n];  // Store remaining burst times
    for (int i = 0; i < n; i++) {
        Rem_BT[i] = proc[i].BT;
    }
    int Rem_BT_size = sizeof(Rem_BT) / sizeof(Rem_BT[0]);
    int Rem_BT_has_all_zeros = allZeros(Rem_BT, Rem_BT_size);

    int time = p[0].AT;
    int done = 0;


    // while (done < n) {
    //     time = proc[0].AT;
    //     ready_queue[RQ_counter] = p[i].PID;
    //     RQ_counter += 1;

    int i = 0;
    while(!Rem_BT_has_all_zeros) {
        if (i == n) {
            i = 0;  // Start from 0 again
        }
        printArray(Rem_BT, "Rem_BT");
        printArray(ready_queue, "ready_queue");

        if (i == 4) {
            scanf("\nHalt");
        }
        if (Rem_BT[i] > 0) {
            printf("\n------Processing i=%d", i);
            int ready_queue_size = sizeof(ready_queue) / sizeof(ready_queue[0]);
            if (p[i].BT > TQ) {
                // CALC TIMES
                time += TQ;
                Rem_BT[i] -= TQ;

                // push to ready queue
                // ready_queue[RQ_counter] = p[i].PID;
                for(int j=i; j<n; j++) {
                    if( p[i].AT <=time & (!binarySearch(ready_queue, 0, ready_queue_size, p[i].PID)) ) {
                    // if(Rem_BT[i] > 0) {
                        printf("\nAdding PID: %d to RQ", p[j].PID);
                        ready_queue[RQ_counter] = p[i].PID;
                        RQ_counter ++;
                    }
                }

                deleteFirstElement(ready_queue, &ready_queue_size);
                RQ_counter --;
                ready_queue[RQ_counter] = p[i].PID;
                RQ_counter ++;

            } else {
                time += p[i].BT;
                Rem_BT[i] -= Rem_BT[i];
                proc[i].CT = time;
                proc[i].TAT = proc[i].CT - proc[i].AT;
                proc[i].WT = proc[i].TAT - proc[i].BT;

                deleteFirstElement(ready_queue, &ready_queue_size);
                RQ_counter --;
                // done++;
            }
            // }
            Rem_BT_size = sizeof(Rem_BT) / sizeof(Rem_BT[0]);
            Rem_BT_has_all_zeros = allZeros(Rem_BT, Rem_BT_size);
            i++;
        }
    }
    // }

    // Print Results
    printf("\nPID\tAT\tBT\tCT\tTAT\tWT\n");
    for (int i = 0; i < n; i++) {
        printf("%d\t%d\t%d\t%d\t%d\t%d\n", proc[i].PID, proc[i].AT, proc[i].BT, proc[i].CT, proc[i].TAT, proc[i].WT);
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
    // int n, TQ;
    // struct Process proc[MAX];
    // printf("Enter number of processes: ");
    // scanf("%d", &n);
    // printf("Enter time quantum: ");
    // scanf("%d", &TQ);
    // for(int i=0; i<n; i++) {
    //     proc[i].PID = i+1;
    //     printf("Enter AT of process %d: ", proc[i].PID);
    //     scanf("%d", &proc[i].AT);
    //     printf("Enter BT of process %d: ", proc[i].PID);
    //     scanf("%d", &proc[i].BT);
    // }

    int n = 6, TQ=4;
    struct Process proc[6] = {
        {1, 0,	5,  0, 0, 0},
        {2, 1,	6,  0, 0, 0},
        {3, 2,	3,  0, 0, 0},
        {4, 3,	1,  0, 0, 0},
        {5, 4,	5,  0, 0, 0},
        {6, 6,	4,  0, 0, 0}
    };

    // printf("Before Sorting:\n");
    // display(proc, n);
    sortByArrivalTime(proc, n);
    printf("\nAfter Sorting by Arrival Time:\n");
    display(proc, n);

    // Clone it
    struct Process cloned_p[6];
    for(int i = 0; i < 6; i++) {
        cloned_p[i] = proc[i];
    }

    round_robin(proc, cloned_p, n, TQ);
    printf("\n\nAfter Round Robin:\n");
    display(proc, n);

    sortByProcessId(proc, n);
    printf("\n\nAfter Round Robin with PID sort:\n");
    display(proc, n);

    float avg_WT = get_avg_WT(proc, n);
    printf("\nAVG WT=%.2f", avg_WT);
    return 0;
}



// ANSWER SECTION
/*
    Round Robin
    struct Process proc[6] = {
        {1, 0,	5,  0, 0, 0},
        {2, 1,	6,  0, 0, 0},
        {3, 2,	3,  0, 0, 0},
        {4, 3,	1,  0, 0, 0},
        {5, 4,	5,  0, 0, 0},
        {6, 6,	4,  0, 0, 0}
    };

    P1     |   P2   |   P3   |   P4   |   P5   |   P1   |   P6   |   P2   |   P5  |
    0      4        8        11       12       16       17       21       23     24

    PID AT  BT  CT  TAT WT
    1   0   5   17  17  12
    2   1   6   23  22  16
    3   2   3   11  9   6
    4   3   1   12  9   8
    5   4   5   24  20  15
    6   6   4   21  15  11
*/
