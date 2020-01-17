import java.util.Stack;

public class LargestRectangleArea084 {

    private int maxArea = 0;
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return maxArea;
        }
        Stack<Integer> xpoints = new Stack<>();
        for (int i = 0, len = heights.length; i < len ; i++) {
            while (!xpoints.isEmpty() &&  heights[i] < heights[xpoints.peek()]){
                int j = xpoints.pop();
                maxArea = Math.max(maxArea, xpoints.isEmpty()?i*heights[j]:(i-xpoints.peek())*heights[j]);
            }
            xpoints.push(i);
        }
        while (!xpoints.isEmpty()){
            int j = xpoints.pop();
            maxArea = Math.max(maxArea, xpoints.isEmpty()?heights.length*heights[j]:(heights.length-xpoints.peek())*heights[j]);
        }
        return maxArea;
    }

    public static void main(String[] args){
        int[] heights = new int[]{2,1,2};
        new LargestRectangleArea084().largestRectangleArea(heights);
    }

}
