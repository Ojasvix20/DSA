#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <tuple>

using namespace std;

// Represents an order
struct Order {
    int a, p, v, id; // arrival, packing_time, vip_status, original_id
};

// Define the type for the priority queue
// We store {arrival, packing_time, id}
// Using 'greater' makes it a min-heap, which sorts by:
// 1. Lowest arrival time
// 2. Lowest packing time
using T = tuple<int, int, int>;

int main() {
    // Optimize C++ I/O
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    if (!(cin >> N)) return 0;

    vector<Order> v(N);
    for (int i = 0; i < N; ++i) {
        cin >> v[i].a >> v[i].p >> v[i].v;
        v[i].id = i;
    }

    // --- Correction 1: Simplified Initial Sort ---
    // We only need to sort by arrival time to add them to the queues
    // in the correct order. The priority queues handle all other logic.
    sort(v.begin(), v.end(), [](const Order& x, const Order& y) {
        return x.a < y.a;
    });

    priority_queue<T, vector<T>, greater<T>> vip_queue;
    priority_queue<T, vector<T>, greater<T>> reg_queue;

    long long currentTime = 0; // Time when the counter becomes free
    int orderIndex = 0;      // Index for the sorted 'v' vector
    int processedCount = 0;  // Counter for processed orders
    vector<pair<int, int>> events; // For the sweep-line algorithm

    // Lambda to push newly arrived orders into the PQs
    auto push_arrivals = [&]() {
        // Add all orders that have arrived by 'currentTime'
        // This 'while' loop is key.
        while (orderIndex < N && v[orderIndex].a <= currentTime) {
            if (v[orderIndex].v == 1) {
                vip_queue.push({v[orderIndex].a, v[orderIndex].p, v[orderIndex].id});
            } else {
                reg_queue.push({v[orderIndex].a, v[orderIndex].p, v[orderIndex].id});
            }
            orderIndex++;
        }
    };


    // --- Simulation Loop ---
    // Loop until all N orders have been processed
    while (processedCount < N) {
        
        // Add any orders that have arrived by the time the counter is free
        push_arrivals();

        // If both queues are empty, the counter is idle.
        // Jump time forward to the next order's arrival.
        if (vip_queue.empty() && reg_queue.empty()) {
            if (orderIndex < N) {
                // Jump time
                currentTime = v[orderIndex].a;
                // Add the order(s) that just arrived
                push_arrivals();
            } else {
                // No more orders to process
                break;
            }
        }
        
        // This should not happen if N > 0, but is a safe check
        if (vip_queue.empty() && reg_queue.empty()) continue;


        int arrivalTime, packingTime, id;

        // Select the next order: VIPs take priority
        if (!vip_queue.empty()) {
            tie(arrivalTime, packingTime, id) = vip_queue.top();
            vip_queue.pop();
        } else {
            tie(arrivalTime, packingTime, id) = reg_queue.top();
            reg_queue.pop();
        }

        // 'currentTime' = when the counter *was* free
        // 'arrivalTime' = when the person *arrived*
        // The order can only *start* processing at the later of these two times.
        long long startTime = max((long long)arrivalTime, currentTime);

        // A chair is needed *only* if the person arrived *before*
        // their order could start.
        if (startTime > arrivalTime) {
            // Event 1: Person arrives, needs a chair
            events.push_back({arrivalTime, +1});
            // Event 2: Person's turn starts, they free the chair
            events.push_back({(int)startTime, -1});
        }

        // The counter is now busy until the order is finished
        currentTime = startTime + packingTime;
        processedCount++;
    }


    // --- Sweep Line (with CRITICAL FIX) ---

    // --- Correction 2: The Critical Sort Fix ---
    // Sort by time (x.first).
    // If times are equal, process arrivals (+1) BEFORE departures (-1).
    // So, we sort 'type' in descending order (x.second > y.second).
    sort(events.begin(), events.end(), [](const pair<int, int>& x, const pair<int, int>& y) {
        if (x.first != y.first) {
            return x.first < y.first;
        }
        return x.second > y.second;
    });

    int currentChairs = 0;
    int maxChairs = 0;
    for (auto& e : events) {
        currentChairs += e.second; // +1 for arrival, -1 for departure
        maxChairs = max(maxChairs, currentChairs);
    }

    cout << maxChairs;
    return 0;
}