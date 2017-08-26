# Problem

The awards committee of your alma mater (i.e. your college/university) asked for your assistance with a budget allocation problem they’re facing. Originally, the committee planned to give `N` research grants this year. However, due to spending cutbacks, the budget was reduced to `newBudget` dollars and now they need to reallocate the grants. The committee made a decision that they’d like to impact as few grant recipients as possible by applying a maximum `cap` on all grants. Every grant initially planned to be higher than `cap` will now be exactly `cap` dollars. Grants less or equal to `cap`, obviously, won’t be impacted.

Given an array `grantsArray` of the original grants and the reduced budget `newBudget`, write a function `findGrantsCap` that finds in the most efficient manner a cap such that the least number of recipients is impacted and that the new budget constraint is met (i.e. sum of the `N` reallocated grants equals to `newBudget`).

# Example

```
input:  grantsArray = [2, 100, 50, 120, 1000], newBudget = 190
output: 47 # and given this cap the new grants array would be [2, 47, 47, 47, 47]. Notice that the sum of the new grants is indeed 190
```
# Answer

To solve this problem, we start by checking whether one of the values in `grantsArray` can be the cap. To do so systematically, we first sort the array in a descending order, and then check the grants one by one, from largest to smallest. Said differently, If a grant `grantsArray[i]` is not sufficient as a cap since it doesn’t allow us to meet the `newBudget` constraint, we move on to the next grant `grantsArray[i+1]`. We continue using smaller and smaller grants as potential caps until we either meet the budget constraint or go below it.

If none of the `grantsArray` values helped us meet the new budget constraint, then by definition `cap` is less than the smallest grant, i.e. `0 < cap < grantsArray[0]`. To accommodate this special case, we’ll append for convenience the value `0` to the `grantsArray`. This will make our calculations easier. This of it as the `N+1` grant only with the value of `0`.

Now, clearly there is no guarantee that any of the values in `grantsArray` equals to `cap`. However, what the iteration above helped us do is find a tight lower bound to cap from which we’ll be able to calculate `cap`.

Here’s how we do it. We first define a new variable `surplus` which represents the excess amount we need to cut back i.e. `surplus = sum(grantsArray) - newBudget`. Next, we iteratively subtract from `surplus` the amount each grant in `grantsArray` saves us if it were `cap`. Our goal is to find the first for which such `surplus == 0`. Here’s how the first few iterations would look like:

```
surplus1 = surplus0 - 1*(grantsArray[0]-grantsArray[1]).
surplus2 = surplus1 - 2*(grantsArray[1]-grantsArray[2]).
surplus3 = surplus2 - 3*(grantsArray[2]-grantsArray[3]).
```

Notice that we multiply the difference, let’s name it di , between two consecutive grants by `i+1` since at every iteration, each of the `(i+1)` previous grants now needs be lowered by di. The total amount saved is therefore (i+1) * di . The above last step helped us find only a tight lower bound to `cap` and not necessarily `cap` itself. But that could be easily fixed. Since `surplus` at this point is either `0` or less than `0`, we simply take the absolute of that value, i.e. `-surplus`, divide it by `(i+1)`, and add the result to the lower bound we found.

# Time and Space Complexity

Time Complexity: sorting the grants array takes `O(N⋅log(N))`, calculating the surplus is `O(N)` due to the grants summation, and finally the for loop takes another `O(N)`. In total, the time complexity is `O(N⋅log(N))` before sorting and `O(N)` after sorting.

Space Complexity: throughout the algorithm we used only a constant amount of auxiliary space. The space complexity is therefore `O(1)`.

