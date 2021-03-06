# leetcode
HashMap问题
https://github.com/jianqianzhou/leetcode/blob/main/000.twoSum.java（两数之和）
https://github.com/jianqianzhou/leetcode/blob/main/454.fourSumCount.java（map先存放前两个数组的值，然后遍历后两个数组，四数相加）

滑动窗口问题 
https://github.com/jianqianzhou/leetcode/blob/main/003.lengthOfLongestSubstring.java

双指针问题
https://github.com/jianqianzhou/leetcode/blob/main/009.isPalindrome.java
https://github.com/jianqianzhou/leetcode/blob/main/125.isPalindrome.java（判断是否回文）
https://github.com/jianqianzhou/leetcode/blob/main/011.maxArea.java
https://github.com/jianqianzhou/leetcode/blob/main/015.threeSum.java （三数之和）
https://github.com/jianqianzhou/leetcode/blob/main/018.fourSum.java（四数之和）
https://github.com/jianqianzhou/leetcode/blob/main/016.threeSumClosest.java
https://github.com/jianqianzhou/leetcode/blob/main/026.removeDuplicates.java
https://github.com/jianqianzhou/leetcode/blob/main/042.trap.java
https://github.com/jianqianzhou/leetcode/blob/main/075.sortColors.java(颜色分类)
https://github.com/jianqianzhou/leetcode/blob/main/344.reverseString.java（反转字符串）

字符串操作问题
https://github.com/jianqianzhou/leetcode/blob/main/008.myAtoi.java(转出字符串)
https://github.com/jianqianzhou/leetcode/blob/main/013.romanToInt.java(罗马数字转整数)
https://github.com/jianqianzhou/leetcode/blob/main/028.strStr.java（substring函数）
https://github.com/jianqianzhou/leetcode/blob/main/043.multiply.java（字符串相乘）
https://github.com/jianqianzhou/leetcode/blob/main/067.addBinary.java（字符串二进制数相加）
https://github.com/jianqianzhou/leetcode/blob/main/058.lengthOfLastWord.java(最后一个字符长度)
https://github.com/jianqianzhou/leetcode/blob/main/049.groupAnagrams.java(字符串异位统计)
https://github.com/jianqianzhou/leetcode/blob/main/242.isAnagram.java（判断字符串是否异位）

实现数学公式
https://github.com/jianqianzhou/leetcode/blob/main/050.myPow.java(实现幂运算)
https://github.com/jianqianzhou/leetcode/blob/main/069.mySqrt.java（实现平方根）

动态规划问题
https://github.com/jianqianzhou/leetcode/blob/main/005.longestPalindrome.java  dp[i][j] = s[i]==s[j] && dp[i+1][j-1]
https://github.com/jianqianzhou/leetcode/blob/main/044.isMatch.java  dp[i][j]=dp[i−1][j−1], dp[i][j]=dp[i][j−1]∨dp[i−1][j]
https://github.com/jianqianzhou/leetcode/blob/main/115.numDistinct.java (不同的子序列) dp[i][j]=dp[i-1][j-1]+dp[i][j-1], dp[i][j]=dp[i][j-1];
https://github.com/jianqianzhou/leetcode/blob/main/070.climbStairs.java（爬楼梯, dp[i]=dp[i-1]+dp[i-2]）
https://github.com/jianqianzhou/leetcode/blob/main/053.maxSubArray.java(最大连续和数组，dp[i] = Math.max(dp[i-1]+nums[i],nums[i]))
https://github.com/jianqianzhou/leetcode/blob/main/064.minPathSum.java(正方形最小路径和 dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j];)
https://github.com/jianqianzhou/leetcode/blob/main/120.minimumTotal.java（三角形最小路径和 dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]+triangle[i][j]）
https://github.com/jianqianzhou/leetcode/blob/main/096.numTrees.java（二叉搜索树数目 dp[i] += dp[i-j]*dp[j-1]）
https://github.com/jianqianzhou/leetcode/blob/main/121.maxProfit.java（买卖股票，dp[i]=prices[i]-min）
https://github.com/jianqianzhou/leetcode/blob/main/062.uniquePaths.java（唯一路径 dp[i][j]=dp[i-1][j]+dp[i][j-1]）
https://github.com/jianqianzhou/leetcode/blob/main/198.rob.java(打家劫舍 dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]))
https://github.com/jianqianzhou/leetcode/blob/main/213.rob.java（打家劫舍 ）
https://github.com/jianqianzhou/leetcode/blob/main/300.lengthOfLIS.java（最长递增子序列 dp[i] = Math.max(dp[j]+1,dp[i])）

