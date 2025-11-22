#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <algorithm>
#include <sstream>

using namespace std;

// This function calculates the LIS for a given permutation order
int calculate_max_non_shifted(const vector<char> &s, const string &perm)
{
    char c1 = perm[0];
    char c2 = perm[1];
    char c3 = perm[2];

    int dp1 = 0; // Max length ending in c1
    int dp2 = 0; // Max length ending in c2
    int dp3 = 0; // Max length ending in c3

    for (char c : s)
    {
        if (c == c1)
        {
            dp1 = dp1 + 1;
        }
        else if (c == c2)
        {
            dp2 = max(dp1, dp2) + 1;
        }
        else if (c == c3)
        {
            dp3 = max(dp2, dp3) + 1;
        }
    }

    // The longest subsequence could end in c1, c2, or c3,
    // but the DP logic ensures dp3 holds the max for c1..c2..c3
    // and dp2 holds max for c1..c2, etc.
    // Since we need all 3 groups, we are interested in dp3.
    // A small correction: max(dp1,dp2,dp3) is safer if counts are 0,
    // but the logic `dp3 = max(dp2, dp3) + 1` correctly propagates
    // the max from previous states.
    return dp3;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;
    cin.ignore(); // Consume the newline

    string line;
    getline(cin, line);

    vector<char> s(N);
    map<char, int> counts;
    stringstream ss(line);
    char c;
    for (int i = 0; i < N; ++i)
    {
        ss >> c;
        s[i] = c;
        counts[c]++;
    }

    getline(cin, line);
    stringstream ss_fixed(line);
    int pos;
    vector<pair<int, char>> fixed_items; // <1-based index, char>
    while (ss_fixed >> pos)
    {
        fixed_items.push_back({pos, s[pos - 1]});
    }

    string p = "ABC";
    vector<string> perms;
    sort(p.begin(), p.end());
    do
    {
        perms.push_back(p);
    } while (next_permutation(p.begin(), p.end()));

    int min_shifts = N + 1; // Initialize with an impossible value
    bool found_possible = false;

    for (const string &perm : perms)
    {
        char c1 = perm[0];
        char c2 = perm[1];
        char c3 = perm[2];

        int count1 = counts[c1];
        int count2 = counts[c2];
        int count3 = counts[c3]; // N = count1 + count2 + count3

        bool possible = true;
        for (auto &fixed : fixed_items)
        {
            int p_idx = fixed.first;
            char p_char = fixed.second;

            if (p_char == c1)
            {
                if (p_idx > count1)
                {
                    possible = false;
                    break;
                }
            }
            else if (p_char == c2)
            {
                if (p_idx <= count1 || p_idx > count1 + count2)
                {
                    possible = false;
                    break;
                }
            }
            else if (p_char == c3)
            {
                if (p_idx <= count1 + count2)
                {
                    possible = false;
                    break;
                }
            }
        }

        if (possible)
        {
            found_possible = true;
            int max_non_shifted = calculate_max_non_shifted(s, perm);
            min_shifts = min(min_shifts, N - max_non_shifted);
        }
    }

    if (!found_possible)
    {
        cout << "Impossible" << "\n";
    }
    else
    {
        cout << min_shifts << "\n";
    }

    return 0;
}