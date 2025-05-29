# 0/1 Knapsack Problem

The **0/1 Knapsack Problem** explores the optimal way to fill a knapsack with a limited weight capacity using a set of
items, each with a specific weight and value, such that the total value is maximised without exceeding the weight limit.

## Problem Statement

You are given:
- A list of `n` items, each with:
    - a **weight** `weights[i]`
    - a **value** `values[i]`
- A knapsack with a maximum **capacity** `cap`

**Goal:**
Choose a subset of items such that the **total weight** does not exceed `cap`, and the **total value** is maximised.

**Constraint:** 
Each item can either be included **once** or **not at all** (i.e. 0/1 choice). The weight and value of each item and 
the capacity of the knapsack are integers.

## Hints

**Define DP state and sub-problem:**

`dp[i][w]`: the maximum value that can be achieved using **the first `i` items** with the remaining capacity `w`.

The ultimate goal then is to find `dp[n][cap]`.

**Explore options:**

To solve `dp[i][w]`, for the ith item, we need to consider two options and take the maximum of them:

1. Exclude the ith item:
We don't take the current item. Then the answer is the same as `dp[i-1][w]`.

2. Include the ith item (only if its weight ≤ `w`):
Then we take its value, and reduce the capacity by its weight: `dp[i-1][w - weights[i-1]] + values[i-1]`

**Base case:**

Start with:
`dp[0][w]` = 0 for all `w` — no items means no value.

Build the solution **bottom-up**, solving each smaller sub-problem and using it to solve larger ones.