栈
https://github.com/jianqianzhou/leetcode/blob/main/032.longestValidParentheses.java（最长括号匹配）
https://github.com/jianqianzhou/leetcode/blob/main/020.isValid.java（字符串匹配、栈操作）

链表问题
https://github.com/jianqianzhou/leetcode/blob/main/002.addTwoNumbers.java
https://github.com/jianqianzhou/leetcode/blob/main/019.removeNthFromEnd.java(删除链表的节点)
https://github.com/jianqianzhou/leetcode/blob/main/021.mergeTwoLists.java(合并两个链表，按照大小顺序合并)
https://github.com/jianqianzhou/leetcode/blob/main/023.mergeKLists.java(合并k个有序链表,分治合并排序算法)
数字操作问题
https://github.com/jianqianzhou/leetcode/blob/main/007.reverse.java
https://github.com/jianqianzhou/leetcode/blob/main/024.swapPairs.java(链表两两交换)
https://github.com/jianqianzhou/leetcode/blob/main/025.reverseKGroup.java（k个链表反转）
https://github.com/jianqianzhou/leetcode/blob/main/206.reverseList.java(反转链表)
https://github.com/jianqianzhou/leetcode/blob/main/092.reverseBetween.java（反转区间链表）
https://github.com/jianqianzhou/leetcode/blob/main/445.addTwoNumbers.java（栈与链表结合）
https://github.com/jianqianzhou/leetcode/blob/main/203.removeElements.java（移除相等元素）
快慢指针用处：
（1）判断链表是否有环
（2）判断入环点
（3）获取链表的中间节点
https://github.com/jianqianzhou/leetcode/blob/main/141.hasCycle.java（检测链表是否有环）
https://github.com/jianqianzhou/leetcode/blob/main/142.detectCycle.java（检测链表是否有环、并判断入环的位置）
https://github.com/jianqianzhou/leetcode/blob/main/148.sortList.java(链表排序)
https://github.com/jianqianzhou/leetcode/blob/main/143.reorderList.java（交叉重新排序）
https://github.com/jianqianzhou/leetcode/blob/main/086.partition.java（分割链表）
https://github.com/jianqianzhou/leetcode/blob/main/083.deleteDuplicates.java(删除排序链表重复元素)
https://github.com/jianqianzhou/leetcode/blob/main/082.deleteDuplicates.java（删除重复元素）
https://github.com/jianqianzhou/leetcode/blob/main/234.isPalindrome.java（判断链表是否是回文）
旋转链表
https://github.com/jianqianzhou/leetcode/blob/main/061.rotateRight.java

贪心策略
https://github.com/jianqianzhou/leetcode/blob/main/012.intToRoman.java
https://github.com/jianqianzhou/leetcode/blob/main/055.canJump.java
https://github.com/jianqianzhou/leetcode/blob/main/122.maxProfit.java（股票最大收益）

回溯算法
https://github.com/jianqianzhou/leetcode/blob/main/017.letterCombinations.java
https://github.com/jianqianzhou/leetcode/blob/main/022.generateParenthesis.java(括号生成)
https://github.com/jianqianzhou/leetcode/blob/main/046.permute.java（全排列）
https://github.com/jianqianzhou/leetcode/blob/main/077.combine.java(n个数的k个组合)
https://github.com/jianqianzhou/leetcode/blob/main/078.subsets.java（求集合的各个子集组合）
https://github.com/jianqianzhou/leetcode/blob/main/090.subsetsWithDup.java（求子集合，原来的集合包含重复的元素）
https://github.com/jianqianzhou/leetcode/blob/main/095.generateTrees.java（生成二叉搜索树）

