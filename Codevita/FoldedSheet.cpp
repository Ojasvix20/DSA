#include <iostream>
#include <vector>
#include <string>
#include <sstream>
#include <algorithm>
using namespace std;

int main() {
    int R, C;
    cin >> R >> C;
    string rest;
    getline(cin, rest); // Read rest of the line
    string instr_line;
    getline(cin, instr_line);

    vector<vector<vector<int>>> grid(R, vector<vector<int>>(C));
    for (int r = 0; r < R; ++r)
        for (int c = 0; c < C; ++c)
            grid[r][c] = {r * C + (c + 1)}; // Cell numbers 1...RC

    stringstream ss(instr_line);
    string s;
    while (ss >> s) {
        char t = s[0];
        int k = stoi(s.substr(1));
        if (t == 'v' || t == 'V') {
            int j = C - k;
            vector<vector<vector<int>>> ng(R, vector<vector<int>>(max(j, C - j)));
            for (int r = 0; r < R; ++r)
                for (int d = 0; d < max(j, C - j); ++d) {
                    int l = j - 1 - d, ri = j + d;
                    vector<int> combined;
                    if (ri >= 0 && ri < C) {
                        vector<int> rhs = grid[r][ri];
                        reverse(rhs.begin(), rhs.end());
                        combined = rhs;
                    }
                    if (l >= 0 && l < C) {
                        vector<int> lhs = grid[r][l];
                        combined.insert(combined.end(), lhs.begin(), lhs.end());
                    }
                    ng[r][d] = combined;
                }
            grid = ng;
            C = grid[0].size();
        } else if (t == 'h' || t == 'H') {
            int j = k;
            vector<vector<vector<int>>> ng(max(j, R - j), vector<vector<int>>(C));
            for (int d = 0; d < max(j, R - j); ++d)
                for (int c = 0; c < C; ++c) {
                    int u = j - 1 - d, b = j + d;
                    vector<int> combined;
                    if (b >= 0 && b < R) {
                        vector<int> bs = grid[b][c];
                        reverse(bs.begin(), bs.end());
                        combined = bs;
                    }
                    if (u >= 0 && u < R) {
                        vector<int> us = grid[u][c];
                        combined.insert(combined.end(), us.begin(), us.end());
                    }
                    ng[d][c] = combined;
                }
            grid = ng;
            R = grid.size();
        }
    }

    int top = -1, bottom = -1;
    for (int r = 0; r < R; ++r)
        for (int c = 0; c < C; ++c)
            if (!grid[r][c].empty()) {
                top = grid[r][c].front();
                bottom = grid[r][c].back();
            }
    cout << top << " " << bottom << endl;
}
