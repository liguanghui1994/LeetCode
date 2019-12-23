import java.util.Stack;

public class Trap042 {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        new Trap042().trap(height);
    }

    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0, len = height.length; i< len; i++){
            while (!stack.empty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                sum = sum + Math.min(height[i], height[top])*(i - top);
            }
            stack.push(i);
        }
        return sum;
    }
}