移除重复元素
https://github.com/jianqianzhou/leetcode/blob/main/026.removeDuplicates.java
https://github.com/jianqianzhou/leetcode/blob/main/027.removeElement.java

二分查找
https://github.com/jianqianzhou/leetcode/blob/main/035.searchInsert.java
https://github.com/jianqianzhou/leetcode/blob/main/033.search.java(旋转数组查找，元素不会出现重复)
https://github.com/jianqianzhou/leetcode/blob/main/081.search.java(旋转数组查找，元素会出现重复值)
https://github.com/jianqianzhou/leetcode/blob/main/034.searchRange.java
https://github.com/jianqianzhou/leetcode/blob/main/074.searchMatrix.java（二维数组二分查找）
https://github.com/jianqianzhou/leetcode/blob/main/069.mySqrt.java（实现平方根）
https://github.com/jianqianzhou/leetcode/blob/main/378.kthSmallest.java（第k小的数）

位运算
https://github.com/jianqianzhou/leetcode/blob/main/029.divide.java
https://github.com/jianqianzhou/leetcode/blob/main/136.singleNumber.java(异或运算，查看元素是否单一)
https://github.com/jianqianzhou/leetcode/blob/main/371.getSum.java（两数相加）
https://github.com/jianqianzhou/leetcode/blob/main/191.hammingWeight.java（统计1的个数）

数组操作
https://github.com/jianqianzhou/leetcode/blob/main/031.nextPermutation.java
https://github.com/jianqianzhou/leetcode/blob/main/041.firstMissingPositive.java
https://github.com/jianqianzhou/leetcode/blob/main/048.rotate.java（旋转数组）
https://github.com/jianqianzhou/leetcode/blob/main/054.spiralOrder.java（螺旋输出数组）
https://github.com/jianqianzhou/leetcode/blob/main/059.generateMatrix.java（生成螺旋矩阵）
https://github.com/jianqianzhou/leetcode/blob/main/066.plusOne.java（数组加1）
https://github.com/jianqianzhou/leetcode/blob/main/073.setZeroes.java(数组设置为0)
https://github.com/jianqianzhou/leetcode/blob/main/080.removeDuplicates.java（移除数组重复元素）
https://github.com/jianqianzhou/leetcode/blob/main/088.merge.java(合并两个排序数组)
https://github.com/jianqianzhou/leetcode/blob/main/056.merge.java（合并区间）
https://github.com/jianqianzhou/leetcode/blob/main/283.moveZeroes.java（移动非零元素）
https://github.com/jianqianzhou/leetcode/blob/main/250.intersect.java（数组交集）

回溯
https://github.com/jianqianzhou/leetcode/blob/main/039.combinationSum.java(无重复元素的数组 解集不能包含重复的组合)
https://github.com/jianqianzhou/leetcode/blob/main/040.combinationSum2.java（有重复元素的数组 解集不能包含重复的组合）
https://github.com/jianqianzhou/leetcode/blob/main/077.combine.java（n之间的k个组合数）
https://github.com/jianqianzhou/leetcode/blob/main/047.permuteUnique.java（有重复元素，求无重复元素和重复组合的全排列）
https://github.com/jianqianzhou/leetcode/blob/main/131.partition.java（字符串分割）

