# AFinterviewQ

## substractLists O(n) - Return a List of Pairs on A but not in B - 
### substractListsHashSolution - HashSet SOlution - with at O(nm) [m - the pair size mostly (hashcode))- 
 if used frequently can be improved to O(n) with a wraper for Pair with Cahing the hashCode result instead of calcualting it evrey time.
### substractListsShortCode - uses java removeAll - O(n^2)
### substractListsPlain - nested loop - o(n^2)
Tests - Checking empty lists, single items, non-intersecting, partial intersection, and full intersection
Also did some performance testing - Hash won by a landslide... 
he managed to process 4 milion items lists in 1/3 or better  the time the others took to proccess 40k!
Performance test attached at the bottom

## cosine similarty at O(n) - NOTE: in case of using non-A-Za-z or other String HashCode Fails - 
HashCode method should be overriden to a better one.
Tested empty, one word longer phrases with no match partial match and full match.

### Substraction performance test result
substractListsHashSolution 40,000 multi A and multi items B intersecting - LINKED_LIST - took 22ms
substractListsHashSolution 4,000,000 multi A and multi items B intersecting - LINKED_LIST - took 765ms
substractListsHashSolution 40,000 multi A and multi items B intersecting - ARRAY_LIST - took 6ms
substractListsHashSolution 4,000,000 multi A and multi items B intersecting - ARRAY_LIST - took 522ms
substractListsHashSolution 40,000 multi A and multi items B intersecting - STACK - took 18ms
substractListsHashSolution 4,000,000 multi A and multi items B intersecting - STACK - took 566ms
substractListsHashSolution 40,000 multi A and multi items B intersecting - VECTOR - took 13ms
substractListsHashSolution 4,000,000 multi A and multi items B intersecting - VECTOR - took 2590ms
substractListsPlain 40,000 multi A and multi items B intersecting - LINKED_LIST - took 6891ms
substractListsPlain 40,000 multi A and multi items B intersecting - ARRAY_LIST - took 5121ms
substractListsPlain 40,000 multi A and multi items B intersecting - STACK - took 8122ms
substractListsPlain 40,000 multi A and multi items B intersecting - VECTOR - took 8010ms
substractListsShortCode 40,000 multi A and multi items B intersecting - LINKED_LIST - took 7276ms
substractListsShortCode 40,000 multi A and multi items B intersecting - ARRAY_LIST - took 2222ms
substractListsShortCode 40,000 multi A and multi items B intersecting - STACK - took 2196ms
substractListsShortCode 40,000 multi A and multi items B intersecting - VECTOR - took 2224ms
