# DP on Stocks

Source: Striver's A2Z DSA Sheet, Dynamic Programming. Template: states hold / notHold (plus a transaction count or a cooldown state). Active recall: open the link, solve from scratch, then check the notes.

| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Stock I - one transaction](BestTimeToBuyAndSellStock.md) | [LC 121](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | Running minimum | O(n) |
| 2 | [Stock II - unlimited](BestTimeToBuyAndSellStockII.md) | [LC 122](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/) | Sum of rises, or hold/notHold | O(n) |
| 3 | [Stock III - at most 2](BestTimeToBuyAndSellStockIII.md) | [LC 123](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/) | Four rolling states | O(n) |
| 4 | [Stock IV - at most k](BestTimeToBuyAndSellStockIV.md) | [LC 188](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/) | k layers; big k = unlimited | O(n*k) |
| 5 | [With Cooldown](BestTimeToBuyAndSellStockWithCooldown.md) | [LC 309](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/) | hold / sold / rest | O(n) |
| 6 | [With Transaction Fee](BestTimeToBuyAndSellStockWithFee.md) | [LC 714](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/) | Subtract the fee on sell | O(n) |

## Run any program
```r
javac -d out *.java
java -cp out BestTimeToBuyAndSellStockIII
```