树的遍历
https://github.com/jianqianzhou/leetcode/blob/main/094.inorderTraversal.java（中序遍历，使用栈Stack，先进后出）
https://github.com/jianqianzhou/leetcode/blob/main/102.levelOrder.java（层序遍历，使用队列LinkedList，先进先出）
https://github.com/jianqianzhou/leetcode/blob/main/103.zigzagLevelOrder.java（锯齿状遍历，使用队列LinkedList，先进先出）
https://github.com/jianqianzhou/leetcode/blob/main/107.levelOrderBottom.java（从后往前层序遍历，使用队列LinkedList，先进先出）
https://github.com/jianqianzhou/leetcode/blob/main/145.postorderTraversal.java(后序遍历，使用栈Stack，先进后出)
https://github.com/jianqianzhou/leetcode/blob/main/144.preorderTraversal.java(前序遍历，使用栈Stack，先进先出)
https://github.com/jianqianzhou/leetcode/blob/main/199.rightSideView.java(右边视角遍历)
https://github.com/jianqianzhou/leetcode/blob/main/112.hasPathSum.java(使用层序遍历来计算累计和)
https://github.com/jianqianzhou/leetcode/blob/main/113.pathSum.java（回溯（dfs 深度优先遍历递归的方式）和层序遍历（非递归的方式）
https://github.com/jianqianzhou/leetcode/blob/main/129.sumNumbers.java（树节点和，dfs和层序遍历）
https://github.com/jianqianzhou/leetcode/blob/main/230.kthSmallest.java（二叉搜索树第k小的值）
https://github.com/jianqianzhou/leetcode/blob/main/235.lowestCommonAncestor.java（二叉搜索树最近公共祖先）
https://github.com/jianqianzhou/leetcode/blob/main/236.lowestCommonAncestor.java（二叉树最近公共祖先）
https://github.com/jianqianzhou/leetcode/blob/main/450.deleteNode.java（删除二叉搜索树的节点）

判断树的结构
https://github.com/jianqianzhou/leetcode/blob/main/100.isSameTree.java（判断两颗树是否相同，深度（递归遍历）、广度优先遍历（队列））
https://github.com/jianqianzhou/leetcode/blob/main/101.isSymmetric.java（判断树是否是对称的）
https://github.com/jianqianzhou/leetcode/blob/main/110.isBalanced.java（判断树是否是平衡二叉树）
https://github.com/jianqianzhou/leetcode/blob/main/098.isValidBST.java(判断树是否是二叉搜索树)
求树的深度、高度
https://github.com/jianqianzhou/leetcode/blob/main/104.maxDepth.java（二叉树的最大深度）
https://github.com/jianqianzhou/leetcode/blob/main/111.minDepth.java（二叉树的最小深度）
构造树
https://github.com/jianqianzhou/leetcode/blob/main/108.sortedArrayToBST.java（数组构造二叉搜索树）
https://github.com/jianqianzhou/leetcode/blob/main/109.sortedListToBST.java（链表构造二叉搜索树，快慢指针）
https://github.com/jianqianzhou/leetcode/blob/main/105.buildTree.java（前序和中序遍历构造二叉树）
https://github.com/jianqianzhou/leetcode/blob/main/106.buildTree.java（后序和中序遍历构造二叉树）
树的转变
https://github.com/jianqianzhou/leetcode/blob/main/114.flatten.java（树转为链表）
https://github.com/jianqianzhou/leetcode/blob/main/116.connect.java(完美二叉树每一层转为链表)
https://github.com/jianqianzhou/leetcode/blob/main/117.connect.java（二叉树每一层转为链表）

杨辉三角形
https://github.com/jianqianzhou/leetcode/blob/main/118.generate.java（list集合操作）
https://github.com/jianqianzhou/leetcode/blob/main/119.getRow.java（获取行操作）

数据结构设计类
https://github.com/jianqianzhou/leetcode/blob/main/146.LRUCache.java(LRU缓存策略，使用LinkedHashMap)
https://github.com/jianqianzhou/leetcode/blob/main/706.MyHashMap.java(设计HashMap，使用新创建的数据结构Node)
https://github.com/jianqianzhou/leetcode/blob/main/705.MyHashSet.java(使用LinkedList设计，同时加入数组提高缓存命中率)
https://github.com/jianqianzhou/leetcode/blob/main/380.RandomizedSet.java（常数级别插入、删除、随机访问）

其他
https://github.com/jianqianzhou/leetcode/blob/main/229.majorityElement.java（摩尔投票法）
