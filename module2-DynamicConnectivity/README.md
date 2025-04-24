# Dynamic Union

## Quick-find Eager

Cost model:

| algorithm | initialize | union | find |
|-----------|------------|-------|------|
|quick-find| N          | N     | 1    |

Defect: union is too expensive N^2 array access AKA quadratic

## Quick-Union Lazy

Cost model:

| algorithm   | initialize | union | find |
|-------------|------------|-------|------|
| quick-find  | N          | N     | 1    |
| quick-union | N          | N     | N    |

Union operation still needs to find roots!
Defect: Trees can get tall
Find too expensive

## Quick-Union Improved

### Weighting the tree
-    Weighted Quick Union
- modify quickunion to avoid tall trees.
- keep track of size of tree (number of obj)
- Balance by linkin root of similar small tree to large tree
- The smaller tree always goes below!

Proposition: Depth of any node _x_ is at most(logbasse2 == lg) lg _N_!

Proof:

    When does depth of x increase?
    Increases by 1 when tree T1 containing x is merged into another TreT2.
    - The size of tree containing x at least doubles | T2 | >= |T2|
    - Size of tree containing x can double at most lg N times Why?


Union takes constant time.
Cost model:

| algorithm             | initialize | union | find |
|-----------------------|------------|-------|------|
| quick-find            | N          | N     | 1    |
| quick-union           | N          | N     | N    |
| quick-union- weighted | N          | lg N  | lg N |

### Path Compression

Make a grandparent parent for all children

Weighted quickunion with path compression

Proposition:<br>
    Hopcroft-Ulman, Tarjan<br>
    Starting from an empty data structure, 
any sequence of M union-find ops on N objects makes 
<= c( N + M lg* N) array accesses.

lg* N is how many logbase 2 to get to 1.

| N       | lg* N |
|---------|-------|
| 1       | 0     |
| 2       | 1     |
| 4       | 2     |
| 16      | 3     |
| 65_536  | 4     |
| 2^65536 | 5     |

| algorithm                              | initialize | union | find  |
|----------------------------------------|------------|-------|-------|
| quick-find                             | N          | N     | 1     |
| quick-union                            | N          | N     | N     |
| quick-union- weighted                  | N          | lg N  | lg N  |
| quick-union- weighted path compression | N          | lg* N | lg* N |

## Comments
There is no linear time algorithm (N) for the union find problem.


