package leetcode;

import java.util.*;

public class ArraySolutions {

    /**
     * n数之和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> nSum(int[] nums) {
        Arrays.sort(nums);
        boolean[] included = new boolean[nums.length];
        Set<List<Integer>> res = new HashSet<>();
        helper(included, nums, 0, 0, 0, res);
        return new ArrayList<>(res);
    }

    private void helper(boolean[] included, int[] nums, int i, int has, int target, Set<List<Integer>> res ) {
        if (i >= nums.length) {
            return;
        }
        if (nums[i] + has == target) {
            included[i] = true;
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if(included[j]) {
                    tmp.add(nums[j]);
                }
            }
            res.add(tmp);
        }

        included[i] = true;
        helper(included, nums, i + 1, has + nums[i], target, res);
        included[i] = false;
        helper(included, nums, i + 1, has, target, res);
    }

    /**
     * 3数之和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        int len = nums.length;
        int target = 0;
        Set<Integer> aimSet = new HashSet<>();

        for( int i = 0; i < len - 2; i++) {
            int aim = target - nums[i];
            if (aimSet.contains(aim)) {
                continue;
            }
            aimSet.add(aim);

            int left = i + 1;
            int right = len - 1;

            if (nums[left] > aim) {
                continue;
            }

            while (left < right) {
                if (nums[left] + nums[right] > aim) {
                    right--;
                }else if(nums[left] + nums[right] < aim) {
                    left++;
                }else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    left++;
                }
            }
        }
        return new ArrayList<>(res);
    }

    /**
     * 岛屿的最大面积
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int width = grid.length;
        int length = grid[0].length;

        int max = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 1) {
                    int cur = dfs(grid, i, j);
                    if (cur > max) {
                        max = cur;
                    }
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j) {
        int area = 0;
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            if (grid[i][j] == 1) {
                grid[i][j] = 0;
                area += 1;
                area += dfs(grid, i, j + 1);
                area += dfs(grid, i, j - 1);
                area += dfs(grid, i - 1, j);
                area += dfs(grid, i + 1, j);
//                List<Integer> t = new ArrayList<>();
//                t.add(dfs(grid, i, j + 1));
//                t.add(dfs(grid, i - 1, j));
//                t.add(dfs(grid, i, j - 1));
//                t.add(dfs(grid, i + 1, j));
//                area += Collections.max(t);
            }
        }
        return area;
    }

    /**
     * 朋友圈
     *
     */
    public int findCircleNum(int[][] M) {

        int res = 0;
        boolean[] visited = new boolean[M.length];

        for (int i = 0; i < M.length; i++) {
            if (visited[i] == false) {
                dfs(M, visited, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] grid, boolean[] visited, int i) {
        visited[i] = true;

        for (int j = 0; j < grid.length; j++) {
            if (visited[j] == false && grid[i][j] == 1) {
                dfs(grid, visited, j);
            }
        }
    }

    /**
     * 接雨水
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        int sum = 0;
        // 寻找全局最高点
        int globalMax = -1;
        int globalMaxIdx = 0;

        for (int i = 0; i < height.length; i++) {
            if (globalMax < height[i]) {
                globalMax = height[i];
                globalMaxIdx = i;
            }
        }

        int localMax = -1;
        // 向全局高点左逼近
        for (int i = 0; i < globalMaxIdx; i++) {
           if (localMax < height[i]) {
               localMax = height[i];   // 寻找局部最高点
           } else {
               sum += localMax - height[i];   // 右侧有全局最高点最为墙，此时局部最高点与当前低位的落差，就是水量增量
           }
        }
        // 向全局高点右逼近
        localMax = -1;
        for (int i = height.length - 1; i > globalMaxIdx; i--) {
            if (localMax < height[i]) {
                localMax = height[i];   // 寻找局部最高点
            } else {
                sum += localMax - height[i];   // 右侧有全局最高点最为墙，此时局部最高点与当前低位的落差，就是水量增量
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new ArraySolutions().threeSum(new int[]{-2, 0, 1, 1, 2}));
    }
}
